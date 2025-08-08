package com.proyecto.literalura.CatalogoLibros.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatusController {
    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return Map.of("status", "Aplicación en línea y funcionando correctamente");
    }
}

