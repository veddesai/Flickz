package com.Ved.MovieTicketBooking.Repository;

import com.Ved.MovieTicketBooking.Entity.OngoingMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface OngoingMovieRepo extends JpaRepository<OngoingMovie, UUID> {

    @Query("SELECT m FROM OngoingMovie m WHERE m.movie_title = :movie_title")
    OngoingMovie findByMovieTitle(@Param("movie_title") String movieTitle);
}
