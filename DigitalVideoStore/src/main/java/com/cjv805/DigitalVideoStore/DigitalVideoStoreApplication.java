package com.cjv805.DigitalVideoStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class DigitalVideoStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalVideoStoreApplication.class, args);
	}

}
