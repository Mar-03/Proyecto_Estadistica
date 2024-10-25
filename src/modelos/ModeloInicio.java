package modelos;

import Vista.VistaAgrupados;
import Vista.VistaInicio;
import Vista.VistaNoAgrupados;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeloInicio {

    private VistaInicio vistaInicio;

    public ModeloInicio(VistaInicio vistaInicio) {
        this.vistaInicio = vistaInicio;
        initController();
    }

    //BOTÓN "SI"
    private void initController() {
        vistaInicio.btnSiInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosAgrupados();
            }
        });

    //BOTÓN "NO"    
        vistaInicio.btnNoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosNoAgrupados();
            }
        });
    }

    //MOSTRAR LOS DATOS AGRUPADOS 
    private void mostrarDatosAgrupados() {
        VistaAgrupados datosAgrupados = new VistaAgrupados();
        datosAgrupados.setVisible(true);
        vistaInicio.setVisible(false);
    }

    //MOSTRAR LOS DATOS NO AGRUPADOS 
    private void mostrarDatosNoAgrupados() {
        VistaNoAgrupados datosNoAgrupados = new VistaNoAgrupados();
        datosNoAgrupados.setVisible(true);
        vistaInicio.setVisible(false);
    }
}
