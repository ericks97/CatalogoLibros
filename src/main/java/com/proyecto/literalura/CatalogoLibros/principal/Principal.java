package com.proyecto.literalura.CatalogoLibros.principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private int opcion;
    private String continuar;
    private String menu = """
            Elija la opción que necesita:
            1) Buscar libro por título
            2) Mostar mis libros
            3) Mostrar mis autores
            4) Listar Autores vivos en un determinado año
            5) Mostrar Libros por Idioma
            0) Salir
            """;
    private String preguntaContinuar= "¿Desea ver más libros[Y/N]?";

    public void showMenu() {
        do {
            System.out.println(menu);
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion >= 1 && opcion <= 5) {
                    switch (opcion) {
                        case 1:
                            //buscarLibro();
                            System.out.println("1");
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
}