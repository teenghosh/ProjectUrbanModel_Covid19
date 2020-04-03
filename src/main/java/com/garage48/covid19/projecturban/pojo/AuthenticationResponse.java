package com.garage48.covid19.projecturban.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value=Include.NON_NULL)
public class AuthenticationResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 967106617289927962L;
	private  String token;
	private String name;
	private String username;
}
