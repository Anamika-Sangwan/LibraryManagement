package com.anamika.librarymanagement.Controller;

import com.anamika.librarymanagement.Exceptions.BookNotFoundException;
import com.anamika.librarymanagement.Model.Book;
import com.anamika.librarymanagement.Service.BookService;
import com.anamika.librarymanagement.dto.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anamika.librarymanagement.dto.CreateBookRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Converts the entity into Dto
    private BookResponse toResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setBorrowed(book.isBorrowed());
        return response;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody CreateBookRequest request) {
        Book book = new Book(request.getTitle(),request.getAuthor());
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(201).body(toResponse(savedBook));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> response = bookService.getBooks().stream().map(this::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable int id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.ok(toResponse(book));
    }

    @PatchMapping("/{id}/borrow")
    public ResponseEntity<BookResponse> borrowBook(@PathVariable int id) {
        Book borrowedBook = bookService.borrowBook(id);
        return ResponseEntity.ok(toResponse(borrowedBook));
    }
}
