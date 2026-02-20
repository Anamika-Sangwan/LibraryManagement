package com.anamika.librarymanagement.Service;

import com.anamika.librarymanagement.Constants.CustomMessage;
import com.anamika.librarymanagement.Repo.BookRepository;
import com.anamika.librarymanagement.Exceptions.BookAlreadyBorrowedException;
import com.anamika.librarymanagement.Exceptions.BookNotFoundException;
import com.anamika.librarymanagement.Entity.Book;
import com.anamika.librarymanagement.dto.BookResponse;
import com.anamika.librarymanagement.dto.CreateBookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    private static final Logger LOG = LoggerFactory.getLogger(BookService.class);
    private final BookRepository store;
    public BookService(BookRepository store){
        this.store = store;
    }
    //Add a book to the database
    public BookResponse addBook(CreateBookRequest request){
        LOG.info(CustomMessage.INSIDE_METHOD,"addBook");
        Book book = new Book(request.getTitle(), request.getAuthor());
        book.setBorrowed(false);
        return toResponse(store.save(book));
    }

    //Get all the books
    public List<BookResponse> getAllBooks(){
        LOG.info(CustomMessage.INSIDE_METHOD,"getAllBooks");
        return store.findAll().stream().map(this::toResponse).toList();
    }

    //Get book by id
    public BookResponse getBook(int id){
        LOG.info(CustomMessage.INSIDE_METHOD,"getBook");
        Book book = store.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        return toResponse(book);
    }

    //Borrow a book
    public BookResponse borrowBook(int id){
        LOG.info(CustomMessage.INSIDE_METHOD,"borrowBook");
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
        LOG.info(CustomMessage.INSIDE_METHOD,"toResponse");
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setBorrowed(book.isBorrowed());
        return response;
    }

}