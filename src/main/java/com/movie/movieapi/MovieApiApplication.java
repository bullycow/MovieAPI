package com.movie.movieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan("com.movie.movieapi.movie")
@EntityScan("com.movie.movieapi.movie")
public class MovieApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}

}
