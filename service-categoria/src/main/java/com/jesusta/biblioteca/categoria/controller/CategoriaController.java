package com.jesusta.biblioteca.categoria.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaDto> fingById(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(categoriaService.getByid(id));
    }
}
