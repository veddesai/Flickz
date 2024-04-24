package com.Ved.MovieTicketBooking.Controller;

import com.Ved.MovieTicketBooking.DTO.MovieDTO;
import com.Ved.MovieTicketBooking.DTO.MovieRequest;
import com.Ved.MovieTicketBooking.Entity.OngoingMovie;
import com.Ved.MovieTicketBooking.Entity.UpcomingMovie;
import com.Ved.MovieTicketBooking.Service.MovieService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/ongoing")
    public ResponseEntity<List<OngoingMovie>> getAllOngoingMovies() {
        return movieService.getAllOngoingMovies();
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<UpcomingMovie>> getAllUpcomingMovies() {
        return movieService.getAllUpcomingMovies();
    }

    @PostMapping("/ongoing")
    public ResponseEntity<OngoingMovie> createOngoingMovie(@RequestBody OngoingMovie movie){
        return movieService.createOngoingMovie(movie);
    }

    @PostMapping("/upcoming")
    public ResponseEntity<UpcomingMovie> createUpcomingMovie(@RequestBody UpcomingMovie movie){
        return movieService.createUpcomingMovie(movie);
    }

    @GetMapping("/ongoing/{movie_title}")
    public ResponseEntity<OngoingMovie> getOngoingMovieByName(@PathVariable @NotNull String movie_title){
        return movieService.getOngoingMovieByName(movie_title);
    }

    @GetMapping("/bookMovie")
    public ResponseEntity<?> getMovieRequest(){
        return movieService.getMovieRequest();
    }

    @PostMapping("/bookMovie")
    public ResponseEntity<?> postMovieRequest(@RequestBody MovieRequest movieRequest){
        return movieService.postMovieRequest(movieRequest);
    }

    @DeleteMapping
    public void deleteMovies(){
        movieService.deleteMovies();
    }

}
