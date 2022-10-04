package com.jesusta.biblioteca.categoria.service;

import com.jesusta.biblioteca.categoria.dto.CategoriaDto;

import java.util.List;
import java.util.Map;

public interface CategoriaService {
    public CategoriaDto getByid(Long id);
    public List<CategoriaDto> getall();
    public Map<String, Object> create(CategoriaDto categoriaDto);
    public Map<String, Object> delete(Long id);
    public Map<String, Object> update(CategoriaDto categoriaDto);
}
