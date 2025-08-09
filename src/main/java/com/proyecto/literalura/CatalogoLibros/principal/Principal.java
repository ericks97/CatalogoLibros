package com.proyecto.literalura.CatalogoLibros.principal;

import com.proyecto.literalura.CatalogoLibros.model.Autor;
import com.proyecto.literalura.CatalogoLibros.service.LibroService;
import com.proyecto.literalura.CatalogoLibros.model.Libro;

import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {
    private final LibroService libroService;
    private Scanner sc = new Scanner(System.in);
    private int opcion;
    private String continuar;
    private String menu = """
            Elija la opción que necesita:
            1) Buscar libro por título
            2) Mostar mis libro
            3) Mostrar mis autores
            4) Listar Autores vivos en un determinado año
            5) Mostrar Libros por Idioma
            0) Salir
            """;
    private String preguntaContinuar = "¿Desea ver más libro[Y/N]?";

    public Principal(LibroService libroService) {
        this.libroService = libroService;

    }

    public void showMenu() {
        do {
            System.out.println(menu);
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion >= 1 && opcion <= 5) {
                    switch (opcion) {
                        case 1:
                            buscarLibroPorTitulo();
                            break;
                        case 2:
                            listarLibrosRegistrados();
                            break;
                        case 3:
                            listarAutoresRegistrados();
                            break;
                        case 4:
                            //mostrarAutoresPorAño();
                            System.out.println("4");
                            break;
                        case 5:
                            //mostarLibrosPorIdioma();
                            System.out.println("5");
                            break;
                    }
                    while (true) {
                        System.out.println(preguntaContinuar);
                        continuar = sc.nextLine().toUpperCase();
                        if (continuar.equals("Y") || continuar.equals("N")) {
                            break;
                        } else {
                            System.out.println("Opcion invalida. Por favor solo ingrese [Y/N]");
                        }
                    }
                } else if (opcion == 0) {
                    continuar = "N";
                } else {
                    System.out.println("Opcion no Valida, Por favor ingrese una de las opciones permitidas.");
                    continuar = "Y";
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Por favor ingrese solamente númerosl.");
                sc.nextLine();
                continuar = "Y";
            }
        } while (continuar.equalsIgnoreCase("Y"));
        System.out.println("Cerrando el programa. ¡Gracias por usar nuestros servicios!");
        System.exit(0);
    }


    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el título del libro que desea buscar:");
        String busqueda = sc.nextLine();

        Libro resultadoBusqueda = libroService.buscarLibroPorTitulo(busqueda);

        if (resultadoBusqueda == null) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("Resultado encontrado:");
            System.out.println("------------------------------------------");
            System.out.println("Título: " + resultadoBusqueda.getTitulo());
            for (Autor aut : resultadoBusqueda.getAutores()) {
                System.out.print("Autor: " + aut.getNombrePersona());
            }
            System.out.println();
            System.out.println("Idiomas: " + String.join(", ", resultadoBusqueda.getIdiomas()));
            System.out.println("Número de descargas: " + resultadoBusqueda.getNumeroDeDescargas());
            System.out.println("------------------------------------------");
        }
    }

    private void listarLibrosRegistrados() {
        System.out.println("Cargando libros registrados en la base de datos...");
        List<Libro> libros = libroService.obtenerTodosLosLibros();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("------------------ Libros Registrados ------------------");
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autores: " + obtenerNombresDeAutores(libro.getAutores()));
                System.out.println("Idiomas: " + String.join(", ", libro.getIdiomas()));
                System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());
                System.out.println("-----------------------------------------------------");
            }
        }
    }


    private String obtenerNombresDeAutores(List<Autor> autores) {
        if (autores == null || autores.isEmpty()) {
            return "Desconocido";
        }
        return autores.stream()
                .map(Autor::getNombrePersona)
                .collect(Collectors.joining(", "));
    }
    private void listarAutoresRegistrados(){
        System.out.println("Cargando autores registrados en la base de datos...");
        List<Autor> autores = libroService.obtenerTodosLosAutores();

        if (autores.isEmpty()){
            System.out.println("No hay autores registrados en nuestra base de datos.");
        }else {
            System.out.println("------------------ Autores Registrados ------------------");
            for (Autor autor : autores){
                System.out.println("Nombre Autor: " + autor.getNombrePersona());
                System.out.println("Fecha de Nacimiento: " + autor.getAnioNacimiento());
                System.out.println("Fecha de Fallecimiento: " + (autor.getAnioFallecimiento() != null ? autor.getAnioFallecimiento() : "El autor sigue vivo."));
                System.out.println("-----------------------------------------------------");
            }
        }

    }
}