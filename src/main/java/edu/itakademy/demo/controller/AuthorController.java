package edu.itakademy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.itakademy.demo.entity.Author;
import edu.itakademy.demo.entity.dto.AuthorDTO;
import edu.itakademy.demo.service.AuthorServiceInterface;

@RestController
@RequestMapping(value = "/api/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
	
	@Autowired
	private AuthorServiceInterface authorService;
	
	@GetMapping
	public List<Author> getAllAuthors() {
		List<Author> authors = authorService.getAllAuthors();
		return authors;
	}
	
    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Integer id) {
    	Author author = authorService.getAuthor(id);
    	return author;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
    	this.authorService.createAuthor(author);;
    	return author;
    }
    
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Integer id, @RequestBody AuthorDTO authorDTO) {
    		Author book = this.authorService.updateAuthor(id, authorDTO);
    		return book;
    }
}
