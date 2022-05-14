package com.example.demo.shipping.dto.mapper;

import com.example.demo.security.User;
import com.example.demo.shipping.dto.RegisterRequestDTO;
import com.example.demo.shipping.dto.UpdatePasswordRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "username",   source = "dto.username"),
            @Mapping(target = "password",   source = "dto.password"),
            @Mapping(target = "role",       source = "dto.role"),
            @Mapping(target = "userId",     source = "userId")
    })
    User toEntity(RegisterRequestDTO dto, Long userId);

    UpdatePasswordRequestDTO toDTO(User user);
}
