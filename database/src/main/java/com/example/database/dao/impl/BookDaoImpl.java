package com.example.database.dao.impl;

import com.example.database.dao.BookDao;
import com.example.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, author_id, title) VALUES (?, ?, ?)",
                book.getIsbn(), book.getAuthor_id(), book.getTitle());
    }

    @Override
    public Optional<Book> find(String isbn) {
        List<Book> result = jdbcTemplate.query(
                "SELECT * FROM books WHERE isbn = ? LIMIT 1",
                new BookDaoImpl.BookRowMapper(),
                isbn
        );
        return result.stream().findFirst();

    }

    public static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .title(rs.getString("title"))
                    .author_id(rs.getLong("author_id"))
                    .isbn(rs.getString("isbn"))
                    .build();
        }
    }
}
