package com.example.user.controller;

import com.example.user.entity.Book;
import com.example.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {




    private final StreamBridge streamBridge;

    private final UserService userService;


    private Map<String, Book> userMap= new HashMap<>();








    @GetMapping("/user")
    public String getUser(){

        //userMap.put("Arun",new User(1,"Arun"));
      //  return (List<User>) userMap.values().;

     //   List <User> listOfUser=new ArrayList<>();
     //   listOfUser.add(new User(40,"Lam"));
      //  log.debug("returning response");


        return "Hi User" ;






    }

    @GetMapping("/message/{id}")
    public void sentMessage(@PathVariable String id ){

     //   var accountsMsgDto = new AccountsMsgDto(account.getAccountNumber(), customer.getName(),
      //          customer.getEmail(), customer.getMobileNumber());
      //  log.info("Sending Communication request for the details: {}", accountsMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", "what is happening "+id);
        log.info("Is the Communication request successfully triggered ? : {}", result);

        //return Flux.fromIterable(listOfUser) ;






    }




}
