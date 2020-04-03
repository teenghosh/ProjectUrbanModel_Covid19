package com.garage48.covid19.projecturban.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(value=Include.NON_NULL)
@Getter
@Setter
public class UIresponseStructure<T> {
	
	
	private T data;
	
	private ErrorData error;

	public UIresponseStructure(T data) {
		this.data = data;
	}

}
