package com.example.database.dao.impl;

import com.example.database.TestDataUtil;
import com.example.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createBookTest();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, author_id, title) VALUES (?, ?, ?)"),
                eq("abc"), eq(1L), eq("doe")
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        underTest.findOne("abc");
        verify(jdbcTemplate).query(
                eq("SELECT * FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("abc"));
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql() {
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT * FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql() {
        Book book = TestDataUtil.createBookTest();
        underTest.update("abc", book);

        verify(jdbcTemplate)
                .update(
                        "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                        "abc", "doe", 1L, "abc"
                );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        Book book = TestDataUtil.createBookTest();
        underTest.delete("abc");

        verify(jdbcTemplate).update(
                "DELETE FROM books WHERE isbn = ?", "abc"
        );
    }


}
