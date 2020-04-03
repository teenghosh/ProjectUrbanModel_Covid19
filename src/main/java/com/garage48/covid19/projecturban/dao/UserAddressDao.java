package com.garage48.covid19.projecturban.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage48.covid19.projecturban.pojo.AddressEntity;

@Repository
public interface UserAddressDao extends JpaRepository<AddressEntity, String> {

}
