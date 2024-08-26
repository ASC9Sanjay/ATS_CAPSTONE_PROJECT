package com.ats.model;

public class LogInDetails {


    private String email;
    private String password;
    private boolean isAlreadyAttempted;

    LogInDetails(String email , String password){
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAlreadyAttempted(boolean alreadyAttempted) {
        isAlreadyAttempted = alreadyAttempted;
    }

    public boolean isAlreadyAttempted(String email) {
        return isAlreadyAttempted;
    }
}
