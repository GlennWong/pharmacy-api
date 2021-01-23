package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
// TODO: fixit
//    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok().body(savedUser);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return ResponseEntity.ok().body(updatedUser);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}

