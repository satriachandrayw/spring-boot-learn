package com.belajar.springboot.author;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDTORequest {
    private String name;
}
