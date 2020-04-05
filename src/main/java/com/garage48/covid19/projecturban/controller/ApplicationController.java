package com.garage48.covid19.projecturban.controller;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage48.covid19.projecturban.pojo.AddressEntity;
import com.garage48.covid19.projecturban.pojo.OrderDetailsEntity;
import com.garage48.covid19.projecturban.pojo.UIresponseStructure;
import com.garage48.covid19.projecturban.pojo.UserPersonalDetails;
import com.garage48.covid19.projecturban.service.UserAppServices;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApplicationController {

	@Autowired
	UserAppServices userappservices;

	@PostMapping(value = "/secure/saveaddress")
	public ResponseEntity<?> saveUserAddress(@RequestBody AddressEntity addressEntity) throws Exception {

		boolean result = userappservices.saveUserAddress(addressEntity);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		if (result)
			status = HttpStatus.OK;

		return new ResponseEntity<>(status);
	}

	@PostMapping(value = "/secure/saveorders")
	public ResponseEntity<UIresponseStructure<String>> saveUserOrders(@RequestBody OrderDetailsEntity orderDetailsEntity) throws Exception {

		OrderDetailsEntity result = userappservices.saveUserOrderDetails(orderDetailsEntity);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		if (Objects.nonNull(result))
			status = HttpStatus.OK;

		return new ResponseEntity<UIresponseStructure<String>>(new UIresponseStructure<>("Success"),status);
	}
	@GetMapping(value = "/secure/getuserorderdetails/{username}")
	public ResponseEntity<UIresponseStructure<OrderDetailsEntity>> fetchUserOrders(@NotNull @PathVariable(name="username") String username) throws Exception {

		OrderDetailsEntity result = userappservices.fetchUserOrderDetails(username);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		if (Objects.nonNull(result))
			status = HttpStatus.OK;

		return new ResponseEntity<UIresponseStructure<OrderDetailsEntity>>(new UIresponseStructure<>(result),status);
	}
	
	@PostMapping(value = "/secure/saveperosnaldetails")
	public ResponseEntity<UIresponseStructure<String>> saveUserPersonalDetails(@RequestBody UserPersonalDetails user) throws Exception {

		UserPersonalDetails result = userappservices.saveUserPersonalDetails(user);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		if (Objects.nonNull(result))
			status = HttpStatus.OK;

		return new ResponseEntity<UIresponseStructure<String>>(new UIresponseStructure<>("Success"),status);
	}
	
	@GetMapping(value = "/secure/getperosnaldetails/{username}")
	public ResponseEntity<UIresponseStructure<UserPersonalDetails>> getUserPersonalDetails(@NotNull @PathVariable(name="username") String username) throws Exception {

		UserPersonalDetails result = userappservices.fetchUserPersonalDetails(username);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		if (Objects.nonNull(result))
			status = HttpStatus.OK;

		return new ResponseEntity<UIresponseStructure<UserPersonalDetails>>(new UIresponseStructure<>(result),status);
	}
	
	
}
