package com.jesusta.biblioteca.libros.client;

import com.jesusta.biblioteca.libros.dto.CategoriaDto;
import com.jesusta.biblioteca.libros.dto.EditorialDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBack implements EditorialClient,CategoriaClient{
    @Override
    public ResponseEntity<EditorialDto> fingEditorialById(Long id) {
        EditorialDto editorialDto =  EditorialDto.builder().
                nombre("none")
                .build();
        return ResponseEntity.ok(editorialDto) ;
    }

    @Override
    public ResponseEntity<CategoriaDto> fingCategoriaById(Long id) {
        CategoriaDto categoriaDto= CategoriaDto.builder().
                nombre("none")
                .build();
                return ResponseEntity .ok(categoriaDto);
    }
}
