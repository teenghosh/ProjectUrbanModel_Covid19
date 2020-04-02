package com.garage48.covid19.projecturban.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthenticationResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 967106617289927962L;
	private final String token;
}
