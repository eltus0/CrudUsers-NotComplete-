package org.david.crudusers.tools.service;

import org.david.crudusers.connections.PoolConnections;
import org.david.crudusers.models.User;
import org.david.crudusers.repositories.country.CountryRepositoryImplOne;
import org.david.crudusers.repositories.country.ICountryRepository;
import org.david.crudusers.repositories.user.IUserRepository;
import org.david.crudusers.repositories.user.UserRepositoryImplOne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Operaciones basicas para la ayuda del service de usuarios
 */
public class ToolsService implements IUserService{

    private final Scanner sc = new Scanner(System.in);

    private final IUserRepository repou = new UserRepositoryImplOne(PoolConnections.getInstance().getConnection());

    private final ICountryRepository repoc = new CountryRepositoryImplOne(PoolConnections.getInstance().getConnection());

    private static ToolsService tools;

    private ToolsService() {
    }

    @Override
    public User crearUser() throws Exception {
        User user;
        return null;
    }

    @Override
    public boolean validarUK(String uk) {
        return uk.length() != 8 || uk.matches("[0-9]{2}[.][0-9]{2}[.][A-Z]{2}");
    }

    @Override
    public Date pedirBirthday() {
        String formatoFecha = "MM-dd-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
        sdf.setLenient(false);

        boolean menu = true;
        Date birthday = null;
        do {
            System.out.println("Formato de la fecha: " + formatoFecha);
            String cumple = sc.nextLine();
            if (cumple.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")){
                try {
                    birthday = sdf.parse(cumple);
                    menu = false;
                } catch (ParseException e) {
                    System.err.println("Formato Erronio: " + formatoFecha);
                }
            } else {
                System.err.println("Formato Erronio: " + formatoFecha);
            }
        } while (menu);
        return birthday;
    }

    @Override
    public User matchParent() {
        return null;
    }

    public static ToolsService getTools() {
        if (tools == null) {
            tools = new ToolsService();
        }
        return tools;
    }
}
