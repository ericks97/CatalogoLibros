package com.proyecto.literalura.CatalogoLibros.service;


import com.proyecto.literalura.CatalogoLibros.model.Autor;
import com.proyecto.literalura.CatalogoLibros.model.DatosBusqueda;
import com.proyecto.literalura.CatalogoLibros.model.Libro;
import com.proyecto.literalura.CatalogoLibros.repository.AutorRepository;
import com.proyecto.literalura.CatalogoLibros.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public Libro buscarLibroPorTitulo(String nombreLibro) {
        if (nombreLibro == null || nombreLibro.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede estar vacio");
        }

        // Paso 1: Buscar el libro en la base de datos local
        Optional<Libro> libroExistente = libroRepository.findByTituloContainingIgnoreCase(nombreLibro).stream().findFirst();

        if (libroExistente.isPresent()) {
            System.out.println("El libro ya existe en la base de datos.");
            return libroExistente.get();
        }

        // Paso 2: Si no existe, buscarlo en la API externa
        DatosBusqueda datosBusqueda = apiService.buscarLibrosEnAPI(nombreLibro);
        List<Libro> resultados = datosBusqueda.results();

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
            return null;
        } else {
            // Paso 3: Guardar el nuevo libro en la base de datos
            Libro libroEncontrado = resultados.get(0);
            libroEncontrado.setId(null);
            libroRepository.save(libroEncontrado);
            System.out.println("El libro fue añadido a la base de datos. ");
            return libroEncontrado;
        }
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }
}









