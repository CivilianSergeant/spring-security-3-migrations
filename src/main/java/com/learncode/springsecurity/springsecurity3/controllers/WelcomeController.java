package com.learncode.springsecurity.springsecurity3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learncode.springsecurity.springsecurity3.repositories.UserRepository;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public ResponseEntity<?> welcome(){
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }
}
