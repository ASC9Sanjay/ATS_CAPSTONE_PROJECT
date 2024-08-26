package com.ats.utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final String EmailRegex =  "^[A-Za-z0-9+.-_]+@[A-Za-z0-9+.-_]+$";

    public static boolean isValidEmail(String email){

        if(email == null || email.isEmpty()){
            System.out.println("email is empty");
            return false;
        }
        Pattern pattern  = Pattern.compile(EmailRegex);
        Matcher matcher = pattern.matcher(email);
        System.out.println("password matcher"+matcher.matches());
        return matcher.matches();
    }

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

    public static Duration findDurationInSeconds(Timestamp lockedUntill){
        Timestamp currentTime = Timestamp.from(Instant.now());
        Instant currentTimeInstant = currentTime.toInstant();
        Instant lockedUntillInstant = lockedUntill.toInstant();
        Duration duration = Duration.between(currentTimeInstant,lockedUntillInstant);
        return duration;
    }
}
