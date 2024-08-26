package co.edu.uniquindio.programacion2.hotel;

import co.edu.uniquindio.programacion2.hotel.model.*;
import co.edu.uniquindio.programacion2.hotel.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainHotel {
    public static void main(String[] args) {
        // Inicializar los datos
        List<Cliente> clientes = inicializarDatos();

        // Imprimir los datos
        imprimirDatos(clientes);
    }

    private static List<Cliente> inicializarDatos() {
        List<Cliente> clientes = new ArrayList<>();

        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Perez", "12345678A");
        Cliente cliente2 = new Cliente("Maria Lopez", "87654321B");

        // Crear habitaciones
        Habitacion habitacion1 = new Habitacion("101", TipoHabitacion.SIMPLE, 50.0);
        Habitacion habitacion2 = new Habitacion("102", TipoHabitacion.DOUBLE, 80.0);
        Habitacion habitacion3 = new Habitacion("103", TipoHabitacion.SUITE, 120.0);

        // Crear servicios
        ServicioSpa servicioSpa = new ServicioSpa("Spa Relax", 30.0);
        ServicioRestaurante servicioRestaurante = new ServicioRestaurante("Cena Gourmet", 50.0);
        ServicioLimpieza servicioLimpieza = new ServicioLimpieza("Limpieza Diaria", 20.0);
        ServicioBar servicioBar = new ServicioBar("Bar Nocturno", 40.0);
        ServicioDeHabitacion servicioHabitacion = new ServicioDeHabitacion("Desayuno en la habitación", 15.0, " - Desayuno");

        // Asignar servicios a habitaciones
        habitacion1.agregarServicio(servicioSpa);
        habitacion2.agregarServicio(servicioRestaurante);
        habitacion3.agregarServicio(servicioLimpieza);
        habitacion3.agregarServicio(servicioBar);
        habitacion3.agregarServicio(servicioHabitacion);

        // Crear reservas
        Reserva reserva1 = new Reserva(cliente1, habitacion1, LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 3));
        Reserva reserva2 = new Reserva(cliente2, habitacion2, LocalDate.of(2024, 8, 4), LocalDate.of(2024, 8, 6));
        Reserva reserva3 = new Reserva(cliente1, habitacion3, LocalDate.of(2024, 8, 7), LocalDate.of(2024, 8, 10));

        // Agregar reservas a clientes
        cliente1.agregarReserva(reserva1);
        cliente1.agregarReserva(reserva3);
        cliente2.agregarReserva(reserva2);

        // Agregar clientes a la lista
        clientes.add(cliente1);
        clientes.add(cliente2);

        return clientes;
    }

    private static void imprimirDatos(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre()); // Imprimir el nombre del cliente

            for (Reserva reserva : cliente.obtenerReservas()) {
                System.out.println("  Reserva:");
                System.out.println("    Habitacion: " + reserva.getHabitacion().getNumeroHabitacion());
                System.out.println("    Tipo: " + reserva.getHabitacion().getTipoHabitacion());
                System.out.println("    Precio por noche: " + reserva.getHabitacion().getPrecio());
                System.out.println("    Fecha de entrada: " + reserva.getFechaEntrada());
                System.out.println("    Fecha de salida: " + reserva.getFechaSalida());
                System.out.println("    Duracion de estadia:  " + reserva.calcularDuracion());

                System.out.println("    Servicios:");
                for (Servicio servicio : reserva.getHabitacion().obtenerServicios()) {
                    System.out.println("      " + servicio.getNombre() + " - Precio: " + servicio.getPrecio());
                }

                System.out.println("    Costo total: " + reserva.calcularCostoTotal());
            }
        }
    }
}