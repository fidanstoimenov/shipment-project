package com.example.demo.shipping.repository;

import com.example.demo.shipping.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query(value = "SELECT s FROM Shipment s inner join s.postman p where p.id = :id")
    List<Shipment> retrieveShipmentsByPostmanId(Long id);

}
