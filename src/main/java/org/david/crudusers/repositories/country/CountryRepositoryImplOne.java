package org.david.crudusers.repositories.country;

import org.david.crudusers.models.Continent;
import org.david.crudusers.models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryRepositoryImplOne implements ICountryRepository{

    private Connection conn;

    public CountryRepositoryImplOne(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Country> atList() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (ResultSet resultSet = conn.createStatement().executeQuery("select * from countries")){
            while (resultSet.next()){
                countries.add(createCountry(resultSet));
            }
        }
        return countries;
    }

    @Override
    public Optional<Country> byId(Integer id) throws SQLException {
        Optional<Country> country = Optional.empty();
        try (PreparedStatement pre = conn.prepareStatement("select * from countries where id=?")){
            pre.setInt(1, id);
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()){
                country = Optional.of(createCountry(resultSet));
            }
            resultSet.close();
        }
        return country;
    }

    @Override
    public Country save(Country country) throws SQLException {
        String query;
        if (country.getId() == null || country.getId() <= 0) {
            query = "insert into countries (name, continent, acronym, language) values (?,?,?,?)";
        } else {
            query = "update countries set name=?, continent=?, acronym=?, language=? where id=?";
        }
        try (PreparedStatement pre = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pre.setString(1, country.getName());
            pre.setString(2, country.getContinent().toString());
            pre.setString(3, country.getAcronym());
            pre.setString(4, country.getLanguage());
            if (country.getId() != null && country.getId() > 0 ) {
                pre.setLong(5, country.getId());
            }
            pre.executeUpdate();
            try (ResultSet rs = pre.getGeneratedKeys()){
                if (rs.next()){
                    country = byId(rs.getInt(1)).get();
                }
            }
        }
        return country;
    }

    @Override
    public void delete(Country country) throws SQLException {
        try (PreparedStatement pre = conn.prepareStatement("delete from countries where id=?")){
            pre.setLong(1, country.getId());
            pre.executeUpdate();
        }
    }

    @Override
    public Optional<Country> byName(String name) throws SQLException {
        Optional<Country> country = Optional.empty();
        try (PreparedStatement pre = conn.prepareStatement("select * from countries where name = ?")){
            pre.setString(1, name);
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()){
                country = Optional.of(createCountry(resultSet));
            }
            resultSet.close();
        }
        return country;
    }

    @Override
    public List<Country> byContinent(Continent continent) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement pre = conn.prepareStatement("select * from countries where continent = ?")){
            pre.setString(1, continent.toString());
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                countries.add(createCountry(resultSet));
            }
            resultSet.close();
        }
        return countries;
    }

    @Override
    public Optional<Country> byAcronym(String acronym) throws SQLException {
        Optional<Country> country = Optional.empty();
        try (PreparedStatement pre = conn.prepareStatement("select * from countries where acronym = ?")){
            pre.setString(1, acronym);
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()){
                country = Optional.of(createCountry(resultSet));
            }
            resultSet.close();
        }
        return country;
    }

    @Override
    public List<Country> byLanguage(String language) throws SQLException {
        List<Country> country = new ArrayList<>();
        try (PreparedStatement pre = conn.prepareStatement("select * from countries where language = ?")){
            pre.setString(1, language);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                country.add(createCountry(resultSet));
            }
            resultSet.close();
        }
        return country;
    }

    private Country createCountry(ResultSet rs) throws SQLException {
        Continent continent = Continent.America;
        String con = rs.getString(3);
        switch (con){
            case "Africa" -> continent = Continent.Africa;

            case "Europa" -> continent = Continent.Europa;

            case "Asia" -> continent = Continent.Asia;

            case "Oceania" -> continent = Continent.Oceania;
        }
        return new Country(rs.getLong(1), rs.getString(2), continent,
                rs.getString(4), rs.getString(5));
    }
}
