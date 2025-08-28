/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaproducto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sistemas3
 */
public class PruebaProducto {

    private static final List<Producto> productos = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    
        System.out.println("=======================================");
        System.out.println("                Tienda ");
        System.out.println("=======================================\n");

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige la opcion: ");
            switch (opcion) {

                case 1 -> agregarProducto();
                case 2 -> eliminarProducto();
                case 3 -> listarProductos();
                case 0 -> System.out.println("Finalizar");
                default -> System.out.println("Opción no válida.");
            }

            System.out.println();
        } while (opcion != 4);
       
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Lista de Productos");
        System.out.println("0. Salir");
    }
    private static void agregarProducto() {
        System.out.println("\n--- Agregar Nuevo Producto ---");
        int id = leerEntero("Ingrese el ID del producto: ");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        BigDecimal precio;
        while (true) {
            try {
                System.out.print("Ingrese el precio del producto: ");
                precio = sc.nextBigDecimal();
                sc.nextLine(); // Consumir el salto de línea
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Precio no valido. ");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        }

        Producto nuevoProducto = new Producto(id, nombre, precio);
        productos.add(nuevoProducto);
        System.out.println("Producto agregado.");
    }

    private static void eliminarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para eliminar.");
            return;
        }

        System.out.println("\n--- Eliminar Producto ---");
        int idEliminar = leerEntero("Ingrese el ID: ");

        boolean eliminado = productos.removeIf(p -> p.getId() == idEliminar);

        if (eliminado) {
            System.out.println("Producto con ID " + idEliminar + " eliminado con éxito.");
        } else {
            System.out.println("No se encontro ningun producto con ese ID " + idEliminar + ".");
        }
    }
     private static void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos almacenados.");
        } else {
            productos.forEach(System.out::println);
        }
        System.out.println("--------------------------");
    }
    private static int leerEntero(String opcion) {
        while (true) {
            System.out.print(opcion);
            String s = sc.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido. Intenta de nuevo.");
            }
        }
    }
    
}
