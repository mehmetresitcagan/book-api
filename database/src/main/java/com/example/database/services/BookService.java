package com.example.database.services;

import com.example.database.domain.entities.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book, String isbn);

    List<Book> findAll();
}
