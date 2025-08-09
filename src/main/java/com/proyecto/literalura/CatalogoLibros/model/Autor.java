package com.proyecto.literalura.CatalogoLibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("name")
    private String nombrePersona;
    @JsonAlias("birth_year")
    private Integer anioNacimiento;
    @JsonAlias("death_year")
    private Integer anioFallecimiento;

    public Autor(){}

    public Autor(String nombrePersona, Integer anioNacimiento, Integer anioFallecimiento) {
        this.nombrePersona = nombrePersona;
        this.anioNacimiento = anioNacimiento;
        this.anioFallecimiento = anioFallecimiento;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(Integer anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "Nombre: '" + nombrePersona + '\'' +
                ", Nacimiento=" + anioNacimiento +
                ", Fallecimiento=" + anioFallecimiento +
                '}';
    }
}