package com.garage48.covid19.projecturban.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage48.covid19.projecturban.dao.UserAddressDao;
import com.garage48.covid19.projecturban.dao.UserOrderDetailsDao;
import com.garage48.covid19.projecturban.pojo.AddressEntity;
import com.garage48.covid19.projecturban.pojo.OrderDetailsEntity;

@Service
public class UserAppServicesImpl implements UserAppServices {

	private static final Log logger = LogFactory.getLog(UserAppServicesImpl.class);
	@Autowired
	private UserAddressDao addressDao;
	@Autowired
	UserOrderDetailsDao  userOrderDao;
	
	@Override
	public boolean saveUserAddress(AddressEntity address) throws Exception {
		try {
		addressDao.save(address);
		}
		catch (Exception e) {
			logger.error("Error occured during saving user's address {}",e);
			return false;
		}
		return true;
	}

	/**
	 * @param orders
	 * @return
	 * @throws Exception
	 */
	@Override
	public OrderDetailsEntity saveUserOrderDetails(OrderDetailsEntity orders) throws Exception {

		try {
			return userOrderDao.save(orders);
		}
		catch (Exception e) {
			logger.error("Exception occurred while fetching usernsame");
			throw new Exception("Error occurred during saving user credentials");
		}

	}
}
