package com.example.user.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity

public class Book {


    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
