package com.garage48.covid19.projecturban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage48.covid19.projecturban.pojo.AddressEntity;
import com.garage48.covid19.projecturban.service.UserAppServices;

@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApplicationController {

	
	@Autowired
	UserAppServices userappservices;
	
	@PostMapping(value = "/secure/saveaddress")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody AddressEntity addressEntity) throws Exception {

		boolean result = userappservices.saveUserAddress(addressEntity);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		if(result)
			status = HttpStatus.OK;

		return new ResponseEntity<>(status);
	}
}
