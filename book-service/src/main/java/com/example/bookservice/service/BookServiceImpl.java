package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book newBook) {

        if(bookRepository.findById(newBook.getId()).isPresent())
        {
            return bookRepository.save(newBook);
        }
        return null;
    }

    @Override
    public String deleteBookById(Long id) {
        if(bookRepository.findById(id).isPresent())
        {
            bookRepository.deleteById(id);
            return "Successfully deleted";
        }
        return "No book with the provided ID";
    }
}
