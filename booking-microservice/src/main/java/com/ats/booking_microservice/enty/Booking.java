package com.ats.booking_microservice.enty;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="bookings")

public class Booking {

    private Booking(){

    }

    @Id
    private String id;
    @Column(name="schedule_id",nullable = false)
    private  String scheduleId;
    @Column(name="passenger_id",nullable = false)
    private String passengerId;
    @Column(name="seat_number",nullable = false)
    private int seatNumber;

    public static Booking getInstance(){
        return new Booking();
    }
}
