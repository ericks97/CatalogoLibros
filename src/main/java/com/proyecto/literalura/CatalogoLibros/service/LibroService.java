package com.proyecto.literalura.CatalogoLibros.service;


import com.proyecto.literalura.CatalogoLibros.model.DatosBusqueda;
import com.proyecto.literalura.CatalogoLibros.model.Libro;
import com.proyecto.literalura.CatalogoLibros.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service nos permitirá anunciar que esta clase es un servicio asi poder utilizarlo de ser necesario luego en controller
@Service
public class LibroService {
    private final ApiService apiService;
    private final LibroRepository libroRepository;

    //Constructor que nos permitirá usar las variables de otras clases en en la clase Libro service.
    public LibroService(LibroRepository libroRepository, ApiService apiService) {
        this.libroRepository = libroRepository;
        this.apiService = apiService;
    }

    public List<Libro> buscarLibroPorTitulo(String nombreLibro) {
        if (nombreLibro == null || nombreLibro.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede estar vacio");
        }

        DatosBusqueda datosBusqueda = apiService.buscarLibrosEnAPI(nombreLibro);
        return datosBusqueda.results();
    }

    public List<Libro> buscarLibroPorAutorYTitulo(String busqueda) {
        if (busqueda == null || busqueda.trim().isEmpty()) {
            throw new IllegalArgumentException("La búsqueda no puede estar vacía.");
        }

        DatosBusqueda datosBusqueda = apiService.buscarLibrosEnAPI(busqueda);
        return datosBusqueda.results();
    }
}







