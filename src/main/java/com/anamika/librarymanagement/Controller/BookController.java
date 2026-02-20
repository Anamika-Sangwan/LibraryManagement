package com.anamika.librarymanagement.Controller;

import com.anamika.librarymanagement.Constants.CustomMessage;
import com.anamika.librarymanagement.Service.BookService;
import com.anamika.librarymanagement.dto.BookResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anamika.librarymanagement.dto.CreateBookRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   /*//Converts the entity into Dto
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
        //final Logger logger = LogFactory.getLogger(BookController.class);
        LOG.info(CustomMessage.INSIDE_METHOD,"addBook");
        BookResponse savedBook = bookService.addBook(request);
        LOG.debug(CustomMessage.INSIDE_METHOD,"ProcessesingRequest");
        return ResponseEntity.status(201).body(savedBook);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        LOG.info(CustomMessage.INSIDE_METHOD,"getALlBooks");
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable int id) {
        LOG.info(CustomMessage.INSIDE_METHOD,"getBook");
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PatchMapping("/{id}/borrow")
    public ResponseEntity<BookResponse> borrowBook(@PathVariable int id) {
        LOG.info(CustomMessage.INSIDE_METHOD,"borrowBook");
        return ResponseEntity.ok(bookService.borrowBook(id));
    }
}
