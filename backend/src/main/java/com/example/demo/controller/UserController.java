package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/signup")
	public void signup(@RequestBody User user) {
		userRepository.save(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		System.out.println(user.getPassword());

		return "OK";
	}

	@GetMapping("/demo")
	public String demo() {
		return "Demo";
	}
}
