package com.garage48.covid19.projecturban.pojo;

import java.sql.Date;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
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
	
	@Column
	private int noOfAdult;
	@Column
	private int noOfChild;
	@Column
	private String orderStatus;
	@Column
	private String optForLocalDelivery;
	@Column
	@Convert(converter=MaptoJsonString.class)
	private Map<String, Object> items;
	
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date orderPlacedAt;
}
