package co.edu.uniquindio.programacion2.hotel.model;

public abstract class Servicio {
    private String nombre;
    private double precio;

    public Servicio (String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
