package com.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	@Value("${app.message}")
	private String welcomeMessage;
	
	@GetMapping("/v1/welcome")
	public String getDataBaseConnectionDetails() {
		return welcomeMessage;
	}
	@GetMapping("/v2/welcome")
	public String getDataBaseConnectionDetailsv2() {
		return welcomeMessage+"satya";
	}
}
