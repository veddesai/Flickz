package com.Ved.MovieTicketBooking.Entity;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.util.*;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID theatre_id;

    private String theatre_name;
    private String location;
    private String city;

    @ElementCollection
    @CollectionTable(name = "theatre_showtimes", joinColumns = @JoinColumn(name = "theatre_id"))
    @Column(name = "showtime")
    private List<String> showtimes;

    private String screen_type;

    @ElementCollection
    @CollectionTable(name = "theatre_seat_capacity", joinColumns = @JoinColumn(name = "theatre_id"))
    @MapKeyColumn(name = "screen_type")
    @Column(name = "seat_capacity")
    private Map<String, Integer> seatCapacity;

    @ElementCollection
    @CollectionTable(name = "theatre_ticket_prices", joinColumns = @JoinColumn(name = "theatre_id"))
    @MapKeyColumn(name = "screen_type")
    @Column(name = "ticket_price")
    private Map<String, Integer> ticketPrices;

    private List<String> availableWeekDays;

    public Theatre() {
        super();
    }

    public Theatre(UUID theatre_id, String theatre_name, String location, String city, List<String> showtimes, String screen_type, Map<String, Integer> seatCapacity, Map<String, Integer> ticketPrices, List<String> availableWeekDays) {
        this.theatre_id = theatre_id;
        this.theatre_name = theatre_name;
        this.location = location;
        this.city = city;
        this.showtimes = showtimes;
        this.screen_type = screen_type;
        this.seatCapacity = seatCapacity;
        this.ticketPrices = ticketPrices;
        this.availableWeekDays = availableWeekDays;
    }

    public UUID getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(UUID theatre_id) {
        this.theatre_id = theatre_id;
    }

    public String getTheatre_name() {
        return theatre_name;
    }

    public void setTheatre_name(String theatre_name) {
        this.theatre_name = theatre_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<String> showtimes) {
        this.showtimes = showtimes;
    }

    public String getScreen_type() {
        return screen_type;
    }

    public void setScreen_type(String screen_type) {
        this.screen_type = screen_type;
    }

    public Map<String, Integer> getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Map<String, Integer> seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public Map<String, Integer> getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(Map<String, Integer> ticketPrices) {
        this.ticketPrices = ticketPrices;
    }

    public List<String> getAvailableWeekDays() {
        return availableWeekDays;
    }

    public void setAvailableWeekDays(List<String> availableWeekDays) {
        this.availableWeekDays = availableWeekDays;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatre_id=" + theatre_id +
                ", theatre_name='" + theatre_name + '\'' +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", showtimes=" + showtimes +
                ", screen_type='" + screen_type + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", ticketPrices=" + ticketPrices +
                ", availableWeekDays=" + availableWeekDays +
                '}';
    }
}
