package com.jesusta.biblioteca.libros.exception;

public class NotFoundException  extends RuntimeException {

    private static final long serialVersionUID = 8885173172323095604L;

    public NotFoundException(String message) {
        super(message);
    }
}
