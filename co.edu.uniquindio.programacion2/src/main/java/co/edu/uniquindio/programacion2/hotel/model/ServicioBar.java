package co.edu.uniquindio.programacion2.hotel.model;

import co.edu.uniquindio.programacion2.hotel.service.IConsumible;

public class ServicioBar extends Servicio implements IConsumible {
    public ServicioBar(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void consumir() {
        System.out.println("Disfutrando del servicio de Bar" + getNombre());
    }
}
