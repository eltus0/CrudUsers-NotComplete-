package org.david.crudusers.repositories.country;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.david.crudusers.models.Continent;
import org.david.crudusers.models.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CountryRepositoryImplOneTest {

    private final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "sasa");
    private final ICountryRepository repo = new CountryRepositoryImplOne(conn);

    CountryRepositoryImplOneTest() throws SQLException {
    }

    @Test
    public void savesave() throws SQLException {
        System.out.println(repo.save(new Country(null, "China", Continent.Asia, "CHN", "Chino")));
    }

    @Test
    public void saveupdate() throws SQLException {
        Country country = repo.byId(4).get();
        country.setContinent(Continent.Europa);
        System.out.println(repo.save(country));
    }

    @ParameterizedTest
    @ValueSource(ints = {15,16,17,19,18,20})
    public void delete(int ids) throws SQLException {
//        repo.delete(ids);
    }

    @Test
    public void enlistcountries(){
        try {
            repo.atList().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byid(){
        try {
            System.out.println(repo.byId(6).get());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byName(){
        try {
            System.out.println(repo.byName("Argentina"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byContintent(){
        try {
            repo.byContinent(Continent.America).forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byAcronym(){
        try {
            System.out.println(repo.byAcronym("MX"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byLanguage(){
        try {
            repo.byLanguage("Espanish").forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}