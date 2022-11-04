package com.jesusta.biblioteca.libros.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libros")
@Data
public class LibrosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private double precio;
    private Integer ejemplares;
    private String autor;
    private Date created;
    private Date modified;
    private Long editoriales_id;
    private Long categorias_id;
}
