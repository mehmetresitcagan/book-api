package com.example.database.dao.impl;

import com.example.database.TestDataUtil;
import com.example.database.dao.AuthorDao;
import com.example.database.domain.Author;
import com.example.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTest {

    private BookDaoImpl underTest;

    private AuthorDao authorDao;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createAuthorTest();
        authorDao.create(author);
        Book book = TestDataUtil.createBookTest();
        book.setAuthor_id(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createAuthorTest();
        authorDao.create(author);

        Book book = TestDataUtil.createBookTest();
        book.setAuthor_id(author.getId());
        underTest.create(book);

        Book bookA = TestDataUtil.createBookTestA();
        bookA.setAuthor_id(author.getId());
        underTest.create(bookA);

        Book bookB = TestDataUtil.createBookTestB();
        bookB.setAuthor_id(author.getId());
        underTest.create(bookB);

        List<Book> result = underTest.find();
        assertThat(result)
                .hasSize(3)
                .containsExactly(book, bookA, bookB);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createAuthorTest();
        authorDao.create(author);

        Book book = TestDataUtil.createBookTest();
        book.setAuthor_id(author.getId());
        underTest.create(book);

        book.setTitle("UPDATED");
        underTest.update(book.getIsbn(), book);

        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createAuthorTest();
        authorDao.create(author);

        Book book = TestDataUtil.createBookTest();
        book.setAuthor_id(author.getId());
        underTest.create(book);

        underTest.delete(book.getIsbn());

        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isEmpty();

    }
}
