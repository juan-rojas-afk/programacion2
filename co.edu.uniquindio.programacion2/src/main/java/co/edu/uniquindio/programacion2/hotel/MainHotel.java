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
                    ClienteManager.agregarCliente(hotel, scanner);
                    break;
                case 2:
                    HabitacionManager.agregarHabitacion(hotel, scanner);
                    break;
                case 3:
                    ServicioManager.agregarServicio(hotel, scanner);
                    break;
                case 4:
                    ReservaManager.realizarReserva(hotel, scanner);
                    break;
                case 5:
                    ClienteManager.mostrarDatosCliente(hotel, scanner);
                    break;
                case 6:
                    Mostrardatos.mostrarDatos(hotel);
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



    private static Hotel inicializarDatos() {
        return new Hotel();
    }
}