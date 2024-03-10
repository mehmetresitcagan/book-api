package com.example.database.repository;

import com.example.database.TestDataUtil;
import com.example.database.domain.entities.Author;
import com.example.database.repositories.AuthorRepository;
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
// Her test execute edildikten sonra database i temizliyor. böylece önceki tesste oluşturulan objelerden dolayı fail olmuyor
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTest {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTest(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createAuthorTest();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createAuthorTest();
        underTest.save(author);
        Author authorA = TestDataUtil.createAuthorTestA();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createAuthorTestB();
        underTest.save(authorB);
        Iterable<Author> result = underTest.findAll();

        assertThat(result)
                .hasSize(3)
                .containsExactly(author, authorA, authorB);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author author = TestDataUtil.createAuthorTest();
        underTest.save(author);
        author.setName("UPDATED");
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        Author author = TestDataUtil.createAuthorTest();
        underTest.save(author);

        underTest.deleteById(author.getId());
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatAgeIsLessThan() {
        Author author = TestDataUtil.createAuthorTest();
        underTest.save(author);
        Author authorA = TestDataUtil.createAuthorTestA();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createAuthorTestB();
        underTest.save(authorB);

        Iterable<Author> result = underTest.ageLessThan(40);
        assertThat(result)
                .hasSize(2)
                .containsExactly(author, authorA);

    }

    @Test
    public void testThatAuthorsWhichAgesAreGreater() {
        Author author = TestDataUtil.createAuthorTest();
        underTest.save(author);
        Author authorA = TestDataUtil.createAuthorTestA();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createAuthorTestB();
        underTest.save(authorB);

        Iterable<Author> result = underTest.findAuthorsWithAgeGreater(40);
        assertThat(result)
                .hasSize(1)
                .containsExactly(authorB);
    }


}
