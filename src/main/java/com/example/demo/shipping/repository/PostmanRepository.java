package com.example.demo.shipping.repository;

import com.example.demo.shipping.entity.Postman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostmanRepository extends JpaRepository<Postman, Long> {

    Optional<Postman> findPostmanById(Long id);

    List<Postman> findAll();

}
