package com.ats.schedule_microservice.srv;

import com.ats.schedule_microservice.mdl.ScheduleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleService  {

    ScheduleDTO createSchedule(ScheduleDTO scheduleDetailsFromUser);
    ScheduleDTO getScheduleById(String scheduleById);
    List<ScheduleDTO> displayAllSchedule();
    ScheduleDTO udpateSchedule(ScheduleDTO updatedScheduleDetailsFromUser);
    ScheduleDTO deleteSchedule(String scheduleId);
    ScheduleDTO getScheduleBySrcDestDate(String source , String destination);

}
