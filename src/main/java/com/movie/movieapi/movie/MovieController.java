package com.movie.movieapi.movie;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    
    @Autowired
    private MovieService service;

    @GetMapping("/")
    public String welcome() {
        return "<html><body>"
            + "<h1>WELCOME</h1>"
            + "</body></html>";
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return service.getMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable(value = "id") long id) {
        return service.getMovieById(id);
    }

    @GetMapping("/movies/release/{ad}") 
    public List<Movie> getMoviesByRelease(@PathVariable(value = "ad")char sequence) {
        if(sequence == 'a') return service.getMoviesSortedAscendingRelease();
        else if (sequence == 'd') return service.getMoviesSortedDescendingRelease();
        return null;
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie movie) {
        return service.saveOrUpdate(movie);  
    }

    @Transactional
    @DeleteMapping("/movies/delete/{id}")
    public void deleteMovie(@PathVariable(value = "id") long id) {
        service.deleteMovieById(id);
    }

    @Transactional
    @PutMapping("/movies/{id}")
    public ResponseEntity<Object> updateMovie(@RequestBody Movie movie, @PathVariable (value = "id") long id) {
        Optional<Movie> movieRepo = Optional.ofNullable(service.getMovieById(id));
        
        if(!movieRepo.isPresent()) return ResponseEntity.notFound().build();
        
        movieRepo.get().setRating(movie.getRating());
        movieRepo.get().setReleaseDate(movie.getReleaseDate());
        movieRepo.get().setRevenue(movie.getRevenue());
        movieRepo.get().setTitle(movie.getTitle());
        service.saveOrUpdate(movieRepo.get());

        return ResponseEntity.noContent().build();
    }
}
