package com.example.demo.shipping.dto.mapper;

import com.example.demo.shipping.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    Tag toEntity(Long id);

    List<Tag> toEntity(List<Long> id);
}
