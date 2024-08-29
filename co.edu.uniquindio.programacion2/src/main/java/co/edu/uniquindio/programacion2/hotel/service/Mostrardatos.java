package co.edu.uniquindio.programacion2.hotel.service;

import co.edu.uniquindio.programacion2.hotel.model.*;


public class Mostrardatos {

    public static void mostrarDatos(Hotel hotel) {
        System.out.println("\n--- Datos del Hotel ---");
        System.out.println("Clientes:");
        for (Cliente cliente : hotel.getListaClientes()) {
            System.out.println("- " + cliente.getNombre() + " (DNI: " + cliente.getDNI() + ")");
        }

        System.out.println("\nHabitaciones:");
        for (Habitacion habitacion : hotel.getListaHabitaciones()) {
            System.out.println("- " + habitacion.getNumeroHabitacion() + " (" + habitacion.getTipoHabitacion() + ") - Precio: $" + habitacion.getPrecio());
        }

        System.out.println("\nServicios:");
        for (Servicio servicio : hotel.getListaServicios()) {
            System.out.println("- " + servicio.getNombre() + " - Precio: $" + servicio.getPrecio());
        }

        System.out.println("\nReservas:");
        for (Reserva reserva : hotel.getListaReservas()) {
            System.out.println("- Cliente: " + reserva.getCliente().getNombre());
            System.out.println("  Habitación: " + reserva.getHabitacion().getNumeroHabitacion());
            System.out.println("  Fecha de entrada: " + reserva.getFechaEntrada());
            System.out.println("  Fecha de salida: " + reserva.getFechaSalida());
            System.out.println("  Costo total: $" + reserva.calcularCostoTotal());
        }
    }
}
