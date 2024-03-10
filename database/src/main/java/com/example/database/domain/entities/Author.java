package com.example.database.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA tarafından kullanılabilsin diye entity anotasyonu ekleniyor.
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;

}
