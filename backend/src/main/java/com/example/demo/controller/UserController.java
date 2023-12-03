package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private final PasswordEncoder passwordEncoder;

	public UserController(UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/signup")
	public void signup(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

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
