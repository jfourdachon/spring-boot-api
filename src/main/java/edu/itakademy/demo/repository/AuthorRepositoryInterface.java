package edu.itakademy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itakademy.demo.entity.Author;

public interface AuthorRepositoryInterface  extends JpaRepository<Author, Integer>{
}

