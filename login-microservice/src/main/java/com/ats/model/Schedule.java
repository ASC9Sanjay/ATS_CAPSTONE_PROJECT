package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Schedule {

    private Schedule() {

    }

    private String scheduleId;
    private String planeId;
    private String departureTime;
    private String arrivalTime;
    private String sourceAirportId;
    private String destinationAirportId;

    public static Schedule getInstance() {
        return new Schedule();
    }
}
