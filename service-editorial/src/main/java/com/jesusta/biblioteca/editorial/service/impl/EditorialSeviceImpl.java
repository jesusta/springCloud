package com.jesusta.biblioteca.editorial.service.impl;

import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.entity.EditorialEntity;
import com.jesusta.biblioteca.editorial.exception.InvalidDataException;
import com.jesusta.biblioteca.editorial.exception.NotFoundException;
import com.jesusta.biblioteca.editorial.mapper.MapStructMapper;
import com.jesusta.biblioteca.editorial.repository.EditorialRepository;
import com.jesusta.biblioteca.editorial.service.EditorialService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EditorialSeviceImpl implements EditorialService {
    @Autowired
    EditorialRepository editorialRepository;
    @Autowired(required = false)
    MapStructMapper mapStructMapper  = Mappers.getMapper(MapStructMapper.class);

    @Override
    public EditorialDto getByid(Long id) {
        Optional<EditorialEntity> optEntity = editorialRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el Editoria con id : "+id);
        }
        EditorialDto editorialDto=mapStructMapper.editoriaEntityToEditoriaDto(optEntity.get());
        return editorialDto ;
    }

    @Override
    public List<EditorialDto> getall() {
        List<EditorialEntity> listEditoriaEntity= editorialRepository.findAll();
        if(listEditoriaEntity.isEmpty())
            throw  new NotFoundException( "No exite niguna Editoria");
        return mapStructMapper.editoriaEntityListToEditoriaDtoList(listEditoriaEntity);
    }

    @Override
    public EditorialDto create(EditorialDto editorialDto) {
        if(editorialDto.getId()!=null){
            throw  new InvalidDataException( "Debe tener id null");
        }
        if(editorialDto.getCreated()==null){
            editorialDto.setCreated(new Date());
        }
        editorialDto.setModified(new Date());
        EditorialEntity editorialEntity = null;
        editorialEntity = mapStructMapper.editoriaDtoToEditoriaEntity(editorialDto);
        editorialEntity = editorialRepository.save(editorialEntity);
        return  mapStructMapper.editoriaEntityToEditoriaDto(editorialEntity);
    }

    @Override
    public Map<String, Object> delete(Long id) {

        Optional<EditorialEntity> optEntity = editorialRepository.findById(id);
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el Editoria con id : "+ id);
        }
        editorialRepository.delete(optEntity.get());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Acción realizada correctamente");
        return  map;
    }

    @Override
    public EditorialDto update(EditorialDto editorialDto) {
        EditorialEntity editorialEntity = null;
        if(editorialDto.getId()==null){
            throw  new InvalidDataException("para actualizar se debe tener el id");
        }
        Optional<EditorialEntity> optEntity = editorialRepository.findById(editorialDto.getId());
        if(optEntity.isEmpty()==true){
            throw  new NotFoundException( "No exite el Editoria con id : "+editorialEntity.getId());
        }
        editorialEntity = optEntity.get();
        editorialEntity.setNombre(editorialDto.getNombre());
        editorialEntity.setModified(new Date());
        editorialEntity = editorialRepository.save(editorialEntity);
        return mapStructMapper.editoriaEntityToEditoriaDto(editorialEntity);
    }
}

