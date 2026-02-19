package com.anamika.librarymanagement.Repo;

import com.anamika.librarymanagement.Model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}