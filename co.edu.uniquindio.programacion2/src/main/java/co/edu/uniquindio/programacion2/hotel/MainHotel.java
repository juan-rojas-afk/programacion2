package co.edu.uniquindio.programacion2.hotel;

import co.edu.uniquindio.programacion2.hotel.model.*;
import co.edu.uniquindio.programacion2.hotel.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainHotel {
    public static void main(String[] args) {
        Hotel hotel = InicializarDatos();
    }

    private static Hotel InicializarDatos() {
        Hotel hotel = new Hotel();

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Perez");
        cliente1.setDNI("12345678A");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Maria Lopez");
        cliente2.setDNI("87654321B");

        Habitacion habitacion1 = new Habitacion();
        habitacion1.setNumeroHabitacion("101");
        habitacion1.setTipoHabitacion(TipoHabitacion.SIMPLE);
        habitacion1.setPrecio(50.0);

        Habitacion habitacion2 = new Habitacion();
        habitacion2.setNumeroHabitacion("102");
        habitacion2.setTipoHabitacion(TipoHabitacion.DOUBLE);
        habitacion2.setPrecio(80.0);

        Habitacion habitacion3 = new Habitacion();
        habitacion3.setNumeroHabitacion("103");
        habitacion3.setTipoHabitacion(TipoHabitacion.SUITE);
        habitacion3.setPrecio(120.0);

        ServicioSpa servicioSpa1= new ServicioSpa();
        servicioSpa1.setNombre("Spa Relax");
        servicioSpa1.setPrecio(30.0);

        ServicioRestaurante servicioRestaurante1 = new ServicioRestaurante();
        servicioRestaurante1.setNombre("Cena Gourmet");
        servicioRestaurante1.setPrecio(50.0);

        ServicioLimpieza servicioLimpieza1 = new ServicioLimpieza();
        servicioLimpieza1.setNombre("Limpieza Diaria");
        servicioLimpieza1.setPrecio(20.0);

        ServicioBar servicioBar1 = new ServicioBar();
        servicioBar1.setNombre("Bar nocturno");
        servicioBar1.setPrecio(40.0);

        ServicioDeHabitacion servicioDeHabitacion1 = new ServicioDeHabitacion();
        servicioDeHabitacion1.setNombre("Desayuno a la habitación");
        servicioDeHabitacion1.setPrecio(15.0);

        habitacion1.agregarServicio(servicioBar1);

        habitacion1.getServicios().add(servicioSpa1);
        habitacion2.getServicios().add(servicioRestaurante1);
        habitacion3.getServicios().add(servicioLimpieza1);
        habitacion3.getServicios().add(servicioBar1);
        habitacion3.getServicios().add(servicioDeHabitacion1);

        Reserva reserva1 = new Reserva(cliente1, habitacion1, LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 3));
        Reserva reserva2 = new Reserva(cliente2, habitacion2, LocalDate.of(2024, 8, 4), LocalDate.of(2024, 8, 6));
        Reserva reserva3 = new Reserva(cliente1, habitacion3, LocalDate.of(2024, 8, 7), LocalDate.of(2024, 8, 10));

        cliente1.agregarReserva(reserva1);
        cliente1.agregarReserva(reserva3);
        cliente2.agregarReserva(reserva2);

        hotel.getListaClientes().add(cliente1);
        hotel.getListaClientes().add(cliente2);

        hotel.getListaHabitaciones().add(habitacion1);
        hotel.getListaHabitaciones().add(habitacion2);
        hotel.getListaHabitaciones().add(habitacion3);

        hotel.getListaServicios().add(servicioSpa1);
        hotel.getListaServicios().add(servicioRestaurante1);
        hotel.getListaServicios().add(servicioLimpieza1);
        hotel.getListaServicios().add(servicioBar1);
        hotel.getListaServicios().add(servicioDeHabitacion1);

        hotel.getListaReservas().add(reserva1);
        hotel.getListaReservas().add(reserva2);
        hotel.getListaReservas().add(reserva3);

        return hotel;
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