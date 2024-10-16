/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estadistica;

import Controlador.ControladorNoAgrupados;
import Vista.VistaNoAgrupados;
import modelo.ModeloNoAgrupados;

/**
 *
 * @author Cindy Ruano
 */
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
