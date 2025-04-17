package com.bbank.app.service;

import com.bbank.app.auth.model.PrincipalUser;
import com.bbank.app.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //NOSONAR
		
		LoginUser user = userService.getUserByUserName(username);
		if (user != null) {
			return new PrincipalUser(user);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}