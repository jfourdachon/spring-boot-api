package edu.itakademy.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.itakademy.demo.entity.Book;

public interface BookRepositoryInterface extends JpaRepository<Book, Integer>{
	
	@Query("SELECT u FROM Book u WHERE u.name = ?1")
	List<Book> findallBooksWhereNameIs(String name);
	
	List<Book> findByDescriptionIsNull();

}
