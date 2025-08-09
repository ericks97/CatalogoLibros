package com.proyecto.literalura.CatalogoLibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ID de la API para evitar duplicados
    @JsonAlias("id")
    @Column(unique = true)
    private Long gutendexId;

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("download_count")
    private Integer numeroDeDescargas;

    // Mapeo de la lista de autores
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @JsonAlias("authors")
    private List<Autor> autores;

    // Mapeo de la lista de traductores
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libro_traductor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "traductor_id"))
    @JsonAlias("translators")
    private List<Autor> traductores;

    public Libro(){}

    public Libro(Long gutendexId, String titulo, List<String> idiomas, Integer numeroDeDescargas, List<Autor> autores, List<Autor> traductores) {
        this.gutendexId = gutendexId;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.numeroDeDescargas = numeroDeDescargas;
        this.autores = autores;
        this.traductores = traductores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGutendexId() {
        return gutendexId;
    }

    public void setGutendexId(Long gutendexId) {
        this.gutendexId = gutendexId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Autor> getTraductores() {
        return traductores;
    }

    public void setTraductores(List<Autor> traductores) {
        this.traductores = traductores;
    }
}


