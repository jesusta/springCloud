package com.jesusta.biblioteca.editorial.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@Data
@NoArgsConstructor
public class EditorialDto {
    private Long id;
    @NotNull(message = "El parametro nombre no puede ser nulo")
    @NotEmpty(message = "El parametro nombre no puede ser vacio")
    private String nombre;
    private Date created;
    private Date modified;
}
