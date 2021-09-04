package com.asapp.backend.challenge.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asapp.backend.challenge.model.user.CreateUserResponse;
import com.asapp.backend.challenge.model.user.User;
import com.asapp.backend.challenge.repositories.UserRepository;

@RestController
public class ApplicationUser {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/users")
	public CreateUserResponse createUser(@RequestBody User user) {
		logger.info("Attepting to create user: " + user);
		user.hashPassword();
		if (userRepository.exists(Example.of(user, ExampleMatcher.matching().withIgnorePaths("id", "password")))) {
			throw new RuntimeException("User already exists");
		}
		User savedUser = userRepository.save(user);
		return new CreateUserResponse(savedUser.getId());
	}

	private final Logger logger = LoggerFactory.getLogger(ApplicationUser.class);

}
