package com.belajar.springboot.author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author")
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public static Author parse(AuthorDTORequest authorDTORequest) {
        return Author.builder().name(authorDTORequest.getName()).build();
    }
}
