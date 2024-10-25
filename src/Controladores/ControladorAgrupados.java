package Controladores;

import Vista.VistaAgrupados;
import Vista.VistaInicio;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.Arrays;
import java.util.List;
import modelos.ModeloAgrupados;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorAgrupados {
    private VistaAgrupados vista;
    private ModeloAgrupados modelo;

    public ControladorAgrupados(VistaAgrupados vista, ModeloAgrupados modelo) {
        this.vista = vista;
        this.modelo = modelo;
      this.vista.btnCalcularAgrupados.addActionListener(e -> calcularNoAgrupados());
        this.vista.btnLimpiarAgrupados.addActionListener(e ->limpiar());
        
    }

    public void calcularNoAgrupados() {
       
    try {
        
        double[] superiores = parsearLimites(vista.txtLimSuperiores.getText());
        
        double[] inferiores = parsearLimites(vista.txtLimInferiores.getText());
        int[] frecuencias = parsearFrecuencias(vista.txtFrecuencias.getText());

        
        if (superiores.length != inferiores.length || superiores.length != frecuencias.length) {
            return;
        }

        
        modelo.setDatos(superiores, inferiores, frecuencias);

        
        double media = modelo.calcularMedia();
        double desviacionMedia = modelo.calcularDesviacionMedia();
        double desviacionTipica = modelo.calcularDesviacionTipica();
        double varianza = modelo.calcularVarianza();
        List<Double> marcasDeClase = modelo.calcularMarcasDeClase();
      
       
     

        
       for (int i = 0; i < marcasDeClase.size(); i++) {
            double fPorX = frecuencias[i] * marcasDeClase.get(i);
            double xMenosMedia = Math.abs(marcasDeClase.get(i) - media);
            double xMenosMediaCuadrado = Math.pow(xMenosMedia, 2);
            double fPorXMenosMedia = frecuencias[i] * xMenosMedia;
            double fPorXMenosMediaCuadrado = frecuencias[i] * xMenosMediaCuadrado;
            String rango = String.format("%.1f - %.1f", inferiores[i], superiores[i]);
            
            vista.tblAgrupados.setValueAt(rango, i, 0);
            vista.tblAgrupados.setValueAt(frecuencias[i], i, 1);
            vista.tblAgrupados.setValueAt(marcasDeClase.get(i), i, 2);
            vista.tblAgrupados.setValueAt(fPorX, i, 3);
            vista.tblAgrupados.setValueAt(xMenosMedia, i, 4);
            vista.tblAgrupados.setValueAt(xMenosMediaCuadrado, i, 5);
            vista.tblAgrupados.setValueAt(fPorXMenosMedia, i, 6);
            vista.tblAgrupados.setValueAt(fPorXMenosMediaCuadrado, i, 7);
        }

        
        vista.lblDesviacionMedia.setText(String.format("%.2f", desviacionMedia));
        vista.lblDesviacionTipica.setText(String.format("%.2f", desviacionTipica));
        vista.lblVarianza.setText(String.format("%.2f", varianza));
        vista.lblPromedio.setText(String.format("%.2f", media));

    } catch (Exception ex) {
        
       
    }
}


   public void limpiar() {
       
        limpiarTablaResultados();
    }

   public void limpiarTablaResultados() {
        int rowCount = vista.tblAgrupados.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < vista.tblAgrupados.getColumnCount(); j++) {
                vista.tblAgrupados.setValueAt(null, i, j);
            }
        }
    }

    public double[] parsearLimites(String texto) {
        return Arrays.stream(texto.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }

   public int[] parsearFrecuencias(String texto) {
        return Arrays.stream(texto.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
