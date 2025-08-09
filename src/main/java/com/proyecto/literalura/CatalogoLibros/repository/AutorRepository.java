package com.proyecto.literalura.CatalogoLibros.repository;

import com.proyecto.literalura.CatalogoLibros.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
