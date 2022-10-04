package com.jesusta.biblioteca.categoria.service.impl;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import com.jesusta.biblioteca.categoria.mapper.MapStructMapper;
import com.jesusta.biblioteca.categoria.repository.CategoriaRepository;
import com.jesusta.biblioteca.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoriaSeviceImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired(required = false)
    MapStructMapper mapStructMapper;

    @Override
    public CategoriaDto getByid(Long id) {
        Optional<CategoriaEntity> optEntity = categoriaRepository.findById(id);
        if(optEntity.isEmpty()==true){
          //  throw  new NotFountIDException( "No exite el empleado con id : "+id);
            return null;
        }
        return mapStructMapper.categoriaEntityToCategoriaDto(optEntity.get());
    }

    @Override
    public List<CategoriaDto> getall() {
        return null;
    }

    @Override
    public Map<String, Object> create(CategoriaDto categoriaDto) {
        return null;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> update(CategoriaDto categoriaDto) {
        return null;
    }
}
