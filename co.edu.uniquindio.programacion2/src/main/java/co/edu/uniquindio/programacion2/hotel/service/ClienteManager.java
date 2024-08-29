package co.edu.uniquindio.programacion2.hotel.service;

import co.edu.uniquindio.programacion2.hotel.model.Cliente;
import co.edu.uniquindio.programacion2.hotel.model.Hotel;
import co.edu.uniquindio.programacion2.hotel.model.Reserva;
import co.edu.uniquindio.programacion2.hotel.model.Servicio;

import java.util.Scanner;

public class ClienteManager {

    public static void agregarCliente(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, dni);
        hotel.agregarCliente(cliente);
        System.out.println("Cliente agregado con éxito.");
    }

    public static void mostrarDatosCliente(Hotel hotel, Scanner scanner) {
        System.out.println("Clientes disponibles:");
        for (int i = 0; i < hotel.getListaClientes().size(); i++) {
            System.out.println((i + 1) + ". " + hotel.getListaClientes().get(i).getNombre());
        }
        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        if (clienteIndex >= 0 && clienteIndex < hotel.getListaClientes().size()) {
            Cliente cliente = hotel.getListaClientes().get(clienteIndex);
            System.out.println("\n--- Datos del Cliente ---");
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("DNI: " + cliente.getDNI());
            System.out.println("Reservas:");
            for (Reserva reserva : cliente.obtenerReservas()) {
                System.out.println("- Habitación: " + reserva.getHabitacion().getNumeroHabitacion());
                System.out.println("  Fecha de entrada: " + reserva.getFechaEntrada());
                System.out.println("  Fecha de salida: " + reserva.getFechaSalida());
                System.out.println("  Servicios:");
                for (Servicio servicio : reserva.getHabitacion().obtenerServicios()) {
                    System.out.println("    * " + servicio.getNombre() + " - Precio: $" + servicio.getPrecio());
                }
                System.out.println("  Costo total: $" + reserva.calcularCostoTotal());
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}
