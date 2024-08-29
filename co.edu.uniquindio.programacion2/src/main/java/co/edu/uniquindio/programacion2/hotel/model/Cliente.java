package co.edu.uniquindio.programacion2.hotel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private String nombre;
    private String DNI;
    private List<Reserva> reservas;

    public Cliente (String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.reservas = new ArrayList<Reserva>();
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    public List<Reserva> obtenerReservasPorTipo(TipoHabitacion tipoHabitacion) {
        List<Reserva> reservasPorTipo = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getTipoHabitacion() == tipoHabitacion) {
                reservasPorTipo.add(reserva);
            }
        }
        return reservasPorTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
