package com.learncode.springsecurity.springsecurity3.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learncode.springsecurity.springsecurity3.entity.User;

public interface UserRepository extends MongoRepository<User,String>{
    
    Optional<User> findByName(String username);
}
