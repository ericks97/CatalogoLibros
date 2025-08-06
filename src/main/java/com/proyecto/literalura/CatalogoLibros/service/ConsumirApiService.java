package com.proyecto.literalura.CatalogoLibros.service;


import org.springframework.http.client.reactive.JdkClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


//@Service nos permitirá anunciar que esta clase es un servicio asi poder utilizarlo de ser necesario luego en controller
@Service
public class ConsumirApiService {

    private final WebClient webClient;

    public ConsumirApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .clientConnector(new JdkClientHttpConnector())
                .build();
    }

    public String obtenerDatos() {
        return webClient.get()
                .uri("https://gutendex.com/books/")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Se usa block() para obtener el resultado de forma síncrona
    }
}