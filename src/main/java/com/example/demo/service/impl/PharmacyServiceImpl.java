package com.example.demo.service.impl;

import com.example.demo.model.Pharmacy;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyRepository repository;

    @Override
    public List<Pharmacy> findAll() {
        return repository.findAll();
    }

    @Override
    public Pharmacy findById(int id) {
        return repository.findById(id).orElse(new Pharmacy());
    }

    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        return repository.save(pharmacy);
    }

    @Override
    public Pharmacy update(Pharmacy pharmacy) {
        return repository.save(pharmacy);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(pharmacy -> repository.delete(pharmacy));
    }
}
