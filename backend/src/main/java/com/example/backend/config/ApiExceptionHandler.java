package com.example.backend.config;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, String>> handle(ResponseStatusException ex) {
		String message = ex.getReason() != null ? ex.getReason() : "エラーが発生しました";
		return ResponseEntity.status(ex.getStatusCode()).body(Map.of("message", message));
	}
}
