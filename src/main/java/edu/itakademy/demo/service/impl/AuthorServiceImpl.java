package edu.itakademy.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.itakademy.demo.entity.Author;
import edu.itakademy.demo.entity.dto.AuthorDTO;
import edu.itakademy.demo.repository.AuthorRepositoryInterface;
import edu.itakademy.demo.service.AuthorServiceInterface;

@Service
public class AuthorServiceImpl implements AuthorServiceInterface {
	
	@Autowired
	AuthorRepositoryInterface authorRepositoryInterface;

	@Override
	public Author getAuthor(Integer id) {
		return this.authorRepositoryInterface.findById(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
			);
	}

	@Override
	public List<Author> getAllAuthors() {
		return this.authorRepositoryInterface.findAll();
	}

	@Override
	public void createAuthor(Author author) {
		this.authorRepositoryInterface.save(author);
		
	}

	@Override
	public void deleteAuthor(Integer id) {
		this.authorRepositoryInterface.deleteById(id);
		
	}

	@Override
	public Author updateAuthor(Integer id, AuthorDTO authorDTO) {
		Author author = mapToEntity(authorDTO, this.getAuthor(id));
		return this.authorRepositoryInterface.save(author);
	}
	
	
	private Author mapToEntity(AuthorDTO authorDTO, Author author) {
		author.setFirstname(authorDTO.getFirstname());
		author.setLastname(authorDTO.getLastname());
		author.setBook_count(authorDTO.getBook_count());
		author.setNationality(authorDTO.getNationality());
		return author;
	}

}
