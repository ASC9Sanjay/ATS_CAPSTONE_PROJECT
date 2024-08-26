package com.ats.airport_microservice.service;

import com.ats.airport_microservice.model.AirportDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface AirportServiceRepo {
    List<AirportDTO> displayAirport();
    AirportDTO addAirport(AirportDTO airportDetailFromUser);
    AirportDTO updateAirport(AirportDTO airportDetailFromUser);
    AirportDTO deleteAirport(String airportId);
    String getAirportDetailsByLocation(String location);
}
