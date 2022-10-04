package com.jesusta.biblioteca.categoria.mapper;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MapStructMapper {
    CategoriaDto categoriaEntityToCategoriaDto(CategoriaEntity categoriaEntity);
    CategoriaEntity categoriaDtoTocategoriaEntity(CategoriaDto categoriaDto);
}
