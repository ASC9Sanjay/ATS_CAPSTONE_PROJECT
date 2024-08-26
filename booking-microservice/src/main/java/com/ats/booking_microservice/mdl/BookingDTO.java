package com.ats.booking_microservice.mdl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
public class BookingDTO {

    private BookingDTO(){

    }
    private String id;
    private  String scheduleId;
    private String passengerId;
    private int seatNumber;

    public static BookingDTO getInstance(){
        return new BookingDTO();
    }

}
