package com.example.database.services.impl;

import com.example.database.domain.entities.Book;
import com.example.database.repositories.BookRepository;
import com.example.database.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book, String isbn) {
        book.setIsbn(isbn);
        return repository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return repository.findById(isbn);
    }
}
