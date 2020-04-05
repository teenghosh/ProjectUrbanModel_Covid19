package com.garage48.covid19.projecturban.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage48.covid19.projecturban.pojo.UserPersonalDetails;

@Repository
public interface PersonalDetailsDao extends JpaRepository<UserPersonalDetails, String> {

}
