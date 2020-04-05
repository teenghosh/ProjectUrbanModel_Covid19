package com.garage48.covid19.projecturban.service;

import com.garage48.covid19.projecturban.pojo.AddressEntity;
import com.garage48.covid19.projecturban.pojo.OrderDetailsEntity;
import com.garage48.covid19.projecturban.pojo.UserPersonalDetails;

import javassist.NotFoundException;

public interface UserAppServices {

	
	public boolean saveUserAddress(AddressEntity address) throws Exception;

	OrderDetailsEntity saveUserOrderDetails(OrderDetailsEntity orders) throws Exception;
	
	OrderDetailsEntity fetchUserOrderDetails(String username) throws NotFoundException, Exception;

	UserPersonalDetails saveUserPersonalDetails(UserPersonalDetails details) throws Exception;

	UserPersonalDetails fetchUserPersonalDetails(String username) throws Exception;
}
