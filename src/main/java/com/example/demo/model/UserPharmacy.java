package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class UserPharmacy implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="user_id")
    private User user;

    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="pharmacy_id")
    private Pharmacy pharmacy;

    private int total;
}
