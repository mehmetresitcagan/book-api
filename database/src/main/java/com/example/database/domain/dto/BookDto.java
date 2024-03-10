package com.example.database.domain.dto;

import com.example.database.domain.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String title ;

    private String isbn;

    private Author author;
}
