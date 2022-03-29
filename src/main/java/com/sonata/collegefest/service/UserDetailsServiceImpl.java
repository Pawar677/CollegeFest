package com.sonata.collegefest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.sonata.collegefest.entity.User;
import com.sonata.collegefest.repository.UserRepository;
import com.sonata.collegefest.security.MyUserDetails;

// This will be used by spring security to get the details of the users who is trying to 
// login to application. So that we need to write a method in such a way spring security expect.

public class UserDetailsServiceImpl implements UserDetailsService {
// To Inject User details we use
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   User user = userRepository.getUserByUsername(username);
		  
		 if (user == null ) {
			 throw new UsernameNotFoundException("Could not found user");
		 }
		 
		 return new MyUserDetails(user); 
	}

}
