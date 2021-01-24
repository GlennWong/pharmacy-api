package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "<a href='https://github.com/login/oauth/authorize?client_id=Iv1.335d9234a445e1eb'>Github Login</a>" +
            "<br>" +
            "<br>" +
            "<a href=\"/oauth2/authorization/github\">click here</a>";
    }


    @GetMapping("/database")
    public ResponseEntity<Void> databaseUrl() {
        return ResponseEntity.status(HttpStatus.FOUND)
            .location(URI.create("h2-console"))
            .build();

    }

}
