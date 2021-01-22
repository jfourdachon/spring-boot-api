package edu.itakademy.demo.service;

import java.util.List;

import edu.itakademy.demo.entity.Author;
import edu.itakademy.demo.entity.dto.AuthorDTO;

public interface AuthorServiceInterface {
	
	Author getAuthor(Integer id);
	
	List<Author> getAllAuthors();
	
	void createAuthor(Author author);
	
	void deleteAuthor(Integer id);
	
	Author updateAuthor(Integer id, AuthorDTO authorDTO);
	
}
