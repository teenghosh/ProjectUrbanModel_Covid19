package com.garage48.covid19.projecturban.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class SignupRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4345077195781932663L;

	private String username;
	
	private String name;
	
	private String password;
}
