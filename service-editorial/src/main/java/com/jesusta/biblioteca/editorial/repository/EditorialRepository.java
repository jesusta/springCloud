package com.jesusta.biblioteca.editorial.repository;

import com.jesusta.biblioteca.editorial.entity.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<EditorialEntity,Long> {
}
