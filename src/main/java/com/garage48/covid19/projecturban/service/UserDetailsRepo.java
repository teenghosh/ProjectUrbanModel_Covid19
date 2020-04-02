package com.garage48.covid19.projecturban.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage48.covid19.projecturban.pojo.UserEntity;

public interface UserDetailsRepo extends JpaRepository<UserEntity,Long>{
	UserEntity findByUsername(String username);
	

}
