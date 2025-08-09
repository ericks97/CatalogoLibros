package com.proyecto.literalura.CatalogoLibros.repository;

import com.proyecto.literalura.CatalogoLibros.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqualOrAnioFallecimientoIsNull(Integer anioNacimiento, Integer anioFallecimiento);
}
