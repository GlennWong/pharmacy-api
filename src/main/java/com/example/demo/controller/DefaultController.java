package com.example.demo.controller;

import com.example.demo.api.github.Github;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class DefaultController {

    @Autowired
    Github github;

    @GetMapping("/")
    public String index(Authentication authentication) {
        if (authentication instanceof Authentication) {
//            return "你好：" + authentication.getName();
            return "你好：" + github.getProfile();
        }

         return  "<a href=\"/oauth2/authorization/github\">Login with github</a>";
    }

    @GetMapping("/database")
    public ResponseEntity<Void> databaseUrl() {
        return ResponseEntity.status(HttpStatus.FOUND)
            .location(URI.create("h2-console"))
            .build();

    }

}
