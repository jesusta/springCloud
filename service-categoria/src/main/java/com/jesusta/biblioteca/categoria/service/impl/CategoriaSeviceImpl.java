package com.jesusta.biblioteca.categoria.service.impl;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import com.jesusta.biblioteca.categoria.exception.InvalidDataException;
import com.jesusta.biblioteca.categoria.exception.NotFoundException;
import com.jesusta.biblioteca.categoria.mapper.MapStructMapper;
import com.jesusta.biblioteca.categoria.repository.CategoriaRepository;
import com.jesusta.biblioteca.categoria.service.CategoriaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaSeviceImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired(required = false)
    MapStructMapper mapStructMapper  = Mappers.getMapper(MapStructMapper.class);

    @Override
    public CategoriaDto getByid(Long id) {
        Optional<CategoriaEntity> optEntity = categoriaRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el categoria con id : "+id);
        }
        CategoriaDto categoriaDto=mapStructMapper.categoriaEntityToCategoriaDto(optEntity.get());
        return categoriaDto ;
    }

    @Override
    public List<CategoriaDto> getall() {
        List<CategoriaEntity> listCategoriaEntity= categoriaRepository.findAll();
        if(listCategoriaEntity.isEmpty())
            throw  new NotFoundException( "No exite niguna categoria");
        return mapStructMapper.categoriaEntityListToCategoriaDtoList(listCategoriaEntity);
    }

    @Override
    public CategoriaDto create(CategoriaDto categoriaDto) {

        if(categoriaDto.getId()!=null){
            throw  new InvalidDataException( "Debe tener id null");
        }
        CategoriaEntity categoriaEntity = null;
        categoriaEntity = mapStructMapper.categoriaDtoTocategoriaEntity(categoriaDto);
        categoriaEntity = categoriaRepository.save(categoriaEntity);
        return  mapStructMapper.categoriaEntityToCategoriaDto(categoriaEntity);
    }

    @Override
    public Map<String, Object> delete(Long id) {

        Optional<CategoriaEntity> optEntity = categoriaRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el categoria con id : "+ id);
        }
        categoriaRepository.delete(optEntity.get());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Acción realizada correctamente");
        return  map;
    }

    @Override
    public CategoriaDto update(CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = null;
        if(categoriaDto.getId()==null){
            throw  new InvalidDataException("para actualizar se debe tener el id");
        }
        Optional<CategoriaEntity> optEntity = categoriaRepository.findById(categoriaDto.getId());
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el categoria con id : "+categoriaEntity.getId());
        }
        categoriaEntity = optEntity.get();
        categoriaEntity.setNombre(categoriaDto.getNombre());
        categoriaEntity.setModified(new Date());
        categoriaEntity = categoriaRepository.save(categoriaEntity);
        return mapStructMapper.categoriaEntityToCategoriaDto(categoriaEntity);
    }
}
