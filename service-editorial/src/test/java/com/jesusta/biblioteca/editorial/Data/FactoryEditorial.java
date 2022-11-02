package com.jesusta.biblioteca.editorial.Data;

import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.entity.EditorialEntity;

import java.util.Date;

public class FactoryEditorial {
    public static EditorialDto getCategoriaDto(){
        EditorialDto editorialDto = new EditorialDto();
        editorialDto.setId(1l);
        editorialDto.setNombre("accion");
        editorialDto.setCreated(new Date(20120909));
        return editorialDto;
    }
    public  static EditorialEntity getCategoriaEntity(){
        EditorialEntity editorialEntity = new EditorialEntity();
        editorialEntity.setId(1l);
        editorialEntity.setNombre("accion");
        editorialEntity.setCreated(new Date(20120909));
        return editorialEntity;
    }
    public static String getJSONEditoria(){
        return "{\"nombre\": \"accion\"}";
    }
}

