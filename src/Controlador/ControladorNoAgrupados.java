package Controlador;

import Vista.VistaNoAgrupados;
import modelo.ModeloNoAgrupados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControladorNoAgrupados {

    private VistaNoAgrupados vista;
    private ModeloNoAgrupados modelo;

    public ControladorNoAgrupados(VistaNoAgrupados vista, ModeloNoAgrupados modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addCalcularListener(new CalcularListener());
        this.vista.addLimpiarListener(new LimpiarListener());
        this.vista.addImprimirListener(new ImprimirListener());
    }

    // Listener para el botón "Calcular"
    class CalcularListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calcularEstadisticas();
        }
    }

    // Listener para el botón "Limpiar"
    class LimpiarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.limpiarCampos();
        }
    }

    // Listener para el botón "Imprimir"
    class ImprimirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    // Método para calcular las estadísticas
    private void calcularEstadisticas() {
        try {
            // Obtener los datos de entrada desde la vista
            String datosEntrada = vista.getDatos();
            String[] strDatos = datosEntrada.split(",");

            // Convertir los datos de String a double
            double[] datos = new double[strDatos.length];
            for (int i = 0; i < strDatos.length; i++) {
                datos[i] = Double.parseDouble(strDatos[i].trim());
            }

            // Calcular las estadísticas usando el modelo
            double mediaAritmetica = modelo.calcularMedia(datos);
            double mediana = modelo.calcularMediana(datos);
            double moda = modelo.calcularModa(datos);
            double[] ponderaciones = new double[datos.length];
            Arrays.fill(ponderaciones, 1);
            double mediaPonderada = modelo.calcularMediaPonderada(datos, ponderaciones);

            // Mostrar los resultados en la tabla en la vista
            vista.setMediaAritmetica(String.valueOf(mediaAritmetica));
            vista.setMediaPonderada(String.valueOf(mediaPonderada));
            vista.setMediana(String.valueOf(mediana));
            vista.setModa(String.valueOf(moda));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor ingrese números válidos separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
