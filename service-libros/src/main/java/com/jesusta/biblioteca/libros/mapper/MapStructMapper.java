package com.jesusta.biblioteca.libros.mapper;

import com.jesusta.biblioteca.libros.dto.LibrosDto;
import com.jesusta.biblioteca.libros.entity.LibrosEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MapStructMapper {
    LibrosDto LibroEntityToLibroDto(LibrosEntity librosEntity);
}
