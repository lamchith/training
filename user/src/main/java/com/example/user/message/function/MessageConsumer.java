package com.example.user.message.function;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

@Bean
public Consumer<Message<String>> receiveMessage(){

    return message -> {

        String payload = message.getPayload();
        Object partition = message.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION);
        Object offset = message.getHeaders().get(KafkaHeaders.OFFSET);
        System.out.println("Received message: " + payload);
        System.out.println("Partition: " + partition + ", Offset: " + offset);
        // your processing logic
    };





    }
}
