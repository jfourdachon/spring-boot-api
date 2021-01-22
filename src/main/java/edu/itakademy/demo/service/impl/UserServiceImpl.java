package edu.itakademy.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.itakademy.demo.entity.User;
import edu.itakademy.demo.entity.dto.UserDTO;
import edu.itakademy.demo.repository.UserRepositoryInterface;
import edu.itakademy.demo.service.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	UserRepositoryInterface userRepositoryInterface;
	

	@Override
	public List<User> getAllUsers() {
		return (List<User>) this.userRepositoryInterface.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return this.userRepositoryInterface.findById(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
			);
	}

	@Override
	public void createUser(User user) {
		this.userRepositoryInterface.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		this.userRepositoryInterface.deleteById(id);
	}

	@Override
	public User updateUser(Integer id, UserDTO userDTO) {
		
		User user = mapToEntity(userDTO, this.getUserById(id));
		return this.userRepositoryInterface.save(user);
	}
	
	private User mapToEntity(UserDTO userDTO, User user) {
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		return user;
	}


}
