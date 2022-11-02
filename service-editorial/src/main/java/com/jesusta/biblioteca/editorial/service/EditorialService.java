package com.jesusta.biblioteca.editorial.service;

import com.jesusta.biblioteca.editorial.dto.EditorialDto;

import java.util.List;
import java.util.Map;

public interface EditorialService {
    public EditorialDto getByid(Long id);
    public List<EditorialDto> getall();
    public EditorialDto create(EditorialDto categoriaDto);
    public Map<String, Object> delete(Long id);
    public EditorialDto update(EditorialDto categoriaDto);
}
