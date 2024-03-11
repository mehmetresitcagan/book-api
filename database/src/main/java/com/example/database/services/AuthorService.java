package com.example.database.services;

import com.example.database.domain.entities.Author;

import java.util.List;


public interface AuthorService {
    Author createAuthor(Author author);

    List<Author> findAll();

}
