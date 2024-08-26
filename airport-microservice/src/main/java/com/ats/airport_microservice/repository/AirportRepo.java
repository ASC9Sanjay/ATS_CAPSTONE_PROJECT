package com.ats.airport_microservice.repository;

import com.ats.airport_microservice.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport , String> {

    @Query(value = "SELECT * FROM airports WHERE airport_location = :location",nativeQuery = true)
    Airport findByAirportLocation(@Param("location") String location );
}
