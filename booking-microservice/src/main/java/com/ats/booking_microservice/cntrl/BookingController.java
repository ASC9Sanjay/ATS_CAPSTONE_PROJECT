package com.ats.booking_microservice.cntrl;

import com.ats.booking_microservice.enty.Booking;
import com.ats.booking_microservice.mdl.BookingDTO;
import com.ats.booking_microservice.repo.BookingRepo;
import com.ats.booking_microservice.svc.BookingServiceRepo;
import com.ats.booking_microservice.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingServiceRepo bookingServiceRepo;

    @Autowired
    public BookingController(BookingServiceRepo bookingServiceRepo) {
        this.bookingServiceRepo = bookingServiceRepo;
    }

    @PostMapping("/createBooking")
    public BookingDTO addBooking(@RequestBody BookingDTO bookingDetailsFromUser){
        bookingDetailsFromUser.setId(IdGenerator.generateId());
        bookingServiceRepo.createBooking(bookingDetailsFromUser);
        return bookingDetailsFromUser;
    }

    @GetMapping("/display")
    public List<BookingDTO> displayAllBooking(){
        return bookingServiceRepo.getBooking();
    }

    @GetMapping("/getBooking/{bookingId}")
    public BookingDTO getBookingById(@PathVariable(value = "bookingId") String bookingId){
        return bookingServiceRepo.getBookingById(bookingId);
    }

    @PutMapping("/updateBooking")
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDetailsFromCilent){
        return bookingServiceRepo.updateBooking(bookingDetailsFromCilent);
    }
    @DeleteMapping("/deleteBooking/{bookingId}")
    public BookingDTO deleteBooking(@PathVariable(value = "bookingId") String bookingId){
        return bookingServiceRepo.deleteBooking(bookingId);
    }

}
