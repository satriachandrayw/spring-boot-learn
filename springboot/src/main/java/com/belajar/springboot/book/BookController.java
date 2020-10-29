package com.belajar.springboot.book;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    @ResponseBody
    public List<BookDTOResponse> findAll() {
        List<Book> books = this.bookService.findAll();

        return books.stream().map(
                book -> new BookDTOResponse(book.getId(), book.getName(), book.getCreatedAt(), book.getUpdatedAt()))
                .collect(Collectors.toList());
    }

}
