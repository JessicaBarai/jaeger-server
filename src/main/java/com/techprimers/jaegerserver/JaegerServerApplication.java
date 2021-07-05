package com.techprimers.jaegerserver;

import org.springframework.boot.SpringApplication;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JaegerServerApplication {
	
	@RequestMapping("/")
	public String welcome() throws JSONException {
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("Message", "Hello from server");
		return jsonObject.toString();
		
	}


	public static void main(String[] args) {
		System.out.print("STARTING WITH PROPERTIES CHANGED!");
		SpringApplication.run(JaegerServerApplication.class, args);
	}

}
