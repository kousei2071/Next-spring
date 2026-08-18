package com.example.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.backend.dto.RegisterRequest;
import com.example.backend.dto.UserResponse;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public UserResponse register(RegisterRequest request) {
		if (request == null || isBlank(request.name()) || isBlank(request.email()) || isBlank(request.password())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "入力内容を確認してください");
		}

		String email = request.email().trim().toLowerCase();
		if (userRepository.existsByEmail(email)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "このメールアドレスは既に使われています");
		}

		User user = new User();
		user.setEmail(email);
		user.setName(request.name().trim());
		user.setPassword(passwordEncoder.encode(request.password()));
		return UserResponse.from(userRepository.save(user));
	}

	private static boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}
}
