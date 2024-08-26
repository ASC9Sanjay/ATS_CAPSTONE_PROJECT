package com.ats.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.*;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class UserDetails {

    UserDetails(){
    }

    @Id
    private String id = null;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;


    UserDetails(String email , String password){
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
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

}
