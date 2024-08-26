package com.ats.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="MS-04-Airport-eurekaClient")
public interface AirportProxy {
    @GetMapping("/getAirportDetailsBySrcAndDest/src/{source}/dest/{destination}")
    List<String> getAirportSourceAndDestinationId(@PathVariable("source") String source , @PathVariable("destination") String destination);

}
