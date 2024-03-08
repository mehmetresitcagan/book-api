package com.example.database.dao;

import com.example.database.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String abc);
}
