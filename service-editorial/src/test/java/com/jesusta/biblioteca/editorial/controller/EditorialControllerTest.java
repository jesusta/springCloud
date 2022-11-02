package com.jesusta.biblioteca.editorial.controller;

import com.jesusta.biblioteca.editorial.Data.FactoryEditorial;
import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.service.EditorialService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@ExtendWith(MockitoExtension.class)
class EditorialControllerTest {
    private MockMvc mvc;
    @InjectMocks
    private EditorialController categoriaController;
    @Mock
    private EditorialService categoriaService;
    @BeforeEach
    void setUp() {
        mvc = standaloneSetup(categoriaController).build();
    }


    @Test
    void fingById() throws Exception {
        EditorialDto categoriaDto= FactoryEditorial.getCategoriaDto();
        when(categoriaService.getByid(any(Long.class)) ).thenReturn(categoriaDto);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/Editoriales/get/1")
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
        EditorialDto categoriaDto= FactoryEditorial.getCategoriaDto();
        List<EditorialDto> categoriaDtos = List.of(categoriaDto);
        when(categoriaService.getall()).thenReturn(categoriaDtos);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/Editoriales/get")
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
               // .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(categoriaDto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre", Matchers.is(categoriaDto.getNombre())))
        ;
    }

    @Test
    void update() throws Exception {
        var categoriaDto= FactoryEditorial.getCategoriaDto();
        when(categoriaService.update(any(EditorialDto.class)) ).thenReturn(categoriaDto);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .put("/Editoriales/put")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(FactoryEditorial.getJSONEditoria())
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
        verify(categoriaService).update(any(EditorialDto.class));
    }


    @Test
    void create() throws Exception {
        var categoriaDto= FactoryEditorial.getCategoriaDto();
        when(categoriaService.create(any(EditorialDto.class)) ).thenReturn(categoriaDto);
        mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/Editoriales/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(FactoryEditorial.getJSONEditoria())
                        //.param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
        verify(categoriaService).create(any(EditorialDto.class));
    }

    }
