package com.jesusta.biblioteca.categoria.Data;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import com.jesusta.biblioteca.categoria.repository.CategoriaRepository;

import java.util.Date;

public class FactoryCategoria {
    public static CategoriaDto getCategoriaDto(){
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(1l);
        categoriaDto.setNombre("accion");
        categoriaDto.setCreated(new Date(20120909));
        return categoriaDto;
    }
    public  static CategoriaEntity getCategoriaEntity(){
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(1l);
        categoriaEntity.setNombre("accion");
        categoriaEntity.setCreated(new Date(20120909));
        return categoriaEntity;
    }
    public static String getJSONCategoria(){
        return "{\"nombre\": \"accion\"}";
    }
}
