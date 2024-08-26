package com.ats.controller;
import com.ats.model.Booking;
import com.ats.entity.UserDetails;
import com.ats.exception.AccountLockedException;
import com.ats.exception.InvalidCredentialsException;
import com.ats.model.Schedule;
import com.ats.model.TravelInfoRequest;
import com.ats.proxy.AirportProxy;
import com.ats.proxy.BookingProxy;
import com.ats.proxy.ScheduleProxy;
import com.ats.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogInController {

    private final AuthenticationService authenticationService;
    private final BookingProxy bookingProxy;
    private  final ScheduleProxy scheduleProxy;
    private final AirportProxy airportProxy;
    @Autowired
    public LogInController(AuthenticationService authenticationService, BookingProxy bookingProxy, ScheduleProxy scheduleProxy, AirportProxy airportProxy) {
        this.authenticationService = authenticationService;
        this.bookingProxy = bookingProxy;
        this.scheduleProxy = scheduleProxy;
        this.airportProxy = airportProxy;
    }

    @PostMapping("/logIn")
    public ResponseEntity<?> logIn(@RequestBody UserDetails userDetailsFromClient) {
        try{
            UserDetails authenticatedUser = authenticationService.authenticate(userDetailsFromClient);
            List<Booking> bookings = bookingProxy.displayAllBooking();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Logged in successfully");
            response.put("user", authenticatedUser);
            response.put("bookings", bookings);
            return ResponseEntity.ok(response);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (AccountLockedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }
    }
    @PostMapping("/travelInfo")
    public ResponseEntity<?> travelInfo(@RequestBody TravelInfoRequest travelInfoRequest) throws UnsupportedEncodingException {
        List<String> airports = airportProxy.getAirportSourceAndDestinationId(travelInfoRequest.getSource(),travelInfoRequest.getDestination());
        String sourceId = URLEncoder.encode(airports.get(0), StandardCharsets.UTF_8.toString());
        String destinationId = URLEncoder.encode(airports.get(1),StandardCharsets.UTF_8.toString());
        Schedule schedule = scheduleProxy.getScheduleBySrcDestDate(sourceId,destinationId);
        Booking booking = bookingProxy.createBooking(new Booking("0",schedule.getScheduleId(),travelInfoRequest.getEmail(),travelInfoRequest.getNoOfSeats()));
        return ResponseEntity.ok(booking);
    }
}