package com.ats.schedule_microservice.cntrl;


import com.ats.schedule_microservice.mdl.ScheduleDTO;
import com.ats.schedule_microservice.srv.ScheduleService;
import com.ats.schedule_microservice.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @PostMapping("/createSchedule")
    public ScheduleDTO addSchedule(@RequestBody ScheduleDTO scheduleDetailsFromUser){
        scheduleDetailsFromUser.setScheduleId(IdGenerator.generateId());
        return scheduleService.createSchedule(scheduleDetailsFromUser);
    }
    @GetMapping("/getSchedule/src/{sourceId}/dest/{destinationId}")
    public  ScheduleDTO getScheduleBySrcDestDate(@PathVariable("sourceId") String sourceId,@PathVariable("destinationId") String destinationId ){
        return scheduleService.getScheduleBySrcDestDate(sourceId,destinationId);
    }

    @GetMapping("/displayAllSchedule")
    public List<ScheduleDTO> displayAllSchedule(){
        return scheduleService.displayAllSchedule();
    }

    @PutMapping("/updateSchedule")
    public ScheduleDTO udpateSchedule(@RequestBody ScheduleDTO scheduleDetailsFromUser){
        return scheduleService.udpateSchedule(scheduleDetailsFromUser);
    }

    @DeleteMapping("/deleteSchedule/{scheduleId}")
    public ScheduleDTO deleteSchedule(@PathVariable(value = "scheduleId") String scheduleId){
        return scheduleService.deleteSchedule(scheduleId);
    }
}
