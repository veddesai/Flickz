package com.Ved.MovieTicketBooking.Controller;

import com.Ved.MovieTicketBooking.Entity.Bookings;
import com.Ved.MovieTicketBooking.Entity.User;
import com.Ved.MovieTicketBooking.Service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping
    public ResponseEntity<List<Bookings>> getAllBookings() {
        return bookingsService.getAllBookings();
    }

    @PostMapping
    public ResponseEntity<Bookings> CreateBooking(@RequestBody Bookings bookingDetails){
        return bookingsService.CreateBooking(bookingDetails);
    }

    @DeleteMapping
    public void DeleteAllBookings(){
        bookingsService.DeleteAllBookings();
    }

    @GetMapping("/userbookings")
    public ResponseEntity<List<Bookings>> findBookingByUser(@RequestParam User user){
        return bookingsService.findBookingByUser(user);
    }
}
