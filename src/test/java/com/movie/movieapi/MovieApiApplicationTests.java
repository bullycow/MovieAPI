package com.movie.movieapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.movieapi.movie.Movie;
import com.movie.movieapi.movie.MovieController;

@SpringBootTest
class MovieApiApplicationTests {

	@Autowired
	MovieApiApplication app;

	@Test
	void testMovieController() {
		MovieController controller = new MovieController();
		Movie newMovie = new Movie(
			"teste",
			new Timestamp(199999999),
			(float)9.0,
			1000000
		);
		Movie insertedMovie = controller.addMovie(newMovie);

		Movie aux = controller.getMovieById(insertedMovie.getId());

		assertEquals(aux.getId(),insertedMovie.getId());
		assertEquals(aux.getTitle(),insertedMovie.getTitle());
		assertEquals(aux.getReleaseDate(),insertedMovie.getReleaseDate());
		assertEquals(aux.getRating(),insertedMovie.getRating());
		assertEquals(aux.getRevenue(),insertedMovie.getRevenue());
	}

}
