package co.edu.uniquindio.programacion2.hotel.model;

import co.edu.uniquindio.programacion2.hotel.service.IConsumible;

public class ServicioRestaurante extends Servicio implements IConsumible {
    public ServicioRestaurante (String nombre, double precio) {
        super(nombre, precio);
    }

    public ServicioRestaurante() {
    }

    @Override
    public void consumir() {
        System.out.println("Disfrutando del servicio de Restaurante" + getNombre());
    }
}
