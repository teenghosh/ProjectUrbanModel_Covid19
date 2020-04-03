package com.garage48.covid19.projecturban.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage48.covid19.projecturban.pojo.UserEntity;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserEntity,Long>{
	UserEntity findByUsername(String username);
	

}
