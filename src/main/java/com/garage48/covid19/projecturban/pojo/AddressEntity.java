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
	@Column(name="username",unique=true)
	private String username;
	
	@Column(name="ward",updatable=true)
	private String ward;
	
	@Column(name="street",updatable=true)
	private String street;
	
	@Column(name="municipalityArea",updatable=true)
	private String municipalityArea;
	
	@Column(name="policeStation",updatable=true)
	private String policeStation;
	
	@Column(name="pincode",updatable=true)
	private String pincode;
	
	@Column(name="district",updatable=true)
	private String district;
	
	@Column(name="state",updatable=true)
	private String state;
	
	

}
