package com.belajar.springboot.book;

import java.time.LocalDateTime;

import com.belajar.springboot.author.AuthorDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class BookDTOResponse {
    private Long id;
    private String name;
    private AuthorDTOResponse author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BookDTOResponse parse(Book book){
        return BookDTOResponse.builder().id(book.getId())
        .name(book.getName())
        .author(AuthorDTOResponse.parse(book.getAuthor()))
        .createdAt(book.getCreatedAt())
        .updatedAt(book.getUpdatedAt())
        .build();
    }
}
