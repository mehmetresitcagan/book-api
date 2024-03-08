package com.example.database;

import com.example.database.domain.Author;
import com.example.database.domain.Book;

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

    public static Book createBookTest() {
        return Book.builder()
                .isbn("abc")
                .author_id(1L)
                .title("doe")
                .build();
    }

    public static Book createBookTestA() {
        return Book.builder()
                .isbn("xyz")
                .author_id(1L)
                .title("deneme")
                .build();
    }

    public static Book createBookTestB() {
        return Book.builder()
                .isbn("qwe")
                .author_id(1L)
                .title("deneme2")
                .build();
    }

}
