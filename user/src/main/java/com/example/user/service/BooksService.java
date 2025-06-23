package com.example.user.service;

import com.example.user.entity.Book;
import com.example.user.respository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository bookRepository;


    @Transactional
    public void create(Book book){

        bookRepository.save(book);
    }


    public Optional<Book> getBook(int id){

        return bookRepository.findById(id);


    }
}
