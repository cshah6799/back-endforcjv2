package com.cjv805.DigitalVideoStore.repository;

import com.cjv805.DigitalVideoStore.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'username' : ?0 }")
    User findByUsername(String username);

}
