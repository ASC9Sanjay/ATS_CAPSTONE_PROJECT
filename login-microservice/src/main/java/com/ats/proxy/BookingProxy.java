package com.ats.proxy;
import com.ats.model.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MS-05-Booking-eurekaClient")
//@RibbonClient(name = "MS-05-Booking-eurekaClient")
public interface BookingProxy {
    @GetMapping("/api/display")
    List<Booking> displayAllBooking();

    @PostMapping("/api/createBooking")
    Booking createBooking(@RequestBody Booking bookingDetails);
}

