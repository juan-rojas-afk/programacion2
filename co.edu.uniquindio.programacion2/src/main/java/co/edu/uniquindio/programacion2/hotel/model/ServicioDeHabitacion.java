package co.edu.uniquindio.programacion2.hotel.model;

import co.edu.uniquindio.programacion2.hotel.service.IConsumible;

public class ServicioDeHabitacion extends Servicio implements IConsumible {
    private String descripcion;

    public ServicioDeHabitacion(String nombre, double precio, String descripcion) {
        super(nombre, precio);
        this.descripcion = descripcion;
    }

    @Override
    public void consumir() {
        System.out.println("Consumiendo servicio en la habitación" + descripcion);
    }

}
