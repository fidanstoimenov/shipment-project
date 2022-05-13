package com.example.demo.shipping.entity;

import com.example.demo.shipping.enums.TagName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME")
    private TagName name;

    @Override
    public String toString() {
        return name.name();
    }
}
