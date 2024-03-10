package com.example.database.repository;

import com.example.database.TestDataUtil;
import com.example.database.domain.entities.Author;
import com.example.database.domain.entities.Book;
import com.example.database.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTest {

    private BookRepository underTest;


    @Autowired
    public BookRepositoryIntegrationTest(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createAuthorTest();
        Book book = TestDataUtil.createBookTest(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createAuthorTest();

        Book book = TestDataUtil.createBookTest(author);
        underTest.save(book);

        Book bookA = TestDataUtil.createBookTestA(author);
        underTest.save(bookA);

        Book bookB = TestDataUtil.createBookTestB(author);
        underTest.save(bookB);

        Iterable<Book> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(book, bookA, bookB);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createAuthorTest();

        Book book = TestDataUtil.createBookTest(author);
        underTest.save(book);

        book.setTitle("UPDATED");
        underTest.save(book);

        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createAuthorTest();

        Book book = TestDataUtil.createBookTest(author);
        underTest.save(book);

        underTest.deleteById(book.getIsbn());

        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isEmpty();

    }
}
