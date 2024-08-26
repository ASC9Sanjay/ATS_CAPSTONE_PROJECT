package ats.utils;

public class PasswordValidator {

    public static boolean isValidPassword(String password){

        if(password == null || password.isEmpty()){
            return false;
        }
        if(!password.matches(".*[A-Z].*")){
            return false;
        }
        if(!password.matches(".*[a-z].*")){
            return false;
        }
        if(!password.matches(".*[0-10].*")){
            return false;
        }
        if(!password.matches(".*[!@#$].*")){
            return false;
        }
        return true;
    }
}
