package com.Ved.MovieTicketBooking.DTO;

import com.Ved.MovieTicketBooking.Entity.OngoingMovie;
import com.Ved.MovieTicketBooking.Entity.UpcomingMovie;

import java.util.List;

public class MovieDTO {
    private List<OngoingMovie> ongoingMovies;
    private List<UpcomingMovie> upcomingMovies;

    public MovieDTO() {
    }

    public MovieDTO(List<OngoingMovie> ongoingMovies, List<UpcomingMovie> upcomingMovies) {
        this.ongoingMovies = ongoingMovies;
        this.upcomingMovies = upcomingMovies;
    }

    public List<OngoingMovie> getOngoingMovies() {
        return ongoingMovies;
    }

    public void setOngoingMovies(List<OngoingMovie> ongoingMovies) {
        this.ongoingMovies = ongoingMovies;
    }

    public List<UpcomingMovie> getUpcomingMovies() {
        return upcomingMovies;
    }

    public void setUpcomingMovies(List<UpcomingMovie> upcomingMovies) {
        this.upcomingMovies = upcomingMovies;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "ongoingMovies=" + ongoingMovies +
                ", upcomingMovies=" + upcomingMovies +
                '}';
    }
}
