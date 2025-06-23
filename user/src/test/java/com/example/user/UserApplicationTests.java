package com.example.user;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@SpringBootTest
//import reactor.core.publisher.Mono;

class UserApplicationTests {

	@Test
	void contextLoads() {

		Mono<String> clientRes= WebClient.builder()
				.baseUrl("http://localhost:8082")
				.build()
				.get()
				.uri("/api/v1/user")
				.retrieve()
				.bodyToMono(String.class);
						//.map(res->"Userinfo:"+res);

		System.out.println("hi : "+clientRes.subscribe(System.out::println));



	}

}
