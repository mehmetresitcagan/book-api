package com.example.database.services;

import com.example.database.domain.entities.Author;

import java.util.List;
import java.util.Optional;


public interface AuthorService {
    Author createAuthor(Author author);

    List<Author> findAll();

    Optional<Author> findById(long id);

}
