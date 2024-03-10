package com.example.database;

import com.example.database.domain.dto.AuthorDto;
import com.example.database.domain.dto.BookDto;
import com.example.database.domain.entities.Author;
import com.example.database.domain.entities.Book;

public class TestDataUtil {
    private TestDataUtil() {

    }

    public static Author createAuthorTest() {
        return Author.builder()
                .id(1L)
                .name("XYZ")
                .age(30)
                .build();
    }

    public static Author createAuthorTestA() {
        return Author.builder()
                .id(2L)
                .name("MRc")
                .age(24)
                .build();
    }

    public static Author createAuthorTestB() {
        return Author.builder()
                .id(3L)
                .name("ABC")
                .age(45)
                .build();
    }

    public static Book createBookTest(final Author author) {
        return Book.builder()
                .isbn("abc")
                .author(author)
                .title("doe")
                .build();
    }

    public static Book createBookTestA(final Author author) {
        return Book.builder()
                .isbn("xyz")
                .author(author)
                .title("deneme")
                .build();
    }

    public static Book createBookTestB(final Author author) {
        return Book.builder()
                .isbn("qwe")
                .author(author)
                .title("deneme2")
                .build();
    }

    public static BookDto createBookDtoTest(final AuthorDto author) {
        return BookDto.builder()
                .isbn("abc")
                .author(author)
                .title("doe")
                .build();
    }

}
