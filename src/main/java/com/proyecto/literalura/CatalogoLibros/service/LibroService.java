package com.proyecto.literalura.CatalogoLibros.service;


import com.proyecto.literalura.CatalogoLibros.model.Libro;
import com.proyecto.literalura.CatalogoLibros.repository.LibroRepository;
import org.springframework.http.client.reactive.JdkClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


//@Service nos permitirá anunciar que esta clase es un servicio asi poder utilizarlo de ser necesario luego en controller
@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final WebClient webClient;

    public LibroService(LibroRepository libroRepository, WebClient.Builder webClientBuilder) {
        this.libroRepository = libroRepository;
        this.webClient = webClientBuilder
                .clientConnector(new JdkClientHttpConnector())
                .build();
    }

    public String obtenerDatos() {
        return webClient.get()
                .uri("https://gutendex.com/books/")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public List<Libro> buscarLibroPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        return libroRepository.findByNombre(nombre);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }
}