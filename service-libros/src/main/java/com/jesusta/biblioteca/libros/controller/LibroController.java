package com.jesusta.biblioteca.libros.controller;

import com.jesusta.biblioteca.libros.dto.LibrosDto;
import com.jesusta.biblioteca.libros.exception.InvalidDataException;
import com.jesusta.biblioteca.libros.service.LibroSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Libros")
public class LibroController {
    @Autowired
    LibroSevice libroSevice;

    @GetMapping("/get/{id}")
    public ResponseEntity<LibrosDto> fingById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(libroSevice.getByid(id));
    }
    @GetMapping("/get")
    public ResponseEntity<List<LibrosDto>> findAll(){
        return  ResponseEntity.ok(libroSevice.gellAll());
    }
    @PostMapping("/post")
    public ResponseEntity<LibrosDto> CreateLibro(@Valid @RequestBody LibrosDto librosDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return  null;
    }

}
