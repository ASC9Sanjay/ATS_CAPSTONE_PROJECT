package com.ats.passenger_microservice.srvc;

import com.ats.passenger_microservice.enty.Passenger;
import com.ats.passenger_microservice.mdl.PassengerDTO;

import java.util.List;

public interface PassengerService {

    PassengerDTO createPassenger(PassengerDTO passengerDetailsFromUser);
    List<PassengerDTO> displayAllPassenger();
    PassengerDTO deletePassenger(String passengerId);
    PassengerDTO displayById(String passengerId);
    PassengerDTO updatePassenger(PassengerDTO updatedPassengerDetailsFromUser);
}
