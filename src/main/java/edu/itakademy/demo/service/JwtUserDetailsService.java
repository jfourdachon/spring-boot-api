package edu.itakademy.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import edu.itakademy.demo.entity.User;
import edu.itakademy.demo.repository.UserRepositoryInterface;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserRepositoryInterface userRepositoryInterface;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepositoryInterface.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserDetails save(User user) {
		user.setUsername(user.getUsername());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		this.userRepositoryInterface.save(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
}