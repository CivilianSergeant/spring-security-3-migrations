package com.learncode.springsecurity.springsecurity3;

import com.learncode.springsecurity.springsecurity3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurity3Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity3Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		User u = new User();
//		u.setName("admin");
//		u.setPassword(passwordEncoder.encode("1234"));
//		u.setRoles("ADMIN");
//		userRepository.save(u);
	}
}
