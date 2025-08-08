package com.proyecto.literalura.CatalogoLibros.controller;

import com.proyecto.literalura.CatalogoLibros.model.Libro;
import com.proyecto.literalura.CatalogoLibros.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    private final LibroService libroService;

    // Constructor para inyección del service
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Endpoint para buscar libros por nombre
    @GetMapping("/libros/buscar")
    public List<Libro> buscarLibroPorNombre(@RequestParam String nombre) {
        return libroService.buscarLibroPorNombre(nombre);
    }

    // Otro endpoint para obtener datos generales (tu método actual)
    @GetMapping("/libros")
    public String obtenerLibrosDesdeApi() {
        return libroService.obtenerDatos();
    }

    @PostMapping("/libros")
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }
}
