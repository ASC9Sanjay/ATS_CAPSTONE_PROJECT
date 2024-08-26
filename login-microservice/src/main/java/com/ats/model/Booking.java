package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Booking {

    private Booking(){

    }
    private String id;
    private  String scheduleId;
    private String passengerId;
    private int seatNumber;

    public static Booking getInstance(){
        return new Booking();
    }
}
