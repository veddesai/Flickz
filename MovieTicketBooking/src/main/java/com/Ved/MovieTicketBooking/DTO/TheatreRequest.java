package com.Ved.MovieTicketBooking.DTO;

import com.Ved.MovieTicketBooking.Entity.Theatre;

public class TheatreRequest {
    private String movie_title;

    private String movie_format;

    private String movie_img_url;

    private String movie_language;

    private Theatre theatre;

    private String Showdate;

    private String showtime;

    public TheatreRequest() {
        super();
    }

    public TheatreRequest(String movie_title, String movie_format, String movie_img_url, String movie_language, Theatre theatre, String showdate, String showtime) {
        this.movie_title = movie_title;
        this.movie_format = movie_format;
        this.movie_img_url = movie_img_url;
        this.movie_language = movie_language;
        this.theatre = theatre;
        Showdate = showdate;
        this.showtime = showtime;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_format() {
        return movie_format;
    }

    public void setMovie_format(String movie_format) {
        this.movie_format = movie_format;
    }

    public String getMovie_img_url() {
        return movie_img_url;
    }

    public void setMovie_img_url(String movie_img_url) {
        this.movie_img_url = movie_img_url;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getShowdate() {
        return Showdate;
    }

    public void setShowdate(String showdate) {
        Showdate = showdate;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }
}
