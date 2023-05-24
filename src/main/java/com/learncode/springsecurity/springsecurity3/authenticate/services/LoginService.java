package com.learncode.springsecurity.springsecurity3.authenticate.services;

import com.learncode.springsecurity.springsecurity3.authenticate.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public String authenticate(AuthRequest authRequest){
        String token = null;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            token = jwtService.generateToken(authRequest.getUsername());
        }
        return token;
    }
}
