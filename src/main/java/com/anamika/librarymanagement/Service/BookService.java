package com.anamika.librarymanagement.Service;

import com.anamika.librarymanagement.Repo.BookRepository;
import com.anamika.librarymanagement.Exceptions.BookAlreadyBorrowedException;
import com.anamika.librarymanagement.Exceptions.BookNotFoundException;
import com.anamika.librarymanagement.Model.Book;
import com.anamika.librarymanagement.dto.BookResponse;
import com.anamika.librarymanagement.dto.CreateBookRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{

    private final BookRepository store;
    public BookService(BookRepository store){
        this.store = store;
    }
    //Add a book to the database
    public BookResponse addBook(CreateBookRequest request){
        Book book = new Book(request.getTitle(), request.getAuthor());
        book.setBorrowed(false);
        return toResponse(store.save(book));
    }

    //Get all the books
    public List<BookResponse> getAllBooks(){
        return store.findAll().stream().map(this::toResponse).toList();
    }

    //Get book by id
    public BookResponse getBook(int id){
        Book book = store.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        return toResponse(book);
    }

    //Borrow a book
    public BookResponse borrowBook(int id){
        Book book = store.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));;
        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException("Book is already borrowed");
        }
        book.setBorrowed(true);
        store.save(book);
        return toResponse(book);
    }

    //Handle DTO object
    private BookResponse toResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setBorrowed(book.isBorrowed());
        return response;
    }

}