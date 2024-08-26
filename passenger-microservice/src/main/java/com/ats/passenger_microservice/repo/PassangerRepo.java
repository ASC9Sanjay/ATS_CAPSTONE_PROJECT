package com.ats.passenger_microservice.repo;

import com.ats.passenger_microservice.enty.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassangerRepo extends JpaRepository<Passenger,String> {
}
