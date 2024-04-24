package com.Ved.MovieTicketBooking.Service;

import com.Ved.MovieTicketBooking.DTO.SeatRequest;
import com.Ved.MovieTicketBooking.DTO.TheatreRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SeatService {
    private SeatRequest storedSeatRequest;

    public ResponseEntity<SeatRequest> postSeatRequest(@RequestBody SeatRequest seatRequest) {
        this.storedSeatRequest = seatRequest;
        return ResponseEntity.ok(seatRequest);
    }

    public ResponseEntity<SeatRequest> getSeatRequest() {
        if (this.storedSeatRequest != null) {

            return ResponseEntity.ok(this.storedSeatRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
