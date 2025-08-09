package com.proyecto.literalura.CatalogoLibros.principal;

import com.proyecto.literalura.CatalogoLibros.model.Autor;
import com.proyecto.literalura.CatalogoLibros.service.LibroService;
import com.proyecto.literalura.CatalogoLibros.model.Libro;

import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
                            //mostarMisLibros();
                            System.out.println("2");
                            break;
                        case 3:
                            //mostrarMisAutores();
                            System.out.println("3");
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
    }


    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el título del libro que desea buscar:");
        String busqueda = sc.nextLine();

        List<Libro> resultadoBusqueda = libroService.buscarLibroPorTitulo(busqueda);

        if (resultadoBusqueda.isEmpty()) {
            System.out.println("No se encontraron libro con ese título.");
        } else {
            System.out.println("Resultados encontrados:");
            for (Libro libro : resultadoBusqueda) {
                System.out.println("------------------------------------------");
                System.out.println("Título: " + libro.getTitulo());
                for (Autor aut : libro.getAutores()) {
                    System.out.print("Autor: " + aut.getNombrePersona());
                }
                System.out.println();
                System.out.println("Idiomas: " + String.join(", ", libro.getIdiomas()));
                System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());
                System.out.println("------------------------------------------");
            }
        }
    }
}