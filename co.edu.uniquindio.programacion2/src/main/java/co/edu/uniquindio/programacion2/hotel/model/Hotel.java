package co.edu.uniquindio.programacion2.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String nombre;

    private List<Cliente> listaClientes;
    private List<Habitacion> listaHabitaciones;

    public Hotel() {
        this.listaClientes = new ArrayList<>();
        this.listaHabitaciones = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void agregarHabitacion(Habitacion habitacion) {
        listaHabitaciones.add(habitacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
}
