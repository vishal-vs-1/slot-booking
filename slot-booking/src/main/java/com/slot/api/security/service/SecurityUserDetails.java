package com.slot.api.security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.slot.api.entity.UserEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityUserDetails implements UserDetails{

	private UserEntity user;
	
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()-> "write");
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
