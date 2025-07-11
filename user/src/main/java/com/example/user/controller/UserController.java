package com.example.user.controller;

import com.example.user.entity.Book;
import com.example.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {






    private final UserService userService;


    private Map<String, Book> userMap= new HashMap<>();








    @GetMapping("/user")
    public String getUser(){

        log.debug("call to api/v1/user");

        //userMap.put("Arun",new User(1,"Arun"));
      //  return (List<User>) userMap.values().;

     //   List <User> listOfUser=new ArrayList<>();
     //   listOfUser.add(new User(40,"Lam"));
      //  log.debug("returning response");


        return "Hi User" ;






    }





}
