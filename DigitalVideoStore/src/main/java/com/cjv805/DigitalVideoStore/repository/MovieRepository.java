package com.cjv805.DigitalVideoStore.repository;

import com.cjv805.DigitalVideoStore.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
