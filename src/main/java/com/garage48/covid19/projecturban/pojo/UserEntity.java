package com.garage48.covid19.projecturban.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="authtable")
public class UserEntity{


	
	/*public UserEntity() {
		
	}
	public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}*/

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private long id;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
	private String password;
	@Column(name="username")
	private  String username;
	//private final Set<GrantedAuthority> authorities;
	@Column(name="accountNonExpired")
	private  boolean accountNonExpired;
	@Column(name="accountNonLocked")
	private  boolean accountNonLocked;
	@Column(name="credentialsNonExpired")
	private  boolean credentialsNonExpired;
	@Column(name="enabled")
	private  boolean enabled;
	@Column(name="name")
	private String name;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5875448271477193022L;

	

}
