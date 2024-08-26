package com.ats.schedule_microservice.mdl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public class ScheduleDTO {

    private ScheduleDTO() {

    }

    private String scheduleId;
    private String planeId;
    private String departureTime;
    private String arrivalTime;
    private String sourceAirportId;
    private String destinationAirportId;

    public static ScheduleDTO getInstance() {
        return new ScheduleDTO();
    }
}
