package com.jesusta.biblioteca.libros.dto;

import lombok.Data;

import java.util.Date;
@Data
public class EditorialDto {
    private Long id;
    private String nombre;
    private Date created;
    private Date modified;
}
