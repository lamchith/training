package com.example.user.controller;


import com.example.user.model.Books.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
//@NoArgsConstructor
@AllArgsConstructor
@RequestMapping(path="/api/v1/", produces={MediaType.APPLICATION_JSON_VALUE})
public class PutPostController {

    @PatchMapping("books")
    ResponseEntity<Book> patchBooks(@RequestBody Map<String,Object> book){

        Book bookModel=new Book();
        bookModel.setName((String) book.get("name"));
        bookModel.setId((Integer) book.get("id"));

        return ResponseEntity.of(Optional.of(bookModel));
    }



}
