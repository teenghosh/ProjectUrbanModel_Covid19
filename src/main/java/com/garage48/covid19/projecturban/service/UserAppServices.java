package com.garage48.covid19.projecturban.service;

import com.garage48.covid19.projecturban.pojo.AddressEntity;
import com.garage48.covid19.projecturban.pojo.OrderDetailsEntity;

public interface UserAppServices {

	
	public boolean saveUserAddress(AddressEntity address) throws Exception;

	OrderDetailsEntity saveUserOrderDetails(OrderDetailsEntity orders) throws Exception;
}
