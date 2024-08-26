package com.ats.passenger_microservice.ctl;

import com.ats.passenger_microservice.enty.Passenger;
import com.ats.passenger_microservice.mdl.PassengerDTO;
import com.ats.passenger_microservice.repo.PassangerRepo;
import com.ats.passenger_microservice.srvc.PassengerService;
import com.ats.passenger_microservice.utls.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassangerController {

    private final PassengerService passengerService;

    @Autowired
    public PassangerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/createPassenger")
    public PassengerDTO createPassenger(@RequestBody PassengerDTO passengerDetailsFromUser){
        PassengerDTO passenger = PassengerDTO.getInstance();
        passenger.setPassengerId(IdGenerator.generateId());
        return passengerService.createPassenger(passenger);
    }

    @GetMapping("/displayAllPassenger")
    public List<PassengerDTO> getAllPassenger(){
        return passengerService.displayAllPassenger();
    }

    @GetMapping("/getPassenger/{passengerId}")
    public PassengerDTO getPassengerById(@PathVariable (value = "passengerId") String passengerId){
        return passengerService.displayById(passengerId);
    }

    @DeleteMapping("/deletePassenger")
    public PassengerDTO deletePassenger(@RequestBody String passengerId){
        return passengerService.deletePassenger(passengerId);
    }

    @PutMapping("/updatePassenger")
    public PassengerDTO updatePassenger(@RequestBody PassengerDTO passengerDetailsFromUser){
        return passengerService.updatePassenger(passengerDetailsFromUser);
    }
}
