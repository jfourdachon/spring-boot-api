package edu.itakademy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.itakademy.demo.configuration.JwtTokenConfig;
import edu.itakademy.demo.entity.User;
import edu.itakademy.demo.model.JwtRequest;
import edu.itakademy.demo.model.JwtResponse;
import edu.itakademy.demo.service.JwtUserDetailsService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class JwtAuthenticationController {	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtTokenConfig jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {	

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());	
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());		
		final String token = jwtTokenUtil.generateToken(userDetails);	
		return ResponseEntity.ok(new JwtResponse(token));
	}
	

	@PostMapping("/signup")	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
    
	
	public void authenticate(String username, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}