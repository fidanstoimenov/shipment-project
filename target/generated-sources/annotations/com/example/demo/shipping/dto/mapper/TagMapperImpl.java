package com.example.demo.shipping.dto.mapper;

import com.example.demo.shipping.entity.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-13T15:32:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toEntity(Long id) {
        if ( id == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( id );

        return tag;
    }

    @Override
    public List<Tag> toEntity(List<Long> id) {
        if ( id == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( id.size() );
        for ( Long long1 : id ) {
            list.add( toEntity( long1 ) );
        }

        return list;
    }
}
