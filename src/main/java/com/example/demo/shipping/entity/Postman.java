package com.example.demo.shipping.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "POSTMAN")
public class Postman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postman", cascade = CascadeType.ALL)
    private List<Shipment> shipmentList;

    public String fullName() {
        return name + " " + surname;
    }

}
