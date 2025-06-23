package com.example.user.controller;

import com.example.user.entity.Book;
import com.example.user.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * Controller->Service-Repository
 *
 *
 */
@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService bookService;

    @PostMapping("/{id}")
    ResponseEntity<Book> createBook(@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        bookService.create(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> getBook(@PathVariable int id){

        Optional<Book>book=bookService.getBook(id);
        return ResponseEntity.of(book);
    }




}
