package com.proyecto.literalura.CatalogoLibros.service;

import com.proyecto.literalura.CatalogoLibros.model.Autor;
import com.proyecto.literalura.CatalogoLibros.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> obtenerTodosLosAutores (){
        return autorRepository.findAll();

    }

    public List<Autor> obtenerAutoresVivosPorAnio(Integer anio) {
        return autorRepository.findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqualOrAnioFallecimientoIsNull(anio, anio);
    }
}

