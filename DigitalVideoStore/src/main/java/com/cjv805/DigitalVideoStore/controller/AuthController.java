package com.cjv805.DigitalVideoStore.controller;

import com.cjv805.DigitalVideoStore.CustomizedResponse;
import com.cjv805.DigitalVideoStore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/auth", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody User user){
        String email = user.getEmail();
        user.setUsername(email);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            CustomizedResponse response = new CustomizedResponse(user.getUsername(), null);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch(BadCredentialsException ex){
            CustomizedResponse response = new CustomizedResponse("Wrong username or password! Please try again!", null);
            return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
        }
    }
}
