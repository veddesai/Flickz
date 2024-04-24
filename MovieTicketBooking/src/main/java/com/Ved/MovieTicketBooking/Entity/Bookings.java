package com.Ved.MovieTicketBooking.Entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID booking_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private OngoingMovie ongoingMovie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;


    private List<Integer> seatNumbers ;



    private List<String> seatDetails;

    private int ticketPrice;

    private int numberOfSeats;

    private int totalPrice;

    private String showtime;

    private String showdate;


    public Bookings() {
        super();
    }

    public Bookings(UUID booking_id, User user, OngoingMovie ongoingMovie, Theatre theatre, List<Integer> seatNumbers, List<String> seatDetails, int ticketPrice, int numberOfSeats, int totalPrice, String showtime, String showdate) {
        this.booking_id = booking_id;
        this.user = user;
        this.ongoingMovie = ongoingMovie;
        this.theatre = theatre;
        this.seatNumbers = seatNumbers;
        this.seatDetails = seatDetails;
        this.ticketPrice = ticketPrice;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.showtime = showtime;
        this.showdate = showdate;
    }

    public UUID getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(UUID booking_id) {
        this.booking_id = booking_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OngoingMovie getOngoingMovie() {
        return ongoingMovie;
    }

    public void setOngoingMovie(OngoingMovie ongoingMovie) {
        this.ongoingMovie = ongoingMovie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
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

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }
}
