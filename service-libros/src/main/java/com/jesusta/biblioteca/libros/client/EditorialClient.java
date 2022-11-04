package com.jesusta.biblioteca.libros.client;

import com.jesusta.biblioteca.libros.dto.EditorialDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-editorial")
@RequestMapping("/Editoriales")
public interface EditorialClient {
    @GetMapping("/get/{id}")
    public EditorialDto fingById(@PathVariable(name = "id") Long id);
}
