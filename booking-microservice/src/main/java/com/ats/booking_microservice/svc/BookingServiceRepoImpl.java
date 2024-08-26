package com.ats.booking_microservice.svc;

import com.ats.booking_microservice.enty.Booking;
import com.ats.booking_microservice.mdl.BookingDTO;
import com.ats.booking_microservice.repo.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceRepoImpl implements BookingServiceRepo{

    private final BookingRepo bookingRepo;

    public BookingServiceRepoImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;

    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDetailsFromUser) {
        Booking booking = convertDTOtoEntity(bookingDetailsFromUser);
        Booking response = bookingRepo.save(booking);
        bookingDetailsFromUser.setId(response.getId());
        return bookingDetailsFromUser;
    }

    private Booking convertDTOtoEntity(BookingDTO bookingDetailsFromUser) {
        Booking booking = Booking.getInstance();
        booking.setId(bookingDetailsFromUser.getId());
        booking.setPassengerId(bookingDetailsFromUser.getPassengerId());
        booking.setScheduleId(bookingDetailsFromUser.getScheduleId());
        booking.setSeatNumber(bookingDetailsFromUser.getSeatNumber());
        return booking;
    }

    @Override
    public List<BookingDTO> getBooking() {
        List<Booking>  bookings = bookingRepo.findAll();
        return bookings.stream().map(this::convertEntityToDTO).collect(Collectors.toList());

    }

    @Override
    public BookingDTO updateBooking(BookingDTO updatedBookingDetailsFromUser) {
        Booking bookingFromDB = bookingRepo.findById(updatedBookingDetailsFromUser.getId()).get();
        bookingFromDB.setSeatNumber(updatedBookingDetailsFromUser.getSeatNumber());
        return null;
    }

    @Override
    public BookingDTO deleteBooking(String bookingId) {
        Booking bookingDetailsToBeDeleted = bookingRepo.findById(bookingId).get();
        bookingRepo.delete(bookingDetailsToBeDeleted);
        return convertEntityToDTO(bookingDetailsToBeDeleted);
    }

    @Override
    public BookingDTO getBookingById(String bookingId) {
        return convertEntityToDTO(bookingRepo.findById(bookingId).get());
    }


    private BookingDTO convertEntityToDTO(Booking bookingResponseFromDB){
        BookingDTO bookingDTO = BookingDTO.getInstance();
        bookingDTO.setId(bookingResponseFromDB.getId());
        bookingDTO.setPassengerId(bookingResponseFromDB.getPassengerId());
        bookingDTO.setScheduleId(bookingResponseFromDB.getScheduleId());
        bookingDTO.setSeatNumber(bookingResponseFromDB.getSeatNumber());
        return bookingDTO;
    }
}
