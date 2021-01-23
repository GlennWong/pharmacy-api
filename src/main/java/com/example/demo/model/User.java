package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_pharmacy",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "pharmacy_id")}
    )
    public List<Pharmacy> pharmacies;
}

