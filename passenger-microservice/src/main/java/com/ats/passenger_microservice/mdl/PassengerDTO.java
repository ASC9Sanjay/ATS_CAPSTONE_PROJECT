package com.ats.passenger_microservice.mdl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class PassengerDTO {

    private PassengerDTO(){

    }
    private String passengerId;
    private String passengerName;

    public static PassengerDTO getInstance(){
        return new PassengerDTO();
    }
}
