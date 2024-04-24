package com.Ved.MovieTicketBooking.Service;

import com.Ved.MovieTicketBooking.DTO.MovieRequest;
import com.Ved.MovieTicketBooking.DTO.TheatreRequest;
import com.Ved.MovieTicketBooking.Entity.Theatre;
import com.Ved.MovieTicketBooking.Repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepo theatreRepository;

    private TheatreRequest storedTheatreRequest;

    public ResponseEntity<List<Theatre>> getAllTheatres() {
       return ResponseEntity.ok(theatreRepository.findAll());
    }


    public ResponseEntity<Theatre> getTheatreById(UUID id) {
        return ResponseEntity.ok(theatreRepository.findByTheatreId(id));
    }

    public ResponseEntity<Theatre> createTheatre(Theatre theatreDetails) {
        Theatre theatre = new Theatre();
        theatre.setTheatre_name(theatreDetails.getTheatre_name());
        theatre.setCity(theatreDetails.getCity());
        theatre.setLocation(theatreDetails.getLocation());
        theatre.setShowtimes(theatreDetails.getShowtimes());
        theatre.setScreen_type(theatreDetails.getScreen_type());
        theatre.setTicketPrices(theatreDetails.getTicketPrices());
        theatre.setSeatCapacity(theatreDetails.getSeatCapacity());
        theatre.setAvailableWeekDays(theatreDetails.getAvailableWeekDays());
        Theatre savedTheatre = theatreRepository.save(theatre);
        return ResponseEntity.ok(savedTheatre);
    }

    public void deleteTheatre(UUID id) {
      theatreRepository.deleteById(id);
    }

    public ResponseEntity<Theatre> updateTheatre(UUID id, Theatre theatre) {
        Theatre updatedTheatre = theatreRepository.findByTheatreId(id);
        updatedTheatre.setTicketPrices(theatre.getTicketPrices());
        updatedTheatre.setTheatre_name(theatre.getTheatre_name());
        updatedTheatre.setCity(theatre.getCity());
        updatedTheatre.setLocation(theatre.getLocation());
        updatedTheatre.setScreen_type(theatre.getScreen_type());
        updatedTheatre.setShowtimes(theatre.getShowtimes());
        updatedTheatre.setSeatCapacity(theatre.getSeatCapacity());
        updatedTheatre.setAvailableWeekDays(theatre.getAvailableWeekDays());
        return ResponseEntity.ok(updatedTheatre);
    }

    public ResponseEntity<List<Theatre>> getTheatresByCity(String city) {
        List<Theatre> theatres = theatreRepository.findByCity(city);


        if (theatres.isEmpty()) {

            return ResponseEntity.notFound().build();
        } else {

            return ResponseEntity.ok(theatres);
        }
    }

    public ResponseEntity<TheatreRequest> postTheatreRequest(@RequestBody TheatreRequest theatreRequest) {
        this.storedTheatreRequest = theatreRequest;
        return ResponseEntity.ok(theatreRequest);
    }

    public ResponseEntity<TheatreRequest> getTheatreRequest() {
        if (this.storedTheatreRequest != null) {

            return ResponseEntity.ok(this.storedTheatreRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
