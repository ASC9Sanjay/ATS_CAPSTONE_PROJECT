package com.ats.airport_microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Entity
@Table(name="airports")
public class Airport {
    private Airport(){
    }

    @Id
    private String airportId;
    @Column(name="airport_name",nullable = false)
    private String airportName;
    @Column(name="airport_location",nullable = false)
    private String location;
    @Column(name="country_code",nullable = false)
    private String countryCode;

    public static Airport getInstance(){
        return new Airport();
    }
}
