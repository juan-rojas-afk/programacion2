package co.edu.uniquindio.programacion2.hotel.service;

import co.edu.uniquindio.programacion2.hotel.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservaManager {

    public static void realizarReserva(Hotel hotel, Scanner scanner) {
        System.out.println("Clientes disponibles:");
        for (int i = 0; i < hotel.getListaClientes().size(); i++) {
            System.out.println((i + 1) + ". " + hotel.getListaClientes().get(i).getNombre());
        }
        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Cliente cliente = hotel.getListaClientes().get(clienteIndex);

        System.out.println("Habitaciones disponibles:");
        for (int i = 0; i < hotel.getListaHabitaciones().size(); i++) {
            Habitacion hab = hotel.getListaHabitaciones().get(i);
            System.out.println((i + 1) + ". " + hab.getNumeroHabitacion() + " - " + hab.getTipoHabitacion());
        }
        System.out.print("Seleccione el número de la habitación: ");
        int habitacionIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Habitacion habitacion = hotel.getListaHabitaciones().get(habitacionIndex);

        System.out.print("Ingrese la fecha de entrada (YYYY-MM-DD): ");
        LocalDate fechaEntrada = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese la fecha de salida (YYYY-MM-DD): ");
        LocalDate fechaSalida = LocalDate.parse(scanner.nextLine());

        Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, fechaSalida);

        // Aqui intento agregar un servicio la reserva
        boolean agregarMasServicios = true;
        while (agregarMasServicios) {
            System.out.println("Servicios disponibles:");
            for (int i = 0; i < hotel.getListaServicios().size(); i++) {
                System.out.println((i + 1) + ". " + hotel.getListaServicios().get(i).getNombre());
            }
            System.out.print("Seleccione el número del servicio (0 para terminar): ");
            int servicioIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir el salto de línea

            if (servicioIndex >= 0 && servicioIndex < hotel.getListaServicios().size()) {
                Servicio servicio = hotel.getListaServicios().get(servicioIndex);
                habitacion.agregarServicio(servicio);
                System.out.println("Servicio agregado a la reserva.");
            } else if (servicioIndex == -1) {
                agregarMasServicios = false;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        hotel.agregarReserva(reserva);
        cliente.agregarReserva(reserva);
        System.out.println("Reserva realizada con éxito.");
    }
}
