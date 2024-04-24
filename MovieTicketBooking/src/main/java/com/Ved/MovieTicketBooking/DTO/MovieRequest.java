package com.Ved.MovieTicketBooking.DTO;

public class MovieRequest {

    private String movie_id;

    private String movie_title;

    private String movie_language;

    private String available_movie_dimensions;

    private String movie_img_url;

    private String genre;

    public MovieRequest() {
        super();
    }

    public MovieRequest(String movie_id, String movie_title, String movie_language, String available_movie_dimensions, String movie_img_url, String genre) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_language = movie_language;
        this.available_movie_dimensions = available_movie_dimensions;
        this.movie_img_url = movie_img_url;
        this.genre = genre;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public String getAvailable_movie_dimensions() {
        return available_movie_dimensions;
    }

    public void setAvailable_movie_dimensions(String available_movie_dimensions) {
        this.available_movie_dimensions = available_movie_dimensions;
    }

    public String getMovie_img_url() {
        return movie_img_url;
    }

    public void setMovie_img_url(String movie_img_url) {
        this.movie_img_url = movie_img_url;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
