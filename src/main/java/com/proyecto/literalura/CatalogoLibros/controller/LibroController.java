package com.proyecto.literalura.CatalogoLibros.controller;

import com.proyecto.literalura.CatalogoLibros.service.ConsumirApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LibroController {

    private final ConsumirApiService consumirApiService;

    public LibroController(ConsumirApiService consumirApiService) {

        this.consumirApiService = consumirApiService;
    }

    @GetMapping("/libros")
    public String obtenerLibrosDesdeApi() {

        return consumirApiService.obtenerDatos();
    }
}
