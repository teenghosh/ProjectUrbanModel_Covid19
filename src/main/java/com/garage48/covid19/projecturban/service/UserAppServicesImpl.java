package com.garage48.covid19.projecturban.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage48.covid19.projecturban.dao.UserAddressDao;
import com.garage48.covid19.projecturban.pojo.AddressEntity;

@Service
public class UserAppServicesImpl implements UserAppServices {

	private static final Log logger = LogFactory.getLog(UserDetailServiceImpl.class);
	@Autowired
	private UserAddressDao addressDao;
	
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

}
