package com.movie.movieapi.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired 
    MovieRepository repository;
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(long id) {
        return repository.findById(id);
    }

    public Movie saveOrUpdate(Movie movie) {
        return repository.save(movie);
    }

    public void deleteMovieById(long id) {
        repository.deleteById(id);
    }
    
    public List<Movie> getMoviesSortedAscendingRelease() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "releaseDate"));
    }

    public List<Movie> getMoviesSortedDescendingRelease() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "releaseDate"));
    }
}

   
