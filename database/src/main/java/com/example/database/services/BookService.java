package com.example.database.services;

import com.example.database.domain.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book save(Book book, String isbn);

    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Optional<Book> findByIsbn(String isbn);

    boolean isExists(String isbn);
}
