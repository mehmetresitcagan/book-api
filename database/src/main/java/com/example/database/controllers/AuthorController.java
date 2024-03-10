package com.example.database.controllers;

import com.example.database.domain.dto.AuthorDto;
import com.example.database.domain.entities.Author;
import com.example.database.mappers.Mapper;
import com.example.database.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    AuthorService authorService;
    private Mapper<Author, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<Author, AuthorDto> authorMapper){
        this.authorService= authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        Author author = authorMapper.mapFrom(authorDto);
        Author savedAuthorEntity = authorService.createAuthor(author);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

}
