package com.belajar.springboot.author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    public static Author parse(AuthorDTORequest authorDTORequest) {
        return Author.builder().name(authorDTORequest.getName()).build();
    }
}
