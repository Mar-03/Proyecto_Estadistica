package Controlador;

import Vista.VistaAgrupados;
import Vista.VistaInicio;
import Vista.VistaNoAgrupados;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgrupados extends JFrame {
    
        private JFrame parentFrame;
        
        public ControladorAgrupados(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton regresarButton = new JButton("Regresar");
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.setVisible(true);
                dispose(); 
            }
        });
        add(regresarButton);
    }
}
        
        
        
    private VistaAgrupados vistaAgrupados; 
    
    public ControladorAgrupados(VistaAgrupados vistaAgrupados){
        this.vistaAgrupados = vistaInicio;
        initController();
    }
    
    private void initController(){
        vistaAgrupados.btnRegresarAgrupados.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VistaAgrupados datos 
            }
        }
//}
//
//
//
//    private void initController() {
//        vistaInicio.btnSiInicio.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Mostrar el JFrame DatosAgrupados al presionar "SI"
//                VistaAgrupados datosAgrupados = new VistaAgrupados(vistaInicio);
//                datosAgrupados.setVisible(true);
//                vistaInicio.setVisible(false); // Ocultar VistaInicio
//            }
//        });
//
//        vistaInicio.btnNoInicio.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Mostrar el JFrame DatosNoAgrupados al presionar "NO"
//                VistaNoAgrupados datosNoAgrupados = new VistaNoAgrupados();
//                datosNoAgrupados.setVisible(true);
//                vistaInicio.setVisible(false); // Ocultar VistaInicio
//            }
//        });
//    }
//}
//
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class DatosAgrupados extends JFrame {
//    private JFrame parentFrame;
//
//    public DatosAgrupados(JFrame parentFrame) {
//        this.parentFrame = parentFrame;
//
//        // Configuración del JFrame DatosAgrupados
//        setTitle("Datos Agrupados");
//        setSize(300, 200);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Crear botón "Regresar"
//        JButton regresarButton = new JButton("Regresar");
//        regresarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Mostrar el JFrame VistaInicio al presionar "Regresar"
//                parentFrame.setVisible(true);
//                dispose(); // Cerrar DatosAgrupados
//            }
//        });
//
//        // Añadir botón al JFrame
//        add(regresarButton);
//    }
//}
