package Controladores;

import Vista.VistaNoAgrupados;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelos.ModeloNoAgrupados;

public class ControladorNoAgrupados {

    public VistaNoAgrupados vista;
    public ModeloNoAgrupados modelo;

    public ControladorNoAgrupados(VistaNoAgrupados vista, ModeloNoAgrupados modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnCalcular.addActionListener(e -> calcular());
        this.vista.btnLimpiar.addActionListener((e) -> limpiar());
        this.vista.btnImprimir.addActionListener(e -> imprimirPDF());
    }

    //BOTÓN CALCULAR
    public void calcular() {

        try {

            String[] datosTexto = vista.txtDato.getText().split(", ");
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
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(vista, "No puede estar ningun campo vacio ni agregar letras solo numeros");
        }
    }

    //BOTÓN IMPRIMIR
    public void imprimirPDF() {
        
        try {
            
            String destino = "Solucion_Datos_No_Agrupados.pdf";
            modelo.descargarPDF(vista.tblNoAgrupados, destino, vista.txtDato);

        } catch (Exception ex) {
            ex.printStackTrace();
            
            JOptionPane.showMessageDialog(vista, "Error al crear el PDF: " + ex.getMessage());
        }
    }

    //BOTÓN LIMPIAR
    public void limpiar() {
        
        vista.limpiarTablaResultados();
        vista.txtDato.setText("");
    }
}
