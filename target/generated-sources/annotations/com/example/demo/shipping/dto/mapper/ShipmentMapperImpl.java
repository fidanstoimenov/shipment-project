package com.example.demo.shipping.dto.mapper;

import com.example.demo.shipping.dto.ShipmentDTO;
import com.example.demo.shipping.entity.Address;
import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.entity.Sender;
import com.example.demo.shipping.entity.Shipment;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-13T15:32:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class ShipmentMapperImpl implements ShipmentMapper {

    private final TagMapper tagMapper = Mappers.getMapper( TagMapper.class );

    @Override
    public Shipment toEntity(ShipmentDTO dto, Long postmanId, Long senderId) {
        if ( dto == null && postmanId == null && senderId == null ) {
            return null;
        }

        Shipment shipment = new Shipment();

        if ( dto != null ) {
            shipment.setAddress( shipmentDTOToAddress( dto ) );
            shipment.setTagList( tagMapper.toEntity( dto.getTags() ) );
        }
        if ( postmanId != null ) {
            shipment.setPostman( longToPostman( postmanId ) );
        }
        if ( senderId != null ) {
            shipment.setSender( longToSender( senderId ) );
        }

        afterMapping( shipment );

        return shipment;
    }

    protected Address shipmentDTOToAddress(ShipmentDTO shipmentDTO) {
        if ( shipmentDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setCity( shipmentDTO.getCity() );
        address.setAddress( shipmentDTO.getAddress() );

        return address;
    }

    protected Postman longToPostman(Long long1) {
        if ( long1 == null ) {
            return null;
        }

        Postman postman = new Postman();

        postman.setId( long1 );

        return postman;
    }

    protected Sender longToSender(Long long1) {
        if ( long1 == null ) {
            return null;
        }

        Sender sender = new Sender();

        sender.setId( long1 );

        return sender;
    }
}
