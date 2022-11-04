package com.jesusta.biblioteca.libros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class LibrosDto {
    private Long id;
    @NotNull(message = "El parametro titulo no puede ser nulo")
    @NotEmpty(message = "El parametro titulo no puede ser vacio")
    private String titulo;
    @NotNull(message = "El parametro descripcion no puede ser nulo")
    @NotEmpty(message = "El parametro descripcion no puede ser vacio")
    private String descripcion;
    @NotNull(message = "El parametro precio no puede ser nulo")
    @NotEmpty(message = "El parametro precio no puede ser vacio")
    private double precio;
    @NotNull(message = "El parametro ejemplares no puede ser nulo")
    @NotEmpty(message = "El parametro ejemplares no puede ser vacio")
    private Integer ejemplares;
    @NotNull(message = "El parametro autor no puede ser nulo")
    @NotEmpty(message = "El parametro autor no puede ser vacio")
    private String autor;
    @JsonProperty("Categoria")
    private CategoriaDto categoriaDto;
    @JsonProperty("Editorial")
    private EditorialDto editorialDto;

    private Date created;
    private Date modified;
}
