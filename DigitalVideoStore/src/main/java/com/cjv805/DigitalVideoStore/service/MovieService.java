package com.cjv805.DigitalVideoStore.service;

import com.cjv805.DigitalVideoStore.model.Movie;
import com.cjv805.DigitalVideoStore.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }




    public Optional<Movie> getMovie(String id) throws Exception
    {

        Optional<Movie> movie = movieRepository.findById(id);


        if (!movie.isPresent())
        {
            throw new Exception (" Movie with "+id+" is not found ");
        }

        return movie;

    }

    public List<Movie> getMoviesWithTitle(String t) throws Exception {

        Query query = new Query();
        query.addCriteria(Criteria.where("Title" ).is(t));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        if (!movies.isEmpty())
        {
            return movies;
        }
        throw new Exception("Movie not found");


    }


    public Movie addMovie(Movie movie) {
        return movieRepository.insert(movie);
    }

    public Movie updateMovie(String id, Movie movie) throws Exception {
        movie.set_id(id);
        Optional<Movie> movies1 = movieRepository.findById(id);
        if (!movies1.isPresent())
        {
            throw new Exception("Movie not found");

        }
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id) throws Exception {
        Optional<Movie> movies1 = movieRepository.findById(id);
        if (!movies1.isPresent())
        {
            throw new Exception("Movie not found");

        }
        movieRepository.deleteById(id);}


}
