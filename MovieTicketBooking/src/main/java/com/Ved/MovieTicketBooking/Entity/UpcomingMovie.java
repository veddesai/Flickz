package com.Ved.MovieTicketBooking.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class UpcomingMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID movie_id;
    private String movie_title;

    private List<String> movie_language;

    private List<String> available_movie_dimensions;
    private String movie_img_url;

    private List<String> genre;

    private String releaseDate;
    public UpcomingMovie() {
    }

    public UpcomingMovie(UUID movie_id, String movie_title, List<String> movie_language, List<String> available_movie_dimensions, String movie_img_url, List<String> genre, String releaseDate) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_language = movie_language;
        this.available_movie_dimensions = available_movie_dimensions;
        this.movie_img_url = movie_img_url;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public UUID getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(UUID movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public List<String> getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(List<String> movie_language) {
        this.movie_language = movie_language;
    }

    public List<String> getAvailable_movie_dimensions() {
        return available_movie_dimensions;
    }

    public void setAvailable_movie_dimensions(List<String> available_movie_dimensions) {
        this.available_movie_dimensions = available_movie_dimensions;
    }

    public String getMovie_img_url() {
        return movie_img_url;
    }

    public void setMovie_img_url(String movie_img_url) {
        this.movie_img_url = movie_img_url;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "UpcomingMovie{" +
                "movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", movie_language='" + movie_language + '\'' +
                ", available_movie_dimensions=" + available_movie_dimensions +
                ", movie_img_url='" + movie_img_url + '\'' +
                ", genre=" + genre +
                '}';
    }
}
