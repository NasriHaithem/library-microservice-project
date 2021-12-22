package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books/")
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @PostMapping
    public Book  addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    @PutMapping
    public Book  updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
    @DeleteMapping("{id}")
    public String  deleteBook(@PathVariable Long id) {
        return bookService.deleteBookById(id);
    }
}
