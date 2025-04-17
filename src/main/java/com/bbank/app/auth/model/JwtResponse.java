package com.bbank.app.auth.model;

import com.bbank.app.model.LoginUser;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private final String jwtToken;
	
    private transient LoginUser user;

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getToken() {
		return this.jwtToken;
	}

}
