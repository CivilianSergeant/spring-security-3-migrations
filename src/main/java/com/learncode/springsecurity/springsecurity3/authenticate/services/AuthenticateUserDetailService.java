package com.learncode.springsecurity.springsecurity3.authenticate.services;

import com.learncode.springsecurity.springsecurity3.entity.LoginDetail;
import com.learncode.springsecurity.springsecurity3.entity.User;
import com.learncode.springsecurity.springsecurity3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AuthenticateUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<User> userOp = userRepository.findByName(username);
        LoginDetail ld = userOp.map(LoginDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " User not found"));
        return ld;
    }



    
}
