package com.proyecto.literalura.CatalogoLibros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBusqueda(List<Libro> results) {
}
