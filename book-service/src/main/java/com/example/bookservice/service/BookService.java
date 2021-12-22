package com.example.bookservice.service;

import com.example.bookservice.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();
    public Book getBookById(Long id);
    public Book saveBook(Book student);
    public Book updateBook(Book student);
    public String deleteBookById(Long id);
}
