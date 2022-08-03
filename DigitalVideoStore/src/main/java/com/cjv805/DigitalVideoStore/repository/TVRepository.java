package com.cjv805.DigitalVideoStore.repository;

import com.cjv805.DigitalVideoStore.model.TV;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVRepository extends MongoRepository<TV, String> {
}
