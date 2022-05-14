package com.example.demo.shipping.dto.mapper;

import com.example.demo.shipping.dto.RegisterRequestDTO;
import com.example.demo.shipping.entity.Postman;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostmanMapper {

    PostmanMapper INSTANCE = Mappers.getMapper(PostmanMapper.class);

    Postman toEntity(RegisterRequestDTO registerRequestDTO);
}
