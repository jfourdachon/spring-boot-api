package edu.itakademy.demo.service;

import java.util.List;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;

public interface BookServiceInterface {

		Book getBook(Integer id);
		
		List<Book> getBooks();
		
		List<Book> getBooksWhereNameIs(String name);
		
		void deleteBook(Integer id);
		
		void createBook(Book book);
		
		Book updateBook(Integer id, BookDTO bookDTO);
		
		List<Book> getAllBookWithoutDescription();
		
}
