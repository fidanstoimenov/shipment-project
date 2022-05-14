package com.example.demo.shipping.dto.mapper;

import com.example.demo.shipping.dto.RegisterRequestDTO;
import com.example.demo.shipping.entity.Sender;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SenderMapper {

    SenderMapper INSTANCE = Mappers.getMapper(SenderMapper.class);

    Sender toEntity(RegisterRequestDTO registerRequestDTO);
}
