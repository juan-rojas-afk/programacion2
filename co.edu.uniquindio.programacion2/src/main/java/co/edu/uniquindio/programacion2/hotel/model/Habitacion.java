package co.edu.uniquindio.programacion2.hotel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Habitacion {
    private String numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private double precio;
    public List<Servicio> servicios;

    public Habitacion(String numeroHabitacion, TipoHabitacion tipoHabitacion, double precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.servicios = new ArrayList<>();
    }

    public Habitacion() {
    }

    public void agregarServicio (Servicio servicio) {
        this.servicios.add(servicio);
    }

    public List<Servicio> obtenerServicios() {
        return servicios;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public List<Servicio> getServicios() {
        return Collections.unmodifiableList(servicios);
    }

    public void setServicios() {
        this.servicios = servicios;
    }
}
