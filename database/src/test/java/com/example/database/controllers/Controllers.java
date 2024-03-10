package com.example.database.controllers;

import com.example.database.TestDataUtil;
import com.example.database.domain.entities.Author;
import com.example.database.domain.entities.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class Controllers {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public Controllers(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreateAuthorSuccessfullyReturns201Created() throws Exception{
        Author authorTest = TestDataUtil.createAuthorTest();
        authorTest.setId(null);
        String authorJson = objectMapper.writeValueAsString(authorTest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateAuthorSuccessfullyReturnsCreatedAuthor() throws Exception{
        Author authorTest = TestDataUtil.createAuthorTest();
        authorTest.setId(null);
        String authorJson = objectMapper.writeValueAsString(authorTest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("XYZ")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value(30)
        );
    }

    @Test
    public void testThatCreateBookSuccessfullyReturns201Created() throws Exception{
        Author authorTest = TestDataUtil.createAuthorTest();
        Book bookTest = TestDataUtil.createBookTest(authorTest);
        String bookJson = objectMapper.writeValueAsString(bookTest);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }
}
