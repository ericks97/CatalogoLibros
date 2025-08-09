package com.proyecto.literalura.CatalogoLibros.repository;

import com.proyecto.literalura.CatalogoLibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByIdiomasContaining(String idioma);
}
