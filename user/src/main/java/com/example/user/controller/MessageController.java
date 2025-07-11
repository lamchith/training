package com.example.user.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

  //  private final MessageSupplier supplier;

    private final StreamBridge streamBridge;

    @PostMapping("/{message}")
    public ResponseEntity<String> postMessage(@PathVariable String message){
        log.info("Post call for api/v1/messages/{messageId}{}", message);

        // doing like this will not work
        //supplier.produceMessage();

        return ResponseEntity.ok("Sent message to kafka: "+message);
    }

    // to send Dynamic messages , needs to use stream bride
    // Supplier can not send dynamic messages, cant
    //take input from a function

    @GetMapping("/{id}")
    public void sentMessage(@PathVariable String id ){

        //   var accountsMsgDto = new AccountsMsgDto(account.getAccountNumber(), customer.getName(),
        //          customer.getEmail(), customer.getMobileNumber());
        //  log.info("Sending Communication request for the details: {}", accountsMsgDto);

        Message<String> message= MessageBuilder.withPayload("what is happening "+id)
                .setHeader(KafkaHeaders.KEY,"myKey").build();
        var result = streamBridge.send("produceMessage-out-0",message );
        log.info("Is the Communication request successfully triggered ? : {}", result);

        //return Flux.fromIterable(listOfUser) ;






    }




}
