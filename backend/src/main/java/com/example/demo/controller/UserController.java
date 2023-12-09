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
		user.setRole("USER");

		userRepository.save(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		User userDb = userRepository
				.findUserByUsername(user.getUsername())
				.filter(uDb -> passwordEncoder.matches(user.getPassword(),
						uDb.getPassword()))
				.get();

		return userDb;
	}

	@GetMapping("/demo")
	public String demo() {
		return "Demo";
	}
}
