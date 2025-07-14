package org.example;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class Service {


    Mono<String> getDetails() {
        Mono< String> clientRes = WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build()
                .get()
                .uri("/api/v1/user")
                .retrieve()
                .bodyToMono(String.class);

        return  clientRes;
        //.map(res->"Userinfo:"+res);

        //	System.out.println("hi : "+clientRes.subscribe(System.out::println));


    }
}
