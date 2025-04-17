package com.bbank.app.auth.controller;

import com.bbank.app.auth.config.JwtUtil;
import com.bbank.app.auth.model.JwtRequest;
import com.bbank.app.auth.model.JwtResponse;
import com.bbank.app.service.AppUserDetailService;
import com.bbank.app.model.LoginUser;
import com.bbank.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/auth")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AppUserDetailService appUserDetailService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
		SecurityContextHolder
				.getContext()
				.setAuthentication(
						authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		final UserDetails userDetails = appUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtUtil.generateToken(userDetails);
		LoginUser user = userService.getUserByUserName(authenticationRequest.getUsername());
		JwtResponse jwtResponse = new JwtResponse(token);
		jwtResponse.setUser(user);
		return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
	}

	private Authentication authenticate(String username, String password) {
		try {
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
}