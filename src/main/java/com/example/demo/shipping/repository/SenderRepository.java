package com.example.demo.shipping.repository;

import com.example.demo.shipping.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SenderRepository extends JpaRepository<Sender, Long> {

    Optional<Sender> findSenderById(Long id);

}
