package com.example.demo.shipping.service;

import com.example.demo.shipping.entity.Shipment;
import com.example.demo.shipping.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    @Transactional
    public void save(Shipment shipment) {
        shipmentRepository.save(shipment);
    }

    @Transactional(readOnly = true)
    public List<Shipment> retrieveShipmentsByPostmanId(Long id) {
        return shipmentRepository.retrieveShipmentsByPostmanId(id);
    }
}
