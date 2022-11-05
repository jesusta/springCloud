package com.jesusta.biblioteca.libros.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class EditorialDto {
    private Long id;
    private String nombre;
    private Date created;
    private Date modified;
}
