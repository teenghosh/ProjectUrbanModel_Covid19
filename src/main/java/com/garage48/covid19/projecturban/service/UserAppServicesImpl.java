package com.garage48.covid19.projecturban.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage48.covid19.projecturban.dao.PersonalDetailsDao;
import com.garage48.covid19.projecturban.dao.UserAddressDao;
import com.garage48.covid19.projecturban.dao.UserOrderDetailsDao;
import com.garage48.covid19.projecturban.pojo.AddressEntity;
import com.garage48.covid19.projecturban.pojo.OrderDetailsEntity;
import com.garage48.covid19.projecturban.pojo.UserPersonalDetails;

import javassist.NotFoundException;

@Service
public class UserAppServicesImpl implements UserAppServices {

	private static final Log logger = LogFactory.getLog(UserAppServicesImpl.class);
	@Autowired
	private UserAddressDao addressDao;
	@Autowired
	UserOrderDetailsDao userOrderDao;
	@Autowired
	PersonalDetailsDao userPersonalDeatilsDao;

	@Override
	public boolean saveUserAddress(AddressEntity address) throws Exception {
		try {
			addressDao.save(address);
		} catch (Exception e) {
			logger.error("Error occured during saving user's address {}", e);
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
		} catch (Exception e) {
			logger.error("Exception occurred while saving order details");
			throw new Exception("Error occurred during saving order details");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.garage48.covid19.projecturban.service.UserAppServices#
	 * fetchUserOrderDetails(com.garage48.covid19.projecturban.pojo.
	 * OrderDetailsEntity)
	 */
	@Override
	public OrderDetailsEntity fetchUserOrderDetails(String username) throws NotFoundException, Exception {

		try {
			Optional<OrderDetailsEntity> data = userOrderDao.findById(username);
			if (data.isPresent())
				return data.get();
			else
				throw new NotFoundException("User's order details not found");
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while fetching user's order details");
			throw new Exception("Error occurred during fetching order details");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.garage48.covid19.projecturban.service.UserAppServices#
	 * saveUserPersonalDetails(com.garage48.covid19.projecturban.pojo.
	 * UserPersonalDetails)
	 */
	@Override
	public UserPersonalDetails saveUserPersonalDetails(UserPersonalDetails details) throws Exception {

		try {
			return userPersonalDeatilsDao.save(details);
		} catch (Exception e) {
			logger.error("Exception occurred while saving user personal details");
			throw new Exception("Error occurred during saving personal details");
		}

	}
	
	
	/* (non-Javadoc)
	 * @see com.garage48.covid19.projecturban.service.UserAppServices#fetchUserPersonalDetails(java.lang.String)
	 */
	@Override
	public UserPersonalDetails fetchUserPersonalDetails(String username) throws Exception {


		try {
			Optional<UserPersonalDetails> data = userPersonalDeatilsDao.findById(username);
			if (data.isPresent())
				return data.get();
			else
				throw new NotFoundException("User's personal details not found");
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception occurred while fetching user's personal details");
			throw new Exception("Error occurred during fetching personal details");
		}

	}
}
