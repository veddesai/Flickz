package com.Ved.MovieTicketBooking.Controller;

import com.Ved.MovieTicketBooking.DTO.SeatRequest;
import com.Ved.MovieTicketBooking.DTO.TheatreRequest;
import com.Ved.MovieTicketBooking.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seats")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/bookSeat")
    public ResponseEntity<?> getSeatRequest(){
        return seatService.getSeatRequest();
    }

    @PostMapping("/bookSeat")
    public ResponseEntity<?> postSeatRequest(@RequestBody SeatRequest seatRequest){
        return seatService.postSeatRequest(seatRequest);
    }
}
