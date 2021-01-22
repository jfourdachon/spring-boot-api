package edu.itakademy.demo.service;

import java.util.List;

import edu.itakademy.demo.entity.User;
import edu.itakademy.demo.entity.dto.UserDTO;

public interface UserServiceInterface {
	
	List<User> getAllUsers();
	
	User getUserById(Integer id);
	
	void createUser(User user);
	
	void deleteUser(Integer id);
	
	User updateUser(Integer id, UserDTO userDTO);

}
