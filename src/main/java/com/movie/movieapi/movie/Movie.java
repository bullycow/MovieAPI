package com.movie.movieapi.movie;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;


@Entity
public class Movie {
    
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id long id;
    
    String title;
    Timestamp releaseDate;
    float rating;
    long revenue;

    public Movie() {}

    public Movie(String title, Timestamp releaseDate, float rating, long revenue) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.revenue = revenue;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Timestamp getReleaseDate() {
        return this.releaseDate;
    }

    public float getRating() {
        return this.rating;
    }

    public long getRevenue() {
        return this.revenue;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
}
