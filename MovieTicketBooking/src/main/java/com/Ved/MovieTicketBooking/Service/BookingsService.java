package com.Ved.MovieTicketBooking.Service;

import com.Ved.MovieTicketBooking.Entity.Bookings;
import com.Ved.MovieTicketBooking.Entity.User;
import com.Ved.MovieTicketBooking.Repository.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepo bookingsRepo;

    public ResponseEntity<List<Bookings>> getAllBookings(){
        return ResponseEntity.ok(bookingsRepo.findAll());
    }
    public ResponseEntity<Bookings> CreateBooking(@RequestBody Bookings bookingDetails){
        Bookings savedBooking = bookingsRepo.save(bookingDetails);
        return ResponseEntity.ok(savedBooking);
    }

    public void DeleteAllBookings(){
        bookingsRepo.deleteAll();
    }

    public ResponseEntity<List<Bookings>> findBookingByUser(User user) {
        return ResponseEntity.ok(bookingsRepo.findAllByUser(user));
    }
}
