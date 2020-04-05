package com.garage48.covid19.projecturban.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_personal_details")
@Getter
@Setter
public class UserPersonalDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282554544129462959L;
	
	@Id
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(updatable=true)
	private long phonenumber;
	
	@Column(updatable=true)
	private String aadharNo;
	
	@Column(updatable=true)
	private int age;
	
	@Column(updatable=true)
	private String mailId;
	
	@Column(updatable=true)
	private double monthlyIncome;
	
	@Column(updatable=true)
	private String name;
	
	@Column(insertable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp timestamp;
	

}
