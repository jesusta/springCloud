package com.jesusta.biblioteca.editorial.service.impl;

import com.jesusta.biblioteca.editorial.Data.FactoryEditorial;
import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.entity.EditorialEntity;
import com.jesusta.biblioteca.editorial.exception.NotFoundException;
import com.jesusta.biblioteca.editorial.repository.EditorialRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CategoriaSeviceImplTest {
    @InjectMocks
    private EditorialSeviceImpl categoriaSevice;

    @Mock
    private EditorialRepository categoriaRepository;
    @BeforeEach
    void setUp() {


    }

    @Test
    void getByid() {
        EditorialEntity categoriaEntity = FactoryEditorial.getCategoriaEntity();
        Optional<EditorialEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);
        EditorialDto categoriaDto= categoriaSevice.getByid(1l);
        Assertions.assertNotNull(categoriaDto);
        Assertions.assertEquals(categoriaDto.getId(),categoriaEntity.getId());
        Assertions.assertEquals(1l,categoriaEntity.getId());
    }


    @Test
    void getall() {
        List<EditorialEntity> categoriaEntities = List.of(FactoryEditorial.getCategoriaEntity());
        when(categoriaRepository.findAll()).thenReturn(categoriaEntities);
        List<EditorialDto> categoriaDtos= categoriaSevice.getall();
        Assertions.assertNotNull(categoriaDtos);
    }

    @Test
    void create() {

        EditorialDto categoriaDto= FactoryEditorial.getCategoriaDto();
        categoriaDto.setId(null);
        EditorialEntity categoriaEntity = FactoryEditorial.getCategoriaEntity();
        when(categoriaRepository.save(any(EditorialEntity.class))).thenReturn(categoriaEntity);
        EditorialDto categoriaDto1=categoriaSevice.create(categoriaDto);
        Assertions.assertNotNull(categoriaDto1.getId());

    }

    @Test
    void delete() {
        EditorialEntity categoriaEntity = FactoryEditorial.getCategoriaEntity();
        Optional<EditorialEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);
        Map<String, Object> map = categoriaSevice.delete(any(Long.class));
        Assertions.assertNotNull(map);

    }

    @Test
    void update() {
        EditorialDto categoriaDto= FactoryEditorial.getCategoriaDto();
        categoriaDto.setNombre("anime");
        EditorialEntity categoriaEntity = FactoryEditorial.getCategoriaEntity();
        Optional<EditorialEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);

        when(categoriaRepository.save(any(EditorialEntity.class))).thenReturn(categoriaEntity);
        EditorialDto categoriaDto1=categoriaSevice.update(categoriaDto);
        Assertions.assertEquals(categoriaDto1.getNombre(),"anime");
    }
}