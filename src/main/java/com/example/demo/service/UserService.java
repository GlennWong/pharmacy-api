package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<?> findAll();

    User findById(int id);

    User save(User user);

    User update(User user);

    void delete(int id);
}
