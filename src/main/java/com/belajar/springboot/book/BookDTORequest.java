package com.belajar.springboot.book;

import com.belajar.springboot.author.AuthorDTORequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTORequest {
    private String name;
    private AuthorDTORequest author;
}
