package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@RestController
@RequestMapping("/")
public class Main {

    @Autowired
    private final Service servive;

    public Main(Service servive) {
        this.servive = servive;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }

   // following is demonstrating the web client t other service
   // the subscribe happens automatically from spring boot controller

    @GetMapping("user")
    public Mono<String> getUser(){
        System.out.println("call herere");
        return servive.getDetails();
    }

    @Bean
    public RouteLocator routeLoca(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/eazybank/**")
                        .filters( f -> f.rewritePath("/eazybank/accounts/user","/api/v1/user"))

                                .uri("http://localhost:8082")).build();

    }
}