package com.belajar.springboot.book;

import com.belajar.springboot.author.AuthorDTORequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTORequest {
    private String name;
    private AuthorDTORequest author;
}
