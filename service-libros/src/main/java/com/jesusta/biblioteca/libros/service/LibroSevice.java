package com.jesusta.biblioteca.libros.service;

import com.jesusta.biblioteca.libros.dto.LibrosDto;

import java.util.List;

public interface LibroSevice {
    public LibrosDto getByid(Long id);
    public List<LibrosDto> gellAll();
}
