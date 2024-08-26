package com.ats.airport_microservice.controller;

import com.ats.airport_microservice.model.AirportDTO;
import com.ats.airport_microservice.service.AirportServiceRepo;
import com.ats.airport_microservice.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AirportController {

    private final AirportServiceRepo airportServiceRepo;

    @Autowired
    public AirportController(AirportServiceRepo airportServiceRepo) {
        this.airportServiceRepo = airportServiceRepo;
    }

    @PostMapping("/create_airport")
    public AirportDTO createAirport(@RequestBody AirportDTO airportDetailsFromCilent){
        airportDetailsFromCilent.setAirportId(IdGenerator.generateId());
        return airportServiceRepo.addAirport(airportDetailsFromCilent);
    }
    @GetMapping("/getAirportDetailsBySrcAndDest/src/{source}/dest/{destination}")
    public List<String> getAirportSourceAndDestinationId(@PathVariable(value = "source") String source , @PathVariable(value = "destination") String destination){
        String sourceId = airportServiceRepo.getAirportDetailsByLocation(source);
        String destinationId = airportServiceRepo.getAirportDetailsByLocation(destination);
        return List.of(sourceId,destinationId);
    }

    @GetMapping("/display")
    public List<AirportDTO> displayAllAirport(){
        return airportServiceRepo.displayAirport();
    }

    @DeleteMapping("/deleteAirport/{airportId}")
    public AirportDTO deleteAirport(@PathVariable(value="airportId") String airportId){
        return airportServiceRepo.deleteAirport(airportId);
    }

    @PutMapping("/updateAirport")
    public AirportDTO updateAirport(@RequestBody AirportDTO airportDetailsFromCilent){
        return airportServiceRepo.updateAirport(airportDetailsFromCilent);
    }


}
