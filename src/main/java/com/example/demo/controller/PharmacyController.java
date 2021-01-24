package com.example.demo.controller;

import com.example.demo.model.Pharmacy;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyService service;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Pharmacy pharmacy = service.findById(id);
        return ResponseEntity.ok().body(pharmacy);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pharmacy pharmacy) {
        Pharmacy savedPharmacy = service.save(pharmacy);
        return ResponseEntity.ok().body(savedPharmacy);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody Pharmacy pharmacy) {
        Pharmacy updatedPharmacy = service.update(pharmacy);
        return ResponseEntity.ok().body(updatedPharmacy);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}

