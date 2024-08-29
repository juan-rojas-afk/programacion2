package co.edu.uniquindio.programacion2.hotel.service;

import co.edu.uniquindio.programacion2.hotel.model.Habitacion;
import co.edu.uniquindio.programacion2.hotel.model.Hotel;
import co.edu.uniquindio.programacion2.hotel.model.TipoHabitacion;

import java.util.Scanner;

public class HabitacionManager {

    public static void agregarHabitacion(Hotel hotel ,Scanner scanner) {
        System.out.print("Ingrese el número de habitación: ");
        String numeroHabitacion = scanner.nextLine();
        System.out.print("Ingrese el tipo de habitación (SIMPLE, DOUBLE, SUITE): ");
        TipoHabitacion tipoHabitacion = TipoHabitacion.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Ingrese el precio por noche: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        Habitacion habitacion = new Habitacion(numeroHabitacion, tipoHabitacion, precio);
        hotel.agregarHabitacion(habitacion);
        System.out.println("Habitación agregada con éxito.");
    }
}
