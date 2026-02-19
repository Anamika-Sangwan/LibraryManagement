package com.anamika.librarymanagement.Repo;

import com.anamika.librarymanagement.Entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}