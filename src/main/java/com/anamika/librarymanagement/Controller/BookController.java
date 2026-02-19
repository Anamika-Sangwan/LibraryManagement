package com.anamika.librarymanagement.Controller;

import com.anamika.librarymanagement.Service.BookService;
import com.anamika.librarymanagement.dto.BookResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anamika.librarymanagement.dto.CreateBookRequest;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   /** //Converts the entity into Dto
    private BookResponse toResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setBorrowed(book.isBorrowed());
        return response;
    }*/

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody CreateBookRequest request) {
        BookResponse savedBook = bookService.addBook(request);
        return ResponseEntity.status(201).body(savedBook);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PatchMapping("/{id}/borrow")
    public ResponseEntity<BookResponse> borrowBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.borrowBook(id));
    }
}
