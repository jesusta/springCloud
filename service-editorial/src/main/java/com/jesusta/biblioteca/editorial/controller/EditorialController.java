package com.jesusta.biblioteca.editorial.controller;


import com.jesusta.biblioteca.editorial.dto.EditorialDto;
import com.jesusta.biblioteca.editorial.exception.InvalidDataException;
import com.jesusta.biblioteca.editorial.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Editoriales")
public class EditorialController {
    @Autowired
    EditorialService editorialService;
    @GetMapping("/get/{id}")
    public ResponseEntity<EditorialDto> fingById(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(editorialService.getByid(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(editorialService.delete(id));
    }
    @GetMapping("/get")
    public ResponseEntity<List<EditorialDto>> fingAll(){
        return ResponseEntity.ok(editorialService.getall());
    }
    @PutMapping("/put")
    public ResponseEntity<EditorialDto> update(@Valid @RequestBody EditorialDto editorialDto, BindingResult bindingResult ){
        if (bindingResult.hasErrors()) {
            throw  new InvalidDataException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok(editorialService.update(editorialDto));
    }
    @PostMapping("/post")
    public ResponseEntity<EditorialDto> create(@Valid @RequestBody EditorialDto editorialDto, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return  ResponseEntity.ok(editorialService.create(editorialDto));
    }
}

