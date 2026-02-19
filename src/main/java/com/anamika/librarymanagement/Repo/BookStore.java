package com.anamika.librarymanagement.Repo;

import com.anamika.librarymanagement.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

/**@Repository
public class BookStore {

    private final Map<Integer, Book> books = new HashMap<>();
    private int currentId = 1;

    // Save a new book
    public Book save(Book book) {
        book.setId(currentId++);
        books.put(book.getId(), book);
        return book;
    }

    // Find book by ID
    public Optional<Book> findById(int id) {

        return Optional.ofNullable(books.get(id));
    }

    // Return all books
    public List<Book> findAll() {

        return new ArrayList<>(books.values());
    }

    // Update an existing book
    public void update(Book book) {

        books.put(book.getId(), book);
    }
}
**/