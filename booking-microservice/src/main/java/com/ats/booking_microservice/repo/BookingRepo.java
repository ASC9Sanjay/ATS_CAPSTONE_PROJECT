package com.ats.booking_microservice.repo;

import com.ats.booking_microservice.enty.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {

}
