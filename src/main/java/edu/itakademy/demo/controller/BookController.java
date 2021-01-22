package edu.itakademy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.service.BookServiceInterface;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	
	@Autowired
	private BookServiceInterface bookService;

	@GetMapping
	public List<Book> getBooks() {
		List<Book> books = bookService.getBooks();
		return books;
	}
	
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
    	Book book = bookService.getBook(id);
    	return book;
    }
    
    @GetMapping("/search/{name}")
    public List<Book> getBooksWHereNameIs(@PathVariable String name) {
    	List<Book> books = bookService.getBooksWhereNameIs(name);
    	return books;
    }
    
    @GetMapping("/no-description")
    public List<Book> getBooksWithoutDescription() {
    	List<Book> books = bookService.getAllBookWithoutDescription();
    	return books;
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
    	bookService.deleteBook(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
    	this.bookService.createBook(book);
    	return book;
    }
    
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
    		Book book = this.bookService.updateBook(id, bookDTO);
    		return book;
    }
	
}