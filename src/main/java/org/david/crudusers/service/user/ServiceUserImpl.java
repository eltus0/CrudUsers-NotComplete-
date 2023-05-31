package org.david.crudusers.service.user;

import org.david.crudusers.models.User;
import org.david.crudusers.repositories.country.CountryRepositoryImplOne;
import org.david.crudusers.repositories.country.ICountryRepository;
import org.david.crudusers.repositories.user.IUserRepository;
import org.david.crudusers.repositories.user.UserRepositoryImplOne;
import org.david.crudusers.service.IService;
import org.david.crudusers.tools.service.IUserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ServiceUserImpl implements IService<User> {

    private final IUserRepository repoUser;

    private final ICountryRepository repoCountry;

    public ServiceUserImpl(Connection conn) {
        this.repoUser = new UserRepositoryImplOne(conn);
        this.repoCountry = new CountryRepositoryImplOne(conn);
    }

    @Override
    public List<User> atList() throws SQLException {
        return repoUser.atList();
    }

    @Override
    public User byId(Integer id) throws SQLException {
        Optional<User> user = repoUser.byId(id);
        if (user.isEmpty()) {
            System.err.println("No se encontro al usuario con el id: " + id);
            return null;
        }
        return user.get();
    }

    @Override
    public User save(User user) throws SQLException {
        System.out.println("-----------User Saved----------");
        System.out.println(user);
        User usernew = repoUser.save(user);
        System.out.println("-----------Successfully----------");




        /*
        esto es la logica para la pedida de datos, no para el service
        esto debe estar en el main

        boolean w = false;
        do {

            System.out.println("Datos por guardar");
            System.out.println(user);
            System.out.println("<<<<<<<<<<<<<<<<<Es correcto?>>>>>>>>>>>>>>>>>");
            System.out.println("Y o N");
            String con = sc.nextLine();


            if (con.equalsIgnoreCase("Y")) {
                user = repoUser.save(user);
            } else if (con.equalsIgnoreCase("n")) {

            } else {
                System.out.println(con + " No es una opcion");
                System.out.println("Intente de nuevo");
                w = true;
            }
        } while (w);
        */

//        implementa esto a modo de service
        return usernew;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Optional<User> user = repoUser.byId(id);
        if (user.isEmpty()){
            System.out.println("El usuario con id: " + id + ", No existe");
            return;
        }
        System.out.println("-----------User Delete----------");
        System.out.println(user.get());
        repoUser.delete(user.get());
        System.out.println("----------Successfully----------");
    }


    /**
     * Pide datos introducidos por consolar para que se
     * cre el nuevo usuario con esos valores
     * y validando manualmente
     *
     * @return muevo usuario
     */
    public User crearUser() throws Exception {
//        User user = new User();
//
//        System.out.print("UK:");
//        String uk = sc.nextLine();
//
//        while (uk.length() != 8) {
////            usar los 'pattern' de spring
//            System.err.println("El UK debe ser de 8 digitos");
////            uk = sc.nextLine();
//        }
//
//        System.out.print("Name:");
//        String name = sc.nextLine();
//
//        System.out.print("Password: ");
//        String password = sc.nextLine();
////        agregar funcion de encryptacion
//
//        System.out.print("Email: ");
//        String email = sc.nextLine();
//
//        while (!email.contains("@") && !email.endsWith(".com")) {
//            System.err.println("No es un correo electronico");
//            email = sc.nextLine();
//        }
//
//        System.out.print("Age: ");
//        int age = sc.nextInt();
//        while (age < 18 || age > 80) {
//            System.err.println("Edad permitida de 18 años a 80 años");
//            age = sc.nextInt();
//        }
//
////        falta por completar
//        System.out.println("Birthday");
//        System.out.print("Formato: MM-DD-YYYY");
//        String cumple = sc.nextLine();
//        Date birthday = null;
//        birthday = pedirBirthday(cumple, sc);
//
////        fecha de creacion y de ultima update
//
//        Date create_update = new Date();
//
//        repoCountry.atList().forEach(System.out::println);
//        System.out.print("Country acronym: ");
//        String acronym = sc.nextLine();
//        while (acronym.length() > 3) {
//            System.err.println("No es una sigla");
//            acronym = sc.nextLine();
//        }
//
//        System.out.print("Musical Genre: ");
//        String genmusic = sc.nextLine();
//
//        System.out.print("Parent");
//        User parent = matchParent(sc);

        return null;
    }


    public User matchParent() {
//        System.out.println("Uk: ");
//        String parentUk = sc.nextLine();
//
//        System.out.println("Name: ");
//        String parentName = sc.nextLine();
//
//        System.out.println("Email: ");
//        String parentEmail = sc.nextLine();
//
//        while (!parentEmail.contains("@") && !parentEmail.endsWith(".com")) {
//            System.err.println("No es un correo electronico");
//            email = sc.nextLine();
//        }
//
//        Optional<User> optionalUser = repoUser.byUk(parentUk);
//        if (optionalUser.isEmpty()) {
//            do {
//
//            } while ()
//        }
        return null;
    }
}
