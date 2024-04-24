package com.Ved.MovieTicketBooking.DTO;

import java.util.List;

public class SeatRequest {

    private TheatreRequest theatreRequest;

    private List<Integer> seatNumbers ;



    private List<String> seatDetails;

    private int ticketPrice;

    private int numberOfSeats;

    private int totalPrice;

    public SeatRequest() {
        super();
    }

    public SeatRequest(TheatreRequest theatreRequest, List<Integer> seatNumbers, List<String> seatDetails, int ticketPrice, int numberOfSeats, int totalPrice) {
        this.theatreRequest = theatreRequest;
        this.seatNumbers = seatNumbers;
        this.seatDetails = seatDetails;
        this.ticketPrice = ticketPrice;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
    }

    public TheatreRequest getTheatreRequest() {
        return theatreRequest;
    }

    public void setTheatreRequest(TheatreRequest theatreRequest) {
        this.theatreRequest = theatreRequest;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public List<String> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(List<String> seatDetails) {
        this.seatDetails = seatDetails;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
