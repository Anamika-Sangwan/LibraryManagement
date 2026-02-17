package com.anamika.librarymanagement.Service;

import com.anamika.librarymanagement.DataStore.BookStore;
import com.anamika.librarymanagement.Exceptions.BookAlreadyBorrowedException;
import com.anamika.librarymanagement.Exceptions.BookNotFoundException;
import com.anamika.librarymanagement.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService{

    private final BookStore store;
    public BookService(BookStore store){
        this.store = store;
    }
    //Add a book to the database
    public Book addBook(Book book){
        book.setBorrowed(false);
        return store.save(book);
    }

    //Get all the books
    public List<Book> getBooks(){
        return store.findAll();
    }

    //Get book by id
    public Book getBook(int id){
        return store.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    //Borrow a book
    public Book borrowBook(int id){
        Book book = store.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));;
        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException("Book is already borrowed");
        }
        book.setBorrowed(true);
        store.update(book);
        return book;
    }


}