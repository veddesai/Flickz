package com.Ved.MovieTicketBooking.Service;

import com.Ved.MovieTicketBooking.DTO.MovieDTO;
import com.Ved.MovieTicketBooking.DTO.MovieRequest;
import com.Ved.MovieTicketBooking.Entity.OngoingMovie;
import com.Ved.MovieTicketBooking.Entity.UpcomingMovie;
import com.Ved.MovieTicketBooking.Repository.OngoingMovieRepo;
import com.Ved.MovieTicketBooking.Repository.UpcomingMovieRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {



    @Autowired
    private OngoingMovieRepo ongoingMovieRepo;

    @Autowired
    private UpcomingMovieRepo upcomingMovieRepo;

    private MovieRequest storedMovieRequest;


    public ResponseEntity<MovieDTO> getAllMovies(){
        List<OngoingMovie> ongoingMovies = ongoingMovieRepo.findAll();
        List<UpcomingMovie> upcomingMovies = upcomingMovieRepo.findAll();

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setOngoingMovies(ongoingMovies);
        movieDTO.setUpcomingMovies(upcomingMovies);
        return ResponseEntity.ok(movieDTO);
    }

    public ResponseEntity<List<OngoingMovie>> getAllOngoingMovies() {
        return ResponseEntity.ok(ongoingMovieRepo.findAll());
    }

    public ResponseEntity<List<UpcomingMovie>> getAllUpcomingMovies() {
        return ResponseEntity.ok(upcomingMovieRepo.findAll());
    }

    public ResponseEntity<OngoingMovie> createOngoingMovie(@RequestBody @NotNull OngoingMovie ongoingMovieDetails){

        OngoingMovie ongoingMovie = new OngoingMovie();
        ongoingMovie.setMovie_id(ongoingMovieDetails.getMovie_id());
        ongoingMovie.setMovie_title(ongoingMovieDetails.getMovie_title());
        ongoingMovie.setMovie_language(ongoingMovieDetails.getMovie_language());
        ongoingMovie.setMovieRating(ongoingMovieDetails.getMovieRating());
        ongoingMovie.setAvailable_movie_dimensions(ongoingMovieDetails.getAvailable_movie_dimensions());
        ongoingMovie.setMovie_img_url(ongoingMovieDetails.getMovie_img_url());
        ongoingMovie.setGenre(ongoingMovieDetails.getGenre());

        OngoingMovie savedOngoingMovie = ongoingMovieRepo.save(ongoingMovie);
        return ResponseEntity.ok(savedOngoingMovie);
    }
    public ResponseEntity<UpcomingMovie> createUpcomingMovie(@RequestBody @NotNull UpcomingMovie upcomingMovieDetails){

        UpcomingMovie upcomingMovie = new UpcomingMovie();
        upcomingMovie.setMovie_id(upcomingMovieDetails.getMovie_id());
        upcomingMovie.setMovie_title(upcomingMovieDetails.getMovie_title());
        upcomingMovie.setMovie_language(upcomingMovieDetails.getMovie_language());
        upcomingMovie.setAvailable_movie_dimensions(upcomingMovieDetails.getAvailable_movie_dimensions());
        upcomingMovie.setMovie_img_url(upcomingMovieDetails.getMovie_img_url());
        upcomingMovie.setGenre(upcomingMovieDetails.getGenre());
        upcomingMovie.setReleaseDate(upcomingMovieDetails.getReleaseDate());
        UpcomingMovie savedUpcomingMovie = upcomingMovieRepo.save(upcomingMovie);
        return ResponseEntity.ok(savedUpcomingMovie);
    }

    public void deleteMovies(){
        ongoingMovieRepo.deleteAll();
        upcomingMovieRepo.deleteAll();
    }

    public ResponseEntity<OngoingMovie> getOngoingMovieByName(@PathVariable @NotNull String movie_title){
        OngoingMovie foundMovie = ongoingMovieRepo.findByMovieTitle(movie_title);
        return ResponseEntity.ok(foundMovie);
    }

    public ResponseEntity<MovieRequest> postMovieRequest(@RequestBody MovieRequest movieRequest) {
        this.storedMovieRequest = movieRequest;
        return ResponseEntity.ok(movieRequest);
    }

    public ResponseEntity<MovieRequest> getMovieRequest() {
        if (this.storedMovieRequest != null) {
            // Return the stored movie request
            return ResponseEntity.ok(this.storedMovieRequest);
        } else {
            // Handle case where no movie request has been stored yet
            return ResponseEntity.notFound().build();
        }
    }

}
