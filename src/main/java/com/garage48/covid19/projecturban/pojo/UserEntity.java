package com.garage48.covid19.projecturban.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity{


	
	/*public UserEntity() {
		
	}
	public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}*/

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String role;
	
	private String password;
	private  String username;
	//private final Set<GrantedAuthority> authorities;
	private  boolean accountNonExpired;
	private  boolean accountNonLocked;
	private  boolean credentialsNonExpired;
	private  boolean enabled;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5875448271477193022L;

	

}
