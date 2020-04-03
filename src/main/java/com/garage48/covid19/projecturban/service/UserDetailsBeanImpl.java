package com.garage48.covid19.projecturban.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.garage48.covid19.projecturban.pojo.UserEntity;

import lombok.Getter;


public class UserDetailsBeanImpl implements UserDetails {

	private UserEntity user;
	
	
	private String role;
	
	private String name;

	public UserDetailsBeanImpl(UserEntity user) {
		this.user=user;
		this.name = user.getName();
		this.role =user.getRole();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8117857050284062722L;

	
	public String getRole(){
		return this.role;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getPassword() {
		
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return this.user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return this.user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return this.user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		
		return this.user.isEnabled();
	}

	

}
