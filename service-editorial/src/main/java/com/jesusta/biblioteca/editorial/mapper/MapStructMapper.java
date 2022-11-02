package com.jesusta.biblioteca.editorial.mapper;

import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.entity.EditorialEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapStructMapper {
    EditorialDto editoriaEntityToEditoriaDto(EditorialEntity categoriaEntity);
    EditorialEntity editoriaDtoToEditoriaEntity(EditorialDto categoriaDto);

    List<EditorialDto> editoriaEntityListToEditoriaDtoList(List<EditorialEntity> categoriaEntity);
}
