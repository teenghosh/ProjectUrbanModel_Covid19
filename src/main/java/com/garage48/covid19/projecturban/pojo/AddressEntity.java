package com.garage48.covid19.projecturban.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="useraddress")
@Getter
@Setter
public class AddressEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -225968075984718408L;

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="ward")
	private String ward;
	
	@Column(name="street")
	private String street;
	
	@Column(name="municipalityArea")
	private String municipalityArea;
	
	@Column(name="policeStation")
	private String policeStation;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	

}
