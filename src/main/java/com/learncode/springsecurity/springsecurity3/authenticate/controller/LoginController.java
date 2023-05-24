package com.learncode.springsecurity.springsecurity3.authenticate.controller;

import com.learncode.springsecurity.springsecurity3.authenticate.dto.AuthRequest;
import com.learncode.springsecurity.springsecurity3.authenticate.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authReq){
        return new ResponseEntity<>(loginService.authenticate(authReq),HttpStatus.OK);
    }
    
}
