package com.example.demo.repository;

import com.example.demo.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

    Pharmacy findByName(String name);

    List<Pharmacy> findByNameLike(String name);

}
