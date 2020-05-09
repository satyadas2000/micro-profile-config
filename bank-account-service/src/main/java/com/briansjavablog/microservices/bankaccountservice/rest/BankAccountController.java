package com.briansjavablog.microservices.bankaccountservice.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.briansjavablog.microservices.bankaccountservice.config.Configuration;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BankAccountController {

 
	
	@Autowired
	private Configuration configuration;
	

	
	@GetMapping("/welcome")
	public String getDataBaseConnectionDetails() {
		return String.valueOf(configuration.getMinBalance());
	}
	
	
	
}
