package com.slot.api.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.slot.api.repo.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		var user = repo.findByEmail(username);
		
		return user.map(SecurityUserDetails::new)
				   .orElseThrow(()-> new UsernameNotFoundException("User is not registered"));
	}
}
