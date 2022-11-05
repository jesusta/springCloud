package com.jesusta.biblioteca.libros.repository;

import com.jesusta.biblioteca.libros.entity.LibrosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrosRepository extends JpaRepository<LibrosEntity,Long> {

    Optional<LibrosEntity> findByTitulo(String titulo);
}
