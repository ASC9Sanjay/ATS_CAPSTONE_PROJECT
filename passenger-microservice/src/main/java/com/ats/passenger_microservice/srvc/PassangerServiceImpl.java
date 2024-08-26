package com.ats.passenger_microservice.srvc;

import com.ats.passenger_microservice.enty.Passenger;
import com.ats.passenger_microservice.mdl.PassengerDTO;
import com.ats.passenger_microservice.repo.PassangerRepo;

import java.util.List;
import java.util.stream.Collectors;

public class PassangerServiceImpl implements PassengerService {

    private final PassangerRepo passangerRepo;

    public PassangerServiceImpl(PassangerRepo passangerRepo) {
        this.passangerRepo = passangerRepo;
    }

    @Override
    public PassengerDTO createPassenger(PassengerDTO passengerDetailsFromUser) {
        Passenger passenger = Passenger.getInstance();
        passenger.setPassengerName(passengerDetailsFromUser.getPassengerName());
        return convertEntityToDTO(passangerRepo.save(passenger));
    }

    @Override
    public List<PassengerDTO> displayAllPassenger() {
        List<Passenger> passengers = passangerRepo.findAll();
        return passengers.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public PassengerDTO deletePassenger(String passengerId) {
        Passenger passenger = passangerRepo.findById(passengerId).get();
        passangerRepo.delete(passenger);
        return convertEntityToDTO(passenger);
    }

    @Override
    public PassengerDTO displayById(String passengerId) {
        Passenger passenger = passangerRepo.findById(passengerId).get();
        return convertEntityToDTO(passenger);
    }

    @Override
    public PassengerDTO updatePassenger(PassengerDTO updatedPassengerDetailsFromUser) {
        Passenger passengerDetailsFromDB = passangerRepo.findById(updatedPassengerDetailsFromUser.getPassengerId()).get();
        passengerDetailsFromDB.setPassengerName(updatedPassengerDetailsFromUser.getPassengerName());
        return updatedPassengerDetailsFromUser;
    }

    private PassengerDTO convertEntityToDTO(Passenger passenger){
        PassengerDTO passengerDTO = PassengerDTO.getInstance();
        passengerDTO.setPassengerId(passenger.getPassengerId());
        passengerDTO.setPassengerName(passenger.getPassengerName());
        return passengerDTO;
    }
}
