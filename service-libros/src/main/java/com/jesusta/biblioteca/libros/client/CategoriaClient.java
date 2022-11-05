package com.jesusta.biblioteca.libros.client;

import com.jesusta.biblioteca.libros.dto.CategoriaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-catgoria",path = "/Categoria",fallback = HystrixFallBack.class)

public interface CategoriaClient {
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaDto> fingCategoriaById(@PathVariable(name = "id") Long id);
}
