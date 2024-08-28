package co.edu.uniquindio.programacion2.hotel.model;

import co.edu.uniquindio.programacion2.hotel.service.IConsumible;

public class ServicioSpa extends Servicio implements IConsumible {
    public ServicioSpa (String nombre, double precio) {
        super(nombre, precio);
    }

    public ServicioSpa() {
        super();
    }

    @Override
    public void consumir() {
        System.out.println("Disfrutando del servicio de Spa: " + getNombre());
    }
}
