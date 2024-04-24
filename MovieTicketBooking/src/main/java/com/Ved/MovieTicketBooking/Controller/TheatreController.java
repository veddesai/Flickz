package com.Ved.MovieTicketBooking.Controller;

import com.Ved.MovieTicketBooking.DTO.MovieRequest;
import com.Ved.MovieTicketBooking.DTO.TheatreRequest;
import com.Ved.MovieTicketBooking.Entity.Theatre;
import com.Ved.MovieTicketBooking.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/theatre")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping("/list")
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> getTheatresByCity(@RequestParam String city){
         return theatreService.getTheatresByCity(city);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable("id") UUID id) {
        return theatreService.getTheatreById(id);
    }


    @PostMapping
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre) {
        return theatreService.createTheatre(theatre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable("id") UUID id, @RequestBody Theatre theatre) {
        return theatreService.updateTheatre(id, theatre);
    }

    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable("id") UUID id) {
        theatreService.deleteTheatre(id);
    }

    @GetMapping("/bookTheatre")
    public ResponseEntity<?> getMovieRequest(){
        return theatreService.getTheatreRequest();
    }

    @PostMapping("/bookTheatre")
    public ResponseEntity<?> postTheatreRequest(@RequestBody TheatreRequest theatreRequest){
        return theatreService.postTheatreRequest(theatreRequest);
    }
}
