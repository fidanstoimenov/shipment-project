package com.example.demo.shipping.dto.mapper;

import com.example.demo.shipping.dto.ShipmentRequestDTO;
import com.example.demo.shipping.entity.Shipment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TagMapper.class)
public interface ShipmentMapper {

    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    @Mappings({
            @Mapping(target = "address.city",       source = "dto.city"),
            @Mapping(target = "address.address",    source = "dto.address"),
            @Mapping(target = "tagList",            source = "dto.tags"),
            @Mapping(target = "postman.id",         source = "postmanId"),
            @Mapping(target = "sender.id",          source = "senderId")
    })
    Shipment toEntity(ShipmentRequestDTO dto, Long postmanId, Long senderId);

    @AfterMapping
    default void afterMapping(@MappingTarget Shipment shipment) {
        shipment.getAddress().setShipment(shipment);
    }

}
