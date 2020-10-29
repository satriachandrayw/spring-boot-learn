package com.belajar.springboot.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class AuthorDTOResponse {
    private String name;

    public static AuthorDTOResponse parse(Author author) {
        return AuthorDTOResponse.builder()
        .name(author.getName())
        .build();
    }

}
