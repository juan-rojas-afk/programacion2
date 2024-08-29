package co.edu.uniquindio.programacion2.hotel.service;

import co.edu.uniquindio.programacion2.hotel.model.*;

import java.util.Scanner;

public class ServicioManager {

    public static void agregarServicio(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el nombre del servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del servicio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Seleccione el tipo de servicio:");
        System.out.println("1. Servicio de Spa");
        System.out.println("2. Servicio de Restaurante");
        System.out.println("3. Servicio de Limpieza");
        System.out.println("4. Servicio de Bar");
        System.out.println("5. Servicio de Habitación");
        System.out.print("Ingrese el número correspondiente: ");
        int tipoServicio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Servicio servicio;
        switch (tipoServicio) {
            case 1:
                servicio = new ServicioSpa(nombre, precio);
                break;
            case 2:
                servicio = new ServicioRestaurante(nombre, precio);
                break;
            case 3:
                servicio = new ServicioLimpieza(nombre, precio);
                break;
            case 4:
                servicio = new ServicioBar(nombre, precio);
                break;
            case 5:
                System.out.print("Ingrese la descripción del servicio de habitación: ");
                String descripcion = scanner.nextLine();
                servicio = new ServicioDeHabitacion(nombre, precio, descripcion);
                break;
            default:
                System.out.println("Opción no válida. Se creará un servicio genérico.");
                servicio = new Servicio(nombre, precio) {};
        }

        hotel.agregarServico(servicio);
        System.out.println("Servicio agregado con éxito.");
    }
}
