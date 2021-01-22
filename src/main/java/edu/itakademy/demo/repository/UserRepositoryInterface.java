package edu.itakademy.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.itakademy.demo.entity.User;

@Repository
public interface UserRepositoryInterface  extends CrudRepository<User, Integer>{

	User findByUsername(String username);
}
