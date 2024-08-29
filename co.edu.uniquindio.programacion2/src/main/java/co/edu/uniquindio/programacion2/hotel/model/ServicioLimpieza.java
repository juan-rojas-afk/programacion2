    package co.edu.uniquindio.programacion2.hotel.model;

    import co.edu.uniquindio.programacion2.hotel.service.IConsumible;

    public class ServicioLimpieza extends Servicio implements IConsumible {
        public ServicioLimpieza(String nombre, double precio) {
            super(nombre, precio);
        }

        public ServicioLimpieza() {
        }

        @Override
        public void consumir() {
            System.out.println("Utilizando el servicio de Limpieza: " + getNombre());
        }
    }
