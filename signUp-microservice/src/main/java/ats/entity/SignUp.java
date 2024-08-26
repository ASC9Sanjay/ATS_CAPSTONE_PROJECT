package ats.entity;

import jakarta.persistence.*;


@Entity
@Table(name= "users")
public class SignUp {


    @Id
    private String id;
    @Column(name = "email" , nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "is_already_attempted", nullable = false)
    private boolean isAlreadyAttempted;


    public static SignUp getInstance(){
        return new SignUp();
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAlreadyAttempted=" + isAlreadyAttempted +
                '}';
    }
}
