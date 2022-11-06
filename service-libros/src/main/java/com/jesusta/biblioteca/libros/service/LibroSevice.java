package com.jesusta.biblioteca.libros.service;

import com.jesusta.biblioteca.libros.dto.LibrosDto;

import java.util.List;
import java.util.Map;

public interface LibroSevice {
    public LibrosDto getByid(Long id);
    public List<LibrosDto> gellAll();
    public LibrosDto createLibro(LibrosDto librosDto);
    public Map<Object,String> deteteLibrosByid(Long id);
    public LibrosDto updateLibro(LibrosDto librosDto);

}
