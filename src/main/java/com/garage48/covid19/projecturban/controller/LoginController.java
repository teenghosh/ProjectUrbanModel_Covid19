package com.garage48.covid19.projecturban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage48.covid19.projecturban.pojo.AuthenticationRequest;
import com.garage48.covid19.projecturban.pojo.AuthenticationResponse;
import com.garage48.covid19.projecturban.service.TokenGeneratorService;
import com.garage48.covid19.projecturban.service.UserDetailServiceImpl;

@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenGeneratorService tokenGenerator;
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@PostMapping(value = "/public/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = tokenGenerator.generateToken(userDetails);

		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(token), HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {

			throw new Exception("userid is not active", e);

		} catch (BadCredentialsException e) {
			throw new Exception("invalid credentials", e);
		}
	}
}
