package com.jesusta.biblioteca.libros.service.Impl;

import com.jesusta.biblioteca.libros.client.CategoriaClient;
import com.jesusta.biblioteca.libros.client.EditorialClient;
import com.jesusta.biblioteca.libros.dto.CategoriaDto;
import com.jesusta.biblioteca.libros.dto.EditorialDto;
import com.jesusta.biblioteca.libros.dto.LibrosDto;
import com.jesusta.biblioteca.libros.entity.LibrosEntity;
import com.jesusta.biblioteca.libros.exception.NotFoundException;
import com.jesusta.biblioteca.libros.mapper.MapStructMapper;
import com.jesusta.biblioteca.libros.repository.LibrosRepository;
import com.jesusta.biblioteca.libros.service.LibroSevice;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroSeviceImpl implements LibroSevice {
    @Autowired
    LibrosRepository librosRepository;
    @Autowired
    CategoriaClient categoriaClient;
    @Autowired
    EditorialClient editorialClient;
    @Autowired(required = false)
    MapStructMapper mapStructMapper  = Mappers.getMapper(MapStructMapper.class);;

    public LibrosDto getByid(Long id) {
        Optional< LibrosEntity> optEntity =librosRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el Editoria con id : "+id);
        }
        CategoriaDto categoriaDto=categoriaClient.fingById(optEntity.get().getCategorias_id());
        EditorialDto editorialDto=editorialClient.fingById(optEntity.get().getEditoriales_id());
        LibrosDto librosDto = mapStructMapper.LibroEntityToLibroDto(optEntity.get());
        librosDto.setCategoriaDto(categoriaDto);
        librosDto.setEditorialDto(editorialDto);
        return librosDto;
    }
}
