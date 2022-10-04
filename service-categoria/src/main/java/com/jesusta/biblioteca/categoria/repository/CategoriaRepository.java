package com.jesusta.biblioteca.categoria.repository;

import com.jesusta.biblioteca.categoria.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
}
