//package com.ats.schedule_microservice.enty;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity
//public class Schedule {
//    private  Schedule(){
//
//    }
//    @Id
//    private String scheduleId;
//    @Column(name="plane_id",nullable = false)
//    private String planeId;
//    @Column(name="departure_time",nullable = false)
//    private String departureTime;
//    @Column(name="arrival_time",nullable = false)
//    private String arrivalTime;
//    @Column(name="source_airport_id",nullable = false)
//    private String sourceAirportId;
//    @Column(name="destination_airport_id",nullable = false)
//    private String destinationAirportId;
//
//    public static Schedule getInstance(){
//        return  new Schedule();
//    }
//}
