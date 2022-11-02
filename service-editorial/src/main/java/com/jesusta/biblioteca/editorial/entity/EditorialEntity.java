package com.jesusta.biblioteca.editorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "editoriales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date created;
    private Date modified;
}
