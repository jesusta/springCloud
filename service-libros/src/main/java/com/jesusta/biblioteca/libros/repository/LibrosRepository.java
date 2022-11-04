package com.jesusta.biblioteca.libros.repository;

import com.jesusta.biblioteca.libros.entity.LibrosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<LibrosEntity,Long> {

}
