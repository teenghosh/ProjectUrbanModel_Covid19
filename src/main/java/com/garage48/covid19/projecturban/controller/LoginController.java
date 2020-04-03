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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage48.covid19.projecturban.pojo.AuthenticationRequest;
import com.garage48.covid19.projecturban.pojo.AuthenticationResponse;
import com.garage48.covid19.projecturban.pojo.SignupRequest;
import com.garage48.covid19.projecturban.pojo.UIresponseStructure;
import com.garage48.covid19.projecturban.pojo.UserEntity;
import com.garage48.covid19.projecturban.service.TokenGeneratorService;
import com.garage48.covid19.projecturban.service.UserDetailServiceImpl;
import com.garage48.covid19.projecturban.service.UserDetailsBeanImpl;

@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenGeneratorService tokenGenerator;
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping(value = "/public/authenticate")
	public ResponseEntity<UIresponseStructure<AuthenticationResponse>> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetailsBeanImpl userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = tokenGenerator.generateToken(userDetails);

		return new ResponseEntity<UIresponseStructure<AuthenticationResponse>>( new UIresponseStructure<>(new AuthenticationResponse(token,userDetails.getName(),userDetails.getUsername())), HttpStatus.OK);
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
	
	@PostMapping(value = "/public/newuser")
	public ResponseEntity<UIresponseStructure<AuthenticationResponse>> createAuthenticationToken(
			@RequestBody SignupRequest user) throws Exception {

		UserEntity userToSave = new UserEntity();
		populateUserEntity(userToSave,user);
		UserDetailsBeanImpl userDetails = userDetailsService.saveUserCredentials(userToSave);

		final String token = tokenGenerator.generateToken(userDetails);

		return new ResponseEntity<UIresponseStructure<AuthenticationResponse>>( new UIresponseStructure<>(new AuthenticationResponse(token,userDetails.getName(),userDetails.getUsername())), HttpStatus.OK);
	}
	
	private void  populateUserEntity(UserEntity userToSave,SignupRequest user) {
		userToSave.setAccountNonExpired(true);
		userToSave.setAccountNonLocked(true);
		userToSave.setCredentialsNonExpired(true);
		userToSave.setEnabled(true);
		userToSave.setName(user.getName());
		userToSave.setRole("user");
		userToSave.setUsername(user.getUsername());
		userToSave.setPassword(encoder.encode(user.getPassword()));
		userToSave.setEnabled(true);
	}
}
