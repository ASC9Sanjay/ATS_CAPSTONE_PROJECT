package com.ats.passenger_microservice.enty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter @Setter
public class Passenger {

    private Passenger(){

    }

    @Id
    private String passengerId;
    @Column(name = "passenger_name",nullable = false)
    private String passengerName;

    public static Passenger getInstance(){
        return new Passenger();
    }

}
