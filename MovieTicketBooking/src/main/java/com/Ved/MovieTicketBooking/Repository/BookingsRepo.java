package com.Ved.MovieTicketBooking.Repository;

import com.Ved.MovieTicketBooking.Entity.Bookings;
import com.Ved.MovieTicketBooking.Entity.Theatre;
import com.Ved.MovieTicketBooking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookingsRepo extends JpaRepository<Bookings, UUID>{
    @Query("SELECT m FROM Bookings m WHERE m.booking_id = :booking_id")
    Bookings findByBookingId(@Param("booking_id")UUID booking_id);
    List<Bookings> findAllByUser(User user);
}
