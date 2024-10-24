package Controladores;

import Vista.VistaAgrupados;
import Vista.VistaInicio;
import Vista.VistaNoAgrupados;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicio {

    private VistaInicio vistaInicio;

    public ControladorInicio(VistaInicio vistaInicio) {
        this.vistaInicio = vistaInicio;
        initController();
    }

    private void initController() {
        vistaInicio.btnSiInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaAgrupados datosAgrupados = new VistaAgrupados(vistaInicio);
                datosAgrupados.setVisible(true);
                vistaInicio.setVisible(false); 
            }
        });

        vistaInicio.btnNoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaNoAgrupados datosNoAgrupados = new VistaNoAgrupados();
                datosNoAgrupados.setVisible(true);
                vistaInicio.setVisible(false); 
            }
        });
    }
//    
//    private void mostrarAgrupados(){
//        VistaAgrupados vistaAgrupados = new VistaAgrupados(vistaInicio);
//        vistaAgrupados.setVisible(true);
//        vistaInicio.setVisible(false);
//    }
//    
//    private void mostrarNoAgrupados(){
//        VistaNoAgrupados vistaNoAgrupados = new VistaNoAgrupados(vistaInicio);
//        vistaNoAgrupados.setVisible(true);
//        vistaInicio.setVisible(false);
//    }
}
