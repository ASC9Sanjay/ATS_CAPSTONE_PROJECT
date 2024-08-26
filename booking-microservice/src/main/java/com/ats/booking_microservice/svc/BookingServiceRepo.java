package com.ats.booking_microservice.svc;

import com.ats.booking_microservice.mdl.BookingDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingServiceRepo {
    BookingDTO createBooking(BookingDTO bookingDetailsFromUser);
    List<BookingDTO> getBooking();
    BookingDTO updateBooking(BookingDTO updatedBookingDetailsFromUser);
    BookingDTO deleteBooking(String bookingId);
    BookingDTO getBookingById(String bookingId);

}
