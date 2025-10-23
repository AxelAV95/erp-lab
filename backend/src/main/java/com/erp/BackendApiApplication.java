package com.erp;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication

public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

	@GetMapping("/api/health")
	public Map<String, String> healthCheck() {
		return Map.of("status", "Backend OK v1.0");
	}
}
