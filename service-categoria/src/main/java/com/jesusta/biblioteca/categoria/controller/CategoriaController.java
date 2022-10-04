package com.jesusta.biblioteca.categoria.controller;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping("/get/{id}")
    public CategoriaDto fingById(@PathVariable (name = "id") Long id){
        return categoriaService.getByid(id);
    }
}
