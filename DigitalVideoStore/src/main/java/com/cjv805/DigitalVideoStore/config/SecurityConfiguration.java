package com.cjv805.DigitalVideoStore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService service;

    //This allows us to configure authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(service);
    }

    //This allows us to configure our authorization
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/movies/**").permitAll()
                .antMatchers("/tvs/**").permitAll()
                .antMatchers("/detail/movie/**").permitAll()
                .antMatchers("/movie/**").permitAll()
                .antMatchers("/detail/tv/**").permitAll()
                .antMatchers("/users").permitAll()
                .antMatchers("/movies/update/**").permitAll()
                .antMatchers("/tvs/update/**").permitAll()
                .antMatchers("/movies/delete/**").permitAll()
                .antMatchers("/tvs/delete/**").permitAll()
                .antMatchers("/tvs/update/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/auth").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
