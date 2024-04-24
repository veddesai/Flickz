package com.Ved.MovieTicketBooking.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class OngoingMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID movie_id;
    private String movie_title;

    private List<String> movie_language;

    private List<String> available_movie_dimensions;
    private String movie_img_url;


    private String movieRating;

    private List<String> genre;



    public OngoingMovie() {
        super();
    }

    public OngoingMovie(UUID movie_id, String movie_title, List<String> movie_language, List<String> available_movie_dimensions, String movie_img_url, String movieRating, List<String> genre) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_language = movie_language;
        this.available_movie_dimensions = available_movie_dimensions;
        this.movie_img_url = movie_img_url;
        this.movieRating = movieRating;
        this.genre = genre;

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

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }



    @Override
    public String toString() {
        return "OngoingMovie{" +
                "movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", movie_language='" + movie_language + '\'' +
                ", available_movie_dimensions=" + available_movie_dimensions +
                ", movie_img_url='" + movie_img_url + '\'' +
                ", movieRating=" + movieRating +
                ", genre=" + genre +
                '}';
    }
}
