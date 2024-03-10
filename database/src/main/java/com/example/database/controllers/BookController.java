package com.example.database.controllers;

import com.example.database.domain.dto.BookDto;
import com.example.database.domain.entities.Book;
import com.example.database.mappers.Mapper;
import com.example.database.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    private BookService service;
    private Mapper<Book, BookDto> bookMapper;


    public BookController(BookService service, Mapper<Book, BookDto> bookMapper) {
        this.service = service;
        this.bookMapper = bookMapper;
    }

    @PostMapping(path = "/books")
    public ResponseEntity<BookDto> createBook(BookDto bookDto){
        Book bookEntity = bookMapper.mapFrom(bookDto);
        Book savedBook = service.createBook(bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBook), HttpStatus.CREATED);
    }

}
