
package Controladores;






/**
 *
 * @author anyi4
 */
import Vista.VistaNoAgrupados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import modelos.ModeloNoAgrupados;

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

    
    public class CalcularListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calcularEstadisticas();
        }
    }

    
   public  class LimpiarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.limpiarCampos();
        }
    }

    
    public class ImprimirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    
    private void calcularEstadisticas() {
        try {
         /*
            aqui obtenemos los datos y de string o int los pasamos a double para que acpete decimales y pueda hacer
            las operacione matematicas
            */   
            String datosEntrada = vista.getDatos();
            String[] strDatos = datosEntrada.split(",");

           
            double[] datos = new double[strDatos.length];
            for (int i = 0; i < strDatos.length; i++) {
                datos[i] = Double.parseDouble(strDatos[i].trim());
            }

            /*
            aqui llamamos a el modelo para que resuelva los problemas matematicos y nos mande 
            la solucion para la tabla de vistas 
            */ 
            double rango = modelo.CalcularRango();
            double desviacionmedia = modelo.CalculoDesviacionMedias();
            double desviaciontipica= modelo.CalculoDesviacionTipica();
            double[] ponderaciones = new double[datos.length];
            Arrays.fill(ponderaciones, 1);
            /*
            ahora aqui manda los resultados a la vista con el valor correspondiente 
            */ 
            vista.setRango(String.valueOf(desviacionmedia));
            vista.setDesviacionMedia(String.valueOf(desviacionmedia));
            vista.setDesviacionTipica(String.valueOf(desviaciontipica));
            

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor ingrese números válidos separados por comas.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(vista, "No puede dejar el campo vacio",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

