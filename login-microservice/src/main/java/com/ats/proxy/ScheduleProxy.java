package com.ats.proxy;

import com.ats.model.Schedule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="MS-06-Schedule-eurekaClient")
public interface ScheduleProxy{
        @GetMapping("/getSchedule/src/{sourceId}/dest/{destinationId}")
        Schedule getScheduleBySrcDestDate(@PathVariable("sourceId") String sourceId , @PathVariable("destinationId") String destinationId );
    }

