package com.example.database.services;

import com.example.database.domain.entities.Book;

public interface BookService {

    Book createBook(Book book, String isbn);
}
