package org.david.crudusers.tools.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ToolsServiceTest {

    @ParameterizedTest
    @DisplayName("Valid UK")
    @ValueSource(strings = {"dsafasdffasdfasdf", "as.as.ad","12.46.45", "12.56.DC"})
    public void validUk(String uk){
        System.out.println(ToolsService.getTools().validarUK(uk));
    }


    @Tag("pruebaCod")
    @Nested
    class pruebaCod{

        @ParameterizedTest
        @DisplayName("Test match formatt birthday")
        @ValueSource(strings = {"06-25-2002", "06/25/2002","25/06/2002", "25-06-2002","06-25-2002"})
        public void formatBirthday(String birth)  {

            String formatoFecha = "MM/dd/yyyy";
            assertTrue(birth.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}"));
//            System.out.println(birth.matches("[0-9]{2} [-]{1} [0-9]{2} [-]{1} [1-2]{1} [0-9]{1} [0-9]{2}"));

//            sdf.setLenient(false);
//            try {
//                System.out.println(sdf.parse(birth));
//            } catch (ParseException e) {
//                System.err.println("dfafasd");
//            }
//            sdf.setLenient(false);
//            try {
//                Date parse = sdf.parse(birth);
//                if (parse instanceof Date){
//                    System.out.println(parse);
//                }
//            } catch (ParseException e) {
//                System.err.println("sas");
//            }
        }
    }

}