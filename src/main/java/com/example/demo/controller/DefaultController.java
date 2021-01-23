package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class DefaultController {

    @GetMapping("/database")
    public ResponseEntity<Void> databaseUrl() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("h2-console"))
                .build();

    }

}
