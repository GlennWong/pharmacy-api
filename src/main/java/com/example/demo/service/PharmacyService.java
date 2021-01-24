package com.example.demo.service;

import com.example.demo.model.Pharmacy;

import java.util.List;

public interface PharmacyService {

    List<?> findAll();

    Pharmacy findById(int id);

    Pharmacy save(Pharmacy pharmacy);

    Pharmacy update(Pharmacy pharmacy);

    void delete(int id);
}
