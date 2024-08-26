package com.ats.airport_microservice.service;

import com.ats.airport_microservice.entity.Airport;
import com.ats.airport_microservice.model.AirportDTO;
import com.ats.airport_microservice.repository.AirportRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceRepoImpl implements AirportServiceRepo{

    private final AirportRepo airportRepo;

    public AirportServiceRepoImpl(AirportRepo airportRepo) {
        this.airportRepo = airportRepo;
    }


    @Override
    public List<AirportDTO> displayAirport() {
        List<Airport> airports = airportRepo.findAll();
        return airports.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public AirportDTO addAirport(AirportDTO airportDetailFromUser) {
        Airport convertedData = convertDTOtoEntity(airportDetailFromUser);
        Airport response = airportRepo.save(convertedData);
        airportDetailFromUser.setAirportId(response.getAirportId());
        return airportDetailFromUser;

    }

    @Override
    public AirportDTO updateAirport(AirportDTO airportDetailFromUser) {
        Airport airportDetailFromDB = airportRepo.findById(airportDetailFromUser.getAirportId()).get();
        airportDetailFromDB.setAirportName(airportDetailFromUser.getAirportName());
        airportDetailFromDB.setLocation(airportDetailFromUser.getLocation());
        airportDetailFromDB.setCountryCode(airportDetailFromDB.getCountryCode());
        Airport response = airportRepo.save(airportDetailFromDB);
        airportDetailFromUser.setAirportId(response.getAirportId());
        return  airportDetailFromUser;
    }

    @Override
    public AirportDTO deleteAirport(String airportId){
        Airport airportFromDB = airportRepo.findById(airportId).get();
        airportRepo.delete(airportFromDB);
        return convertEntityToDTO(airportFromDB);

    }

    @Override
    public String getAirportDetailsByLocation(String location){
        Airport airportFromDB = airportRepo.findByAirportLocation(location);
        return airportFromDB.getAirportId();
    }

    private Airport convertDTOtoEntity(AirportDTO airportDetailFromUser) {
        Airport airport = Airport.getInstance();
        airport.setAirportId(airportDetailFromUser.getAirportId());
        airport.setAirportName(airportDetailFromUser.getAirportName());
        airport.setLocation(airportDetailFromUser.getLocation());
        airport.setCountryCode(airportDetailFromUser.getCountryCode());
        return airport;
    }


    private AirportDTO convertEntityToDTO(Airport response) {
        AirportDTO convertedResponse = AirportDTO.getInstance();
        convertedResponse.setAirportId(response.getAirportId());
        convertedResponse.setAirportName(response.getAirportName());
        convertedResponse.setLocation(response.getLocation());
        convertedResponse.setCountryCode(response.getCountryCode());
        return convertedResponse;
    }


}
