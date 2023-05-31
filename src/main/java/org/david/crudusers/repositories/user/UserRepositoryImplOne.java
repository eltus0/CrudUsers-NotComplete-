package org.david.crudusers.repositories.user;

import org.david.crudusers.models.Country;
import org.david.crudusers.models.GenFav;
import org.david.crudusers.models.User;
import org.david.crudusers.repositories.country.CountryRepositoryImplOne;
import org.david.crudusers.repositories.country.ICountryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImplOne implements IUserRepository {

    private final Connection conn;
    private final ICountryRepository repoC;

    public UserRepositoryImplOne(Connection conn) {
        this.conn = conn;
        this.repoC = new CountryRepositoryImplOne(this.conn);
    }

    @Override
    public List<User> atList() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from users")){
            while (rs.next()){
                users.add(createUser(rs));
            }
        }
        return users;
    }

    @Override
    public Optional<User> byId(Integer id) throws SQLException {
        Optional<User> optionalU = Optional.empty();
        try (PreparedStatement pre = conn.prepareStatement("select * from users where id=?")){
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                optionalU = Optional.of(createUser(rs));
            }
        }
        return optionalU;
    }

    @Override
    public User save(User user) throws SQLException {
        String query;
        boolean parent = user.getParent() != null ;

//        comentado el id solo para las pruebas
        if (user.getId() == null || user.getId() < 1){
            query = "insert into users (uk, nombre, username, password, email, age, birthday, fecha_creacion, pais, genmusic, " + ((parent)?"parent,":"") + " recibir_noti)" +
                    " values (?,?,?,?,?,?,?,?,?,?," + ((parent)?"?,":"") + "?)";
        } else {
            query = "update users set uk=?, nombre=?, username=?, password=?, email=?, age=?, birthday=?, fecha_creacion=?, pais=?, genmusic=?, parent=?, recibir_noti=? where id=?";
        }

        try (PreparedStatement pre = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pre.setString(1, user.getUk());
            pre.setString(2, user.getName());
            pre.setString(3, user.getUsername());
//            herramienta de codificacion
            pre.setString(4, user.getPassword());
            pre.setString(5, user.getEmail());
            pre.setInt(6, user.getAge());
            pre.setDate(7, new Date(user.getBirthday().getTime()));
            pre.setDate(8, new Date(user.getCreate_at().getTime()));
            pre.setLong(9, user.getCountry().getId());
            pre.setString(10, user.getGenFav().toString());
            int paramNumber = 11;
            if (user.getParent() != null ) {
                pre.setLong(paramNumber, user.getParent().getId());
                ++paramNumber;
            }

            pre.setBoolean(paramNumber, user.isNotify());
            ++paramNumber;

            //        comentado el id solo para las pruebas
            if (user.getId() != null && user.getId() > 0){
                pre.setLong(paramNumber, user.getId());
            }

            pre.executeUpdate();

            try (ResultSet rs = pre.getGeneratedKeys()){
                if (rs.next()){
                    user.setId(rs.getLong(1));
                }
            }
        }
        return user;
    }

    @Override
    public void delete(User user) throws SQLException {
        try (PreparedStatement pre = conn.prepareStatement("delete from users where id=?")){
            pre.setLong(1, user.getId());
            pre.executeUpdate();
        }
    }

//    @Override
//    public Optional<String> onlyName(String name, String email) throws SQLException {
//        Optional<String> nameParent = Optional.empty();
//        try(PreparedStatement pre = conn.prepareStatement("select u.nombre from users as u where nombre=? && email=? ")){
//            pre.setString(1, name);
//            ResultSet rs = pre.executeQuery();
//            if (rs.next()){
//                nameParent = Optional.of(rs.getString(1));
//            }
//            rs.close();
//            return nameParent;
//        }
//    }

    @Override
    public Optional<User> byUk(String uk) {
        return Optional.empty();
    }

    @Override
    public Optional<User> byCountry(String country) {
        return Optional.empty();
    }

    @Override
    public Optional<User> byGeneroFav(String generoFav) {
        return Optional.empty();
    }

    private User createUser(ResultSet rs) throws SQLException {
        int countryId = rs.getInt(11);
        String genFavString = rs.getString(12);
        int parentId = rs.getInt(13);

        Country country = null;
        User parent = null;

        Optional<Country> optionalC = repoC.byId(countryId);
        if(optionalC.isPresent()){
            country = optionalC.get();
        }

        Optional<User> optionalU = this.byId(parentId);
        if (optionalU.isPresent()){
            parent = optionalU.get();
        }

        GenFav genFav = null;
        switch (genFavString){
            case "pop" -> genFav = GenFav.Pop;

            case "Rock" -> genFav = GenFav.Rock;

            case "Electronica" -> genFav = GenFav.Electronica;

            case "High Energy" -> genFav = GenFav.High_Energy;
        }
        return new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getDate(9),
        rs.getDate(10), country, genFav, parent, rs.getBoolean(14));
    }
}
