package com.example.user.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findByName(String name);
}

