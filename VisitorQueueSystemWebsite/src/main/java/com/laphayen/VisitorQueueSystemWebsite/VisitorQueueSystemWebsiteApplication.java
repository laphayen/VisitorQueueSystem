package com.laphayen.VisitorQueueSystemWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class VisitorQueueSystemWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorQueueSystemWebsiteApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index";

	}

}
