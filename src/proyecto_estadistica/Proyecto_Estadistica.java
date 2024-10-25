package proyecto_estadistica;

import Controladores.ControladorInicio;
import Vista.VistaInicio;

public class Proyecto_Estadistica {

    public static void main(String[] args) {

        VistaInicio vistaInicio = new VistaInicio();
        ControladorInicio controller = new ControladorInicio(vistaInicio);
        vistaInicio.setVisible(true);
    }
}
