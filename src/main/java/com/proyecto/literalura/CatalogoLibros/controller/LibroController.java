package com.proyecto.literalura.CatalogoLibros.controller;

import com.proyecto.literalura.CatalogoLibros.model.Libro;
import com.proyecto.literalura.CatalogoLibros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> buscarLibroPorAutorYTitulo(@RequestParam("search") String busqueda) {
        return libroService.buscarLibroPorAutorYTitulo(busqueda);
    }

}
