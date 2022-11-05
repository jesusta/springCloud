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

import java.util.List;
import java.util.Optional;

@Service
public class LibroSeviceImpl implements LibroSevice {
    @Autowired
    LibrosRepository librosRepository;

    @Autowired
    EditorialClient editorialClient;
    @Autowired
    CategoriaClient categoriaClient;
    @Autowired(required = false)
    MapStructMapper mapStructMapper  = Mappers.getMapper(MapStructMapper.class);

    public LibrosDto getByid(Long id) {
        Optional< LibrosEntity> optEntity =librosRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el libro con id : "+id);
        }
        CategoriaDto categoriaDto=categoriaClient.fingCategoriaById(optEntity.get().getCategorias_id()).getBody();
        EditorialDto editorialDto=editorialClient.fingEditorialById(optEntity.get().getEditoriales_id()).getBody();
        LibrosDto librosDto = mapStructMapper.libroEntityToLibroDto(optEntity.get());
        librosDto.setCategoriaDto(categoriaDto);
        librosDto.setEditorialDto(editorialDto);
        return librosDto;
    }

    @Override
    public List<LibrosDto> gellAll() {
        List<LibrosDto> librosDtos;
        List<LibrosEntity> librosEntities =  librosRepository.findAll();
        librosDtos = mapStructMapper.librolistaEntityToLibroDtolista(librosEntities);
        librosDtos.stream().forEach(librosDto -> {
                    librosDto.setCategoriaDto(categoriaClient.fingCategoriaById(librosDto.getCategorias_id()).getBody());
                    librosDto.setEditorialDto(editorialClient.fingEditorialById(librosDto.getEditoriales_id()).getBody());
                }
        );
        return librosDtos;
    }
}
