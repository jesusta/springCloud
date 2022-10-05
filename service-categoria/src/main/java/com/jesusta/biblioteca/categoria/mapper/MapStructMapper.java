package com.jesusta.biblioteca.categoria.mapper;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapStructMapper {
    CategoriaDto categoriaEntityToCategoriaDto(CategoriaEntity categoriaEntity);
    CategoriaEntity categoriaDtoTocategoriaEntity(CategoriaDto categoriaDto);

    List<CategoriaDto> categoriaEntityListToCategoriaDtoList( List<CategoriaEntity> categoriaEntity);
}
