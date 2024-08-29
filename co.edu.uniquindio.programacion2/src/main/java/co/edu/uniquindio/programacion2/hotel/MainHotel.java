package co.edu.uniquindio.programacion2.hotel;

import co.edu.uniquindio.programacion2.hotel.model.*;
import co.edu.uniquindio.programacion2.hotel.service.*;

import java.time.LocalDate;
import java.util.Scanner;

public class MainHotel {
    private static Hotel hotel;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        hotel = inicializarDatos();
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    agregarHabitacion();
                    break;
                case 3:
                    agregarServicio();
                    break;
                case 4:
                    realizarReserva();
                    break;
                case 5:
                    mostrarDatosCliente();
                    break;
                case 6:
                    mostrarDatos();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú del Hotel ---");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Agregar Habitación");
        System.out.println("3. Agregar Servicio");
        System.out.println("4. Realizar Reserva");
        System.out.println("5. Mostrar Datos de un Cliente");
        System.out.println("6. Mostrar Todos los Datos");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, dni);
        hotel.agregarCliente(cliente);
        System.out.println("Cliente agregado con éxito.");
    }

    private static void agregarHabitacion() {
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

    private static void agregarServicio() {
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

    private static void realizarReserva() {
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

    private static void mostrarDatosCliente() {
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

    private static void mostrarDatos() {
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


    private static Hotel inicializarDatos() {
        return new Hotel();
    }
}