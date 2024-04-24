package com.Ved.MovieTicketBooking.Repository;

import com.Ved.MovieTicketBooking.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TheatreRepo extends JpaRepository<Theatre, UUID> {
    List<Theatre> findByCity(String city);

    @Query("SELECT m FROM Theatre m WHERE m.theatre_id = :theatre_id")
    Theatre findByTheatreId(@Param("theatre_id")UUID theatre_id);
}
