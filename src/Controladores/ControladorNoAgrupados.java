
package Controladores;

import Vista.VistaNoAgrupados;
import java.util.ArrayList;
import java.util.List;
import modelos.ModeloNoAgrupados;

public class ControladorNoAgrupados {
    public VistaNoAgrupados vista;
    public ModeloNoAgrupados modelo;

    public ControladorNoAgrupados(VistaNoAgrupados vista, ModeloNoAgrupados modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnCalcular.addActionListener(e -> calcular());
        this.vista.btnLimpiar.addActionListener(e -> limpiar());
    }
    

    public void calcular() {
        String[] datosTexto = vista.txtDato.getText().split(",");
        double[] datos = new double[datosTexto.length];
        for (int i = 0; i < datosTexto.length; i++) {
            datos[i] = Double.parseDouble(datosTexto[i]);
        }
        modelo.setDatos(datos);

        double rango = modelo.CalcularRango();
        double desviacionTipica = modelo.CalculoDesviacionTipica();
        double desviacionMedia = modelo.CalculoDesviacionMedias();

        vista.tblNoAgrupados.setValueAt(rango, 0, 0);
         vista.tblNoAgrupados.setValueAt(desviacionMedia, 0, 1);
        vista.tblNoAgrupados.setValueAt(desviacionTipica, 0, 2);
      
    }

    public void limpiar() {
        vista.limpiarCampos();
        vista.txtDato.setText("");
    }
}


