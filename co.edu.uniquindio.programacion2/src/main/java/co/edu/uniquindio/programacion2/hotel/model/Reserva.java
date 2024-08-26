package co.edu.uniquindio.programacion2.hotel.model;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva (Cliente cliente, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public long calcularDuracion() {
         return ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
    }

    public double calcularCostoTotal() {
        double costoHabitacion = habitacion.getPrecio();
        double costoServicios = 0.0;

        for (Servicio servicio : habitacion.obtenerServicios()) {
            costoServicios += servicio.getPrecio();
        }

        return (costoHabitacion * calcularDuracion()) + costoServicios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
