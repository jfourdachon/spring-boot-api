package edu.itakademy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.itakademy.demo.entity.User;
import edu.itakademy.demo.entity.dto.UserDTO;
import edu.itakademy.demo.service.UserServiceInterface;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@GetMapping("/all-users")
	public List<User> getAllUsers() {
		List<User> users = this.userServiceInterface.getAllUsers();
		return users;
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return this.userServiceInterface.getUserById(id);
	}

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
    	this.userServiceInterface.deleteUser(id);
    }
    
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
    		User user = this.userServiceInterface.updateUser(id, userDTO);
    		return user;
    }
}
