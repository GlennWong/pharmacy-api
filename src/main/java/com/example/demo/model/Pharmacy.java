package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pharmacy")
public class Pharmacy implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;

}
