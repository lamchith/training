package com.example.user.message.function;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Component
public class MessageSupplier {

    //Supplier
    // Function can not take dynamic messages
    // function can be used to send take input from a kafka topica to another

    @Bean
    public Function<String ,Message<String>> produceMessage(){

        return (msg)->{

            String hi="Hi from Lamchith";
           return MessageBuilder.withPayload(msg)
                    .setHeader(KafkaHeaders.KEY,"test-key")
                    .build();
        };
    }


}
