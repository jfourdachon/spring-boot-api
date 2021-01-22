package edu.itakademy.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import edu.itakademy.demo.service.BookServiceInterface;

@Service
public class BookServiceImpl implements BookServiceInterface {
	
	@Autowired
	private BookRepositoryInterface bookRepositoryInterface;
	
	@Override
	public Book getBook(Integer id) {
		
		return this.bookRepositoryInterface.findById(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
			);
	}
	
	@Override
	public List<Book> getBooksWhereNameIs(String name) {
		return this.bookRepositoryInterface.findallBooksWhereNameIs(name);
	}
	
	@Override
	public List<Book> getAllBookWithoutDescription() {
		return this.bookRepositoryInterface.findByDescriptionIsNull();
	}

	@Override
	public List<Book> getBooks() {
//		return this.bookRepositoryInterface.getAllBooks();
		return this.bookRepositoryInterface.findAll();
	}

	@Override
	public void deleteBook(Integer id) {
//		Book book = this.bookRepositoryInterface.getBookById(id);
		this.bookRepositoryInterface.deleteById(id);
	}

	@Override
	public void createBook(Book book) {
		this.bookRepositoryInterface.save(book);
	}

	@Override
	public Book updateBook(Integer id, BookDTO bookDTO) {
		
		Book book = mapToEntity(bookDTO, this.getBook(id));
		return this.bookRepositoryInterface.save(book);
	}
	
	private Book mapToEntity(BookDTO bookDTO, Book book) {
		book.setName(bookDTO.getName());
		book.setDescription(bookDTO.getDescription());
		return book;
	}
}
