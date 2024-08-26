package ats.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAILREGEX =  "^[A-Za-z0-9+.-_]+@[A-Za-z0-9+.-_]+$";

    public static boolean isValidEmail(String email){

        if(email == null || email.isEmpty()){
            System.out.println("email is empty");
            return false;
        }
        Pattern pattern  = Pattern.compile(EMAILREGEX);
        Matcher matcher = pattern.matcher(email);
        System.out.println("password matcher"+matcher.matches());
        return matcher.matches();
    }

}
