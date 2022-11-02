package com.jesusta.biblioteca.editorial.dto.exception;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    /**
     * The HTTP status code
     */
    @NonNull
    private Integer status;
    /**
     * The error message associated with exception
     */
    @NonNull
    private String message;
    /**
     * List of constructed error messages
     */
    @NonNull
    private String details;
    /**
     * Date and time the exception occurred
     */
    private LocalDateTime timestamp = LocalDateTime.now();
}
