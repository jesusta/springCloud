package com.jesusta.biblioteca.categoria.controller;

import com.jesusta.biblioteca.categoria.Data.FactoryCategoria;
import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import com.jesusta.biblioteca.categoria.service.CategoriaService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@ExtendWith(MockitoExtension.class)
class CategoriaControllerTest {
    private MockMvc mvc;
    @InjectMocks
    private CategoriaController categoriaController;
    @Mock
    private CategoriaService categoriaService;
    @BeforeEach
    void setUp() {
        mvc = standaloneSetup(categoriaController).build();
    }


    @Test
    void fingById() throws Exception {
        CategoriaDto categoriaDto= FactoryCategoria.getCategoriaDto();
        when(categoriaService.getByid(any(Long.class)) ).thenReturn(categoriaDto);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/Categoria/get/1")
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    @Test
    void delete() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Acción realizada correctamente");
        when(categoriaService.delete(any(Long.class)) ).thenReturn(map);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .delete("/Categoria/delete/1")

                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
        verify(categoriaService).delete(any(Long.class));
    }


    @Test
    void fingAll() throws Exception {
        CategoriaDto categoriaDto=FactoryCategoria.getCategoriaDto();
        List<CategoriaDto> categoriaDtos = List.of(categoriaDto);
        when(categoriaService.getall()).thenReturn(categoriaDtos);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/Categoria/get")
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
               // .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(categoriaDto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre", Matchers.is(categoriaDto.getNombre())))
        ;
    }

    @Test
    void update() throws Exception {
        var categoriaDto= FactoryCategoria.getCategoriaDto();
        when(categoriaService.update(any(CategoriaDto.class)) ).thenReturn(categoriaDto);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .put("/Categoria/put")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(FactoryCategoria.getJSONCategoria())
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
        verify(categoriaService).update(any(CategoriaDto.class));
    }


    @Test
    void create() throws Exception {
        var categoriaDto= FactoryCategoria.getCategoriaDto();
        when(categoriaService.create(any(CategoriaDto.class)) ).thenReturn(categoriaDto);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/Categoria/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(FactoryCategoria.getJSONCategoria())
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
        verify(categoriaService).create(any(CategoriaDto.class));
    }

    }
