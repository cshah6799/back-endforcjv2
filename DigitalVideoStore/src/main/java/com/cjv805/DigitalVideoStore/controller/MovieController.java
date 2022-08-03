package com.cjv805.DigitalVideoStore.controller;

import com.cjv805.DigitalVideoStore.model.Movie;
import com.cjv805.DigitalVideoStore.CustomizedResponse;
import com.cjv805.DigitalVideoStore.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity getMovies() {
        return new ResponseEntity(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/detail/movie/{id}")
    public ResponseEntity getMovie(@PathVariable("id") String id) {
        CustomizedResponse customizedResponse = null;
        try {
            return new ResponseEntity(movieService.getMovie(id), HttpStatus.OK);
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);

            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/movies/{title}")
    public ResponseEntity getmoviesByTitle(@RequestParam(value = "title") String t)
    {
        CustomizedResponse customizedResponse = null;
        try {
            return new ResponseEntity(movieService.getMoviesWithTitle(t), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Movie not found", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/movies/update/{id}")
    public ResponseEntity updateMovie(@PathVariable("id") String id, @RequestBody Movie movies) {
        try {
            movieService.updateMovie(id, movies);
            return new ResponseEntity("Movie Updated", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Movie not updated", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/movies/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") String id) {
        try {
            movieService.deleteMovie(id);
            return new ResponseEntity("Movie Deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Movie Not Deleted", HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping(value = "/movies", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity createMovie(@RequestBody Movie movie){
        if(movieService.addMovie(movie)==null){
            return new ResponseEntity("Movie Not Added",HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity("Movie Added",HttpStatus.OK);
        }

    }
}
