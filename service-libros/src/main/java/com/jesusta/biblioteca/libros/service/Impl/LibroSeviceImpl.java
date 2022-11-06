package com.jesusta.biblioteca.libros.service.Impl;

import com.jesusta.biblioteca.libros.client.CategoriaClient;
import com.jesusta.biblioteca.libros.client.EditorialClient;
import com.jesusta.biblioteca.libros.dto.CategoriaDto;
import com.jesusta.biblioteca.libros.dto.EditorialDto;
import com.jesusta.biblioteca.libros.dto.LibrosDto;
import com.jesusta.biblioteca.libros.entity.LibrosEntity;
import com.jesusta.biblioteca.libros.exception.InvalidDataException;
import com.jesusta.biblioteca.libros.exception.NotFoundException;
import com.jesusta.biblioteca.libros.mapper.MapStructMapper;
import com.jesusta.biblioteca.libros.repository.LibrosRepository;
import com.jesusta.biblioteca.libros.service.LibroSevice;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public LibrosDto createLibro(LibrosDto librosDto) {
        if(librosDto.getId()!=null){
            throw  new InvalidDataException("El id debe ser nulo");
        }
        Long idCategoria = (librosDto.getCategorias_id()!=null?librosDto.getCategorias_id()
                :(librosDto.getCategoriaDto()!=null?librosDto.getCategoriaDto().getId():null));
        Long idEditorial = (librosDto.getEditoriales_id()!=null?librosDto.getEditoriales_id()
                :(librosDto.getEditorialDto()!=null?librosDto.getEditorialDto().getId():null));
        if(idCategoria==null){
            throw  new InvalidDataException("El Categorias_id debe no ser nulo");
        }
        if(idEditorial==null){
            throw  new InvalidDataException("El Editoriales_id debe no ser nulo");
        }
        CategoriaDto categoriaDto=categoriaClient.fingCategoriaById(idCategoria).getBody();
        EditorialDto editorialDto=editorialClient.fingEditorialById(idEditorial).getBody();
        if(categoriaDto.getNombre().equalsIgnoreCase("none")){
            throw  new InvalidDataException("El Categoria no exite");
        }
        if(editorialDto.getNombre().equalsIgnoreCase("none")){
            throw  new InvalidDataException("El Editorial  no exite");
        }
        librosDto.setCategorias_id(idCategoria);
        librosDto.setEditoriales_id(idEditorial);
        librosDto.setCreated(new Date());
        LibrosEntity librosEntity =  mapStructMapper.libroDtoTolibroEntity(librosDto);
        librosEntity=librosRepository.save(librosEntity);
        librosDto = mapStructMapper.libroEntityToLibroDto(librosEntity);
        librosDto.setCategoriaDto(categoriaDto);
        librosDto.setEditorialDto(editorialDto);
        return librosDto;
    }

    @Override
    public Map<Object, String> deteteLibrosByid(Long id) {
        Optional< LibrosEntity> optEntity =librosRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el libro con id : "+id);
        }
        librosRepository.delete(optEntity.get());
        Map<Object, String> map= new HashMap<>();
        map.put("message", "Acción realizada correctamente");
        return map;
    }

    @Override
    public LibrosDto updateLibro(LibrosDto librosDto) {
        if(librosDto.getId()==null){
            throw  new InvalidDataException("El id no debe ser nulo");
        }
        Long idCategoria = (librosDto.getCategorias_id()!=null?librosDto.getCategorias_id()
                :(librosDto.getCategoriaDto()!=null?librosDto.getCategoriaDto().getId():null));
        Long idEditorial = (librosDto.getEditoriales_id()!=null?librosDto.getEditoriales_id()
                :(librosDto.getEditorialDto()!=null?librosDto.getEditorialDto().getId():null));
        if(idCategoria==null){
            throw  new InvalidDataException("El Categorias_id debe no ser nulo");
        }
        if(idEditorial==null){
            throw  new InvalidDataException("El Editoriales_id debe no ser nulo");
        }
        CategoriaDto categoriaDto=categoriaClient.fingCategoriaById(idCategoria).getBody();
        EditorialDto editorialDto=editorialClient.fingEditorialById(idEditorial).getBody();
        if(categoriaDto.getNombre().equalsIgnoreCase("none")){
            throw  new InvalidDataException("El Categoria no exite");
        }
        if(editorialDto.getNombre().equalsIgnoreCase("none")){
            throw  new InvalidDataException("El Editorial  no exite");
        }
        librosDto.setCategorias_id(idCategoria);
        librosDto.setEditoriales_id(idEditorial);
        librosDto.setModified(new Date());
        LibrosEntity librosEntity =  mapStructMapper.libroDtoTolibroEntity(librosDto);
        librosEntity=librosRepository.save(librosEntity);
        librosDto = mapStructMapper.libroEntityToLibroDto(librosEntity);
        librosDto.setCategoriaDto(categoriaDto);
        librosDto.setEditorialDto(editorialDto);
        return librosDto;
    }
}
