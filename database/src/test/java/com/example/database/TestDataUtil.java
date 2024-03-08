package com.example.database;

import com.example.database.domain.Author;
import com.example.database.domain.Book;

public class TestDataUtil {
    private TestDataUtil() {

    }

    public static Author createAuthorTest() {
        return Author.builder()
                .id(1L)
                .name("MRÇ")
                .age(80)
                .build();
    }


    public static Book createBookTest() {
        return Book.builder()
                .isbn("abc")
                .author_id(1L)
                .title("doe")
                .build();
    }
}
