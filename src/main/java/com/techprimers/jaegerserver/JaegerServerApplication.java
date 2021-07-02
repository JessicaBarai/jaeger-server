package com.techprimers.jaegerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JaegerServerApplication {
	
	@GetMapping("/")
	public String welcome() {
		System.out.print("change enabled");
		return "welcome to java!";
		
	}


	public static void main(String[] args) {
		System.out.print("STARTING WITH PROPERTIES CHANGED!");
		SpringApplication.run(JaegerServerApplication.class, args);
	}

}
