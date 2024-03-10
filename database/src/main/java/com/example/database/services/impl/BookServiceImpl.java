package com.example.database.services.impl;

import com.example.database.domain.entities.Book;
import com.example.database.repositories.BookRepository;
import com.example.database.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }
}
