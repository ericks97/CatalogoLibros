package com.proyecto.literalura.CatalogoLibros.service;

import com.proyecto.literalura.CatalogoLibros.model.DatosBusqueda;
import org.springframework.http.client.reactive.JdkClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://gutendex.com/books/")
                .build();
    }

    public DatosBusqueda buscarLibrosEnAPI(String busqueda) {
        String query = UriUtils.encode(busqueda, StandardCharsets.UTF_8);

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("search", query)
                        .build())
                .retrieve()
                .bodyToMono(DatosBusqueda.class)
                .block();
    }
}
