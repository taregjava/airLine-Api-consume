package com.halfacode.travelagency.service;

import org.springframework.stereotype.Service;

@Service
public class BookingService {
    /*private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(BookingDTO bookingDTO, User user) {
        // Convert BookingDTO to Booking entity and set user details
        Booking booking = new Booking();
        booking.setFlightNumber(bookingDTO.getFlightNumber());
        booking.setUser(user);
        // Set other booking details
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NoSuchElementException("Booking not found"));
    }

    public Booking updateBooking(BookingDTO updatedBookingDTO, Long bookingId) {
        Booking existingBooking = getBookingById(bookingId);
        // Update booking details from updatedBookingDTO
        // Save the updated booking
        return bookingRepository.save(existingBooking);
    }*/

  /*  public void cancelBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);
        // Implement logic to cancel the booking
        bookingRepository.delete(booking);
    }*/
}