package com.Ved.MovieTicketBooking.Repository;

import com.Ved.MovieTicketBooking.Entity.UpcomingMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UpcomingMovieRepo extends JpaRepository<UpcomingMovie, UUID> {
}
