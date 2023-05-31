package org.david.crudusers.tools.service;

import org.david.crudusers.models.User;
import org.david.crudusers.service.IService;

import java.util.Date;
import java.util.Scanner;

public interface IUserService {

    User crearUser() throws Exception;

    boolean validarUK(String uk);

    Date pedirBirthday();

    User matchParent();

}
