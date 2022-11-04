package com.jesusta.biblioteca.libros.controller;

import com.jesusta.biblioteca.libros.dto.LibrosDto;
import com.jesusta.biblioteca.libros.service.LibroSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Libros")
public class LibroController {
    @Autowired
    LibroSevice libroSevice;

    @GetMapping("/get/{id}")
    public ResponseEntity<LibrosDto> fingById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(libroSevice.getByid(id));
    }

}
