package Modelo;

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

    private void initController() {
        vistaInicio.btnSiInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosAgrupados();
            }
        });

        vistaInicio.btnNoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosNoAgrupados();
            }
        });
    }

    private void mostrarDatosAgrupados() {
        VistaAgrupados datosAgrupados = new VistaAgrupados(vistaInicio);
        datosAgrupados.setVisible(true);
        vistaInicio.setVisible(false); // Ocultar VistaInicio
    }

    private void mostrarDatosNoAgrupados() {
        VistaNoAgrupados datosNoAgrupados = new VistaNoAgrupados();
        datosNoAgrupados.setVisible(true);
        vistaInicio.setVisible(false); // Ocultar VistaInicio
    }
}
