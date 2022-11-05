package com.jesusta.biblioteca.libros.mapper;

import com.jesusta.biblioteca.libros.dto.LibrosDto;
import com.jesusta.biblioteca.libros.entity.LibrosEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapStructMapper {
    LibrosDto libroEntityToLibroDto(LibrosEntity librosEntity);
    List<LibrosDto> librolistaEntityToLibroDtolista(List<LibrosEntity> librosEntities);
}
