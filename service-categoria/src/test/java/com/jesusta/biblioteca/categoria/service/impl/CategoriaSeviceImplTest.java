package com.jesusta.biblioteca.categoria.service.impl;

import com.jesusta.biblioteca.categoria.Data.FactoryCategoria;
import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import com.jesusta.biblioteca.categoria.exception.NotFoundException;
import com.jesusta.biblioteca.categoria.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CategoriaSeviceImplTest {
    @InjectMocks
    private CategoriaSeviceImpl categoriaSevice;

    @Mock
    private CategoriaRepository categoriaRepository;
    @BeforeEach
    void setUp() {


    }

    @Test
    void getByid() {
        CategoriaEntity categoriaEntity = FactoryCategoria.getCategoriaEntity();
        Optional<CategoriaEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);
        CategoriaDto categoriaDto= categoriaSevice.getByid(1l);
        Assertions.assertNotNull(categoriaDto);
        Assertions.assertEquals(categoriaDto.getId(),categoriaEntity.getId());
        Assertions.assertEquals(1l,categoriaEntity.getId());
    }
    @Test
    void getByidExction() {
        CategoriaEntity categoriaEntity = FactoryCategoria.getCategoriaEntity();
        Optional<CategoriaEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);
        try {
            CategoriaDto categoriaDto= categoriaSevice.getByid(2l);
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
            Assertions.assertNotNull(e);
        }

    }

    @Test
    void getall() {
        List<CategoriaEntity> categoriaEntities = List.of(FactoryCategoria.getCategoriaEntity());
        when(categoriaRepository.findAll()).thenReturn(categoriaEntities);
        List<CategoriaDto> categoriaDtos= categoriaSevice.getall();
        Assertions.assertNotNull(categoriaDtos);
    }

    @Test
    void create() {

        CategoriaDto categoriaDto=FactoryCategoria.getCategoriaDto();
        categoriaDto.setId(null);
        CategoriaEntity categoriaEntity = FactoryCategoria.getCategoriaEntity();
        when(categoriaRepository.save(any(CategoriaEntity.class))).thenReturn(categoriaEntity);
        CategoriaDto categoriaDto1=categoriaSevice.create(categoriaDto);
        Assertions.assertNotNull(categoriaDto1.getId());

    }

    @Test
    void delete() {
        CategoriaEntity categoriaEntity = FactoryCategoria.getCategoriaEntity();
        Optional<CategoriaEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);
        Map<String, Object> map = categoriaSevice.delete(any(Long.class));
        Assertions.assertNotNull(map);

    }

    @Test
    void update() {
        CategoriaDto categoriaDto=FactoryCategoria.getCategoriaDto();
        categoriaDto.setNombre("anime");
        CategoriaEntity categoriaEntity = FactoryCategoria.getCategoriaEntity();
        Optional<CategoriaEntity> categoriaEntityOptional= Optional.of(categoriaEntity);
        when(categoriaRepository.findById(any(Long.class))).thenReturn(categoriaEntityOptional);

        when(categoriaRepository.save(any(CategoriaEntity.class))).thenReturn(categoriaEntity);
        CategoriaDto categoriaDto1=categoriaSevice.update(categoriaDto);
        Assertions.assertEquals(categoriaDto1.getNombre(),"anime");
    }
}