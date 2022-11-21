package com.jesusta.biblioteca.categoria.controller;


import com.jesusta.biblioteca.categoria.dto.CategoriaDto;
import com.jesusta.biblioteca.categoria.exception.InvalidDataException;
import com.jesusta.biblioteca.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaDto> fingById(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(categoriaService.getByid(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(categoriaService.delete(id));
    }
    @GetMapping("/get")
    public ResponseEntity<List<CategoriaDto>> fingAll(){

        return ResponseEntity.ok(categoriaService.getall());
    }
    @PutMapping("/put")
    public ResponseEntity<CategoriaDto> update(@Valid @RequestBody CategoriaDto categoriaDto, BindingResult bindingResult ){
        if (bindingResult.hasErrors()) {
            throw  new InvalidDataException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok(categoriaService.update(categoriaDto));
    }
    @PostMapping("/post")
    public ResponseEntity<CategoriaDto> create(@Valid @RequestBody CategoriaDto categoriaDto, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return  ResponseEntity.ok(categoriaService.create(categoriaDto));
    }
}
