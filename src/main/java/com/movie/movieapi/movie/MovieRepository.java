package com.movie.movieapi.movie;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer>{

    Movie findById(long id);

    List<Movie> findAll();

    void deleteById(long id);

    List<Movie> findAllBy();

    List<Movie> findAll(Sort sort);

}
