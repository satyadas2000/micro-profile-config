package com.howtodoinjava.example.employee.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Profiles" )
public interface ProfileServiceClient {

	@GetMapping("/v1/welcome")
	public String getDataBaseConnectionDetails() ;
	
	
}
