package com.garage48.covid19.projecturban.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.garage48.covid19.projecturban.pojo.UserEntity;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private static final Log logger = LogFactory.getLog(UserDetailServiceImpl.class);
	@Autowired
	private UserDetailsRepo repo;

	@Override
	public UserDetailsBeanImpl loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = repo.findByUsername(username);
		if (user == null) {
			logger.error("Exception occurred while fetching usernsame");
			throw new UsernameNotFoundException(username);
		}
		if(logger.isDebugEnabled()){
			logger.debug("UserName successfully retrieved from DB");
		}
		return new UserDetailsBeanImpl(user);
	}

	
	public UserDetailsBeanImpl saveUserCredentials(UserEntity user) throws Exception {

		try {
			return new UserDetailsBeanImpl(repo.save(user));
		}
		catch (Exception e) {
			logger.error("Exception occurred while fetching usernsame");
			throw new Exception("Error occurred during saving user credentials");
		}

	}
}	
