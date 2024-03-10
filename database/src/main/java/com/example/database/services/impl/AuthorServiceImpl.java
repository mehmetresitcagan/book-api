package com.example.database.services.impl;

import com.example.database.domain.entities.Author;
import com.example.database.repositories.AuthorRepository;
import com.example.database.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {


    private AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author createAuthor(Author author) {
        return repository.save(author);
    }
}
