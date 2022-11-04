package com.jesusta.biblioteca.libros.client;

import com.jesusta.biblioteca.libros.dto.CategoriaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-catgoria",path = "/Categoria")

public interface CategoriaClient {
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaDto> fingById(@PathVariable(name = "id") Long id);
}
