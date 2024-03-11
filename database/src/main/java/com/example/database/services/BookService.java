package com.example.database.services;

import com.example.database.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book createBook(Book book, String isbn);

    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);
}
