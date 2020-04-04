package com.garage48.covid19.projecturban.pojo;

import java.util.Map;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.garage48.covid19.projecturban.util.MaptoJsonString;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="userorderdetails")
@Getter
@Setter
public class OrderDetailsEntity {

	@Id
	private String username;
	
	private int noOfAdult;
	
	private int noOfChild;
	
	@Convert(converter=MaptoJsonString.class)
	private Map<String, Object> items;
}
