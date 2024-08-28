package co.edu.uniquindio.programacion2.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String nombre;

    private List<Cliente> listaClientes;
    private List<Habitacion> listaHabitaciones;
    private List<Reserva> ListaDeReservas;
    private List<Servicio> ListaDeServicios;

    public Hotel() {
        this.listaClientes = new ArrayList<>();
        this.listaHabitaciones = new ArrayList<>();
        this.ListaDeServicios = new ArrayList<>();
        this.ListaDeReservas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void agregarHabitacion(Habitacion habitacion) {
        listaHabitaciones.add(habitacion);
    }

    public void agregarReserva(Reserva reserva) {
        ListaDeReservas.add(reserva);
    }

    public void agregarServico(Servicio servicio) {
        ListaDeServicios.add(servicio);
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

    public List<Reserva> getListaReservas() {
        return ListaDeReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        ListaDeReservas = listaReservas;
    }

    public List<Servicio> getListaServicios() {
        return ListaDeServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        ListaDeServicios = listaServicios;
    }
}
