package proyecto_estadistica;

import Controlador.ControladorNoAgrupados;
import Vista.VistaNoAgrupados;
import modelo.ModeloNoAgrupados;

public class Proyecto_Estadistica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaNoAgrupados vista = new VistaNoAgrupados();
        ModeloNoAgrupados modelo = new ModeloNoAgrupados();

        new ControladorNoAgrupados(vista, modelo);

        vista.setVisible(true);
    }
}
