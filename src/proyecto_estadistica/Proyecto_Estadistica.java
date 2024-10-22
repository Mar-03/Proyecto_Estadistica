package proyecto_estadistica;

import Controlador.ControladorInicio;
import Controlador.ControladorNoAgrupados;
import Modelo.ModeloInicio;
import Vista.VistaInicio;
import Vista.VistaNoAgrupados;
import modelo.ModeloNoAgrupados;

public class Proyecto_Estadistica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        VistaInicio vistaInicio = new VistaInicio();
        ControladorInicio controller = new ControladorInicio(vistaInicio);
        vistaInicio.setVisible(true);
    
        
//        VistaNoAgrupados vista = new VistaNoAgrupados();
//        ModeloNoAgrupados modelo = new ModeloNoAgrupados();
//
//        new ControladorNoAgrupados(vista, modelo);
//
//        vista.setVisible(true);
    }
}


