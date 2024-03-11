package com.example.database.services.impl;

import com.example.database.domain.entities.Author;
import com.example.database.repositories.AuthorRepository;
import com.example.database.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<Author> findAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Author> findById(long id) {
        return repository.findById(id);
    }


}
