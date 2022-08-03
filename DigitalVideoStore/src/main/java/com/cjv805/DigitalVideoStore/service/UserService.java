package com.cjv805.DigitalVideoStore.service;

import com.cjv805.DigitalVideoStore.model.User;
import com.cjv805.DigitalVideoStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    public User addUser(User user){
        User u = userRepository.findByUsername(user.getUsername());
        if(u==null) {
            String encodedPassword = bcrypt.encode(user.getPassword());
            user.setPassword(encodedPassword);

            User insertedUser = userRepository.insert(user);

            return insertedUser;
        } else{
            return null;
        }
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id){
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User foundUser = userRepository.findByUsername(username);

        String userN = foundUser.getUsername();
        String passW = foundUser.getPassword();
        return new org.springframework.security.core.userdetails.User(userN, passW, new ArrayList<>());
    }
}
