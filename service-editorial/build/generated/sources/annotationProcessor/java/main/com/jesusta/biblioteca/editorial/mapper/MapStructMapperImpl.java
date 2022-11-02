package com.jesusta.biblioteca.editorial.mapper;

import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.entity.EditorialEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-02T14:41:42-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.14 (Oracle Corporation)"
)
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public EditorialDto editoriaEntityToEditoriaDto(EditorialEntity categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        EditorialDto editorialDto = new EditorialDto();

        editorialDto.setId( categoriaEntity.getId() );
        editorialDto.setNombre( categoriaEntity.getNombre() );
        editorialDto.setCreated( categoriaEntity.getCreated() );
        editorialDto.setModified( categoriaEntity.getModified() );

        return editorialDto;
    }

    @Override
    public EditorialEntity editoriaDtoToEditoriaEntity(EditorialDto categoriaDto) {
        if ( categoriaDto == null ) {
            return null;
        }

        EditorialEntity editorialEntity = new EditorialEntity();

        editorialEntity.setId( categoriaDto.getId() );
        editorialEntity.setNombre( categoriaDto.getNombre() );
        editorialEntity.setCreated( categoriaDto.getCreated() );
        editorialEntity.setModified( categoriaDto.getModified() );

        return editorialEntity;
    }

    @Override
    public List<EditorialDto> editoriaEntityListToEditoriaDtoList(List<EditorialEntity> categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        List<EditorialDto> list = new ArrayList<EditorialDto>( categoriaEntity.size() );
        for ( EditorialEntity editorialEntity : categoriaEntity ) {
            list.add( editoriaEntityToEditoriaDto( editorialEntity ) );
        }

        return list;
    }
}
