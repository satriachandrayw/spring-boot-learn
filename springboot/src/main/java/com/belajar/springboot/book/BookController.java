package com.belajar.springboot.book;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<BookDTOResponse> findAll() {
        List<Book> books = this.bookService.findAll();
        return books.stream().map(book -> book.convertToDTOResponse()).collect(Collectors.toList());
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BookDTOResponse create(@RequestBody BookDTORequest bookDTORequest) {
        Book book = this.bookService.create(new Book(bookDTORequest.getName()));
        return book.convertToDTOResponse();
    }
}
