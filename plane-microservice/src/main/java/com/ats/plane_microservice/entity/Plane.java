package com.ats.plane_microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
@Entity
@Table(name="planes")
public class Plane {

    @Id
    private String id;
    @Column(name="plane_name",nullable = false)
    private String planeName;
    @Column(name="capacity",nullable = false)
    private int capacity;
    @Column(name="airways_name",nullable = false)
    private String airwaysName;

    Plane(){
    }

    public static Plane getInstance(){
        return new Plane();
    }
}
