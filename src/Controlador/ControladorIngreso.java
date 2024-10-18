package Controlador;

import Modelo.ModeloIngreso;

import Vista.PanelAgrupados;
import Vista.PanelNoAgrupados;
import Vista.VistaLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;

public class ControladorIngreso implements ActionListener, WindowListener, MouseListener {

    ModeloIngreso modelo;

    public ControladorIngreso(ModeloIngreso modelo) {
        this.modelo = modelo;
    }

    public void MostrarPanel(JPanel p) {
        p.setSize(980, 720);
        p.setLocation(0, 0);

//        modelo.getVistaIngreso().contenedor.removeAll();
//        modelo.getVistaIngreso().contenedor.add(p, BorderLayout.CENTER);
//        modelo.getVistaIngreso().contenedor.revalidate();
//        modelo.getVistaIngreso().contenedor.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

//        System.out.println(modelo.getCalcular());
//        if (modelo.getCalcular() == 1) {
//            modelo.getVistaIngreso().btnAgregar.setVisible(true);
//            modelo.getVistaIngreso().btnCalcular.setVisible(true);
//            modelo.getVistaIngreso().btnLimpiar.setVisible(true);
//            modelo.getVistaIngreso().btnOrdenar.setVisible(true);
//            modelo.getVistaIngreso().btnQuitar.setVisible(true);
//        } else if (modelo.getCalcular() == 2) {
//            modelo.getVistaIngreso().btnAgregar.setVisible(false);
//            modelo.getVistaIngreso().btnCalcular.setVisible(false);
//            modelo.getVistaIngreso().btnLimpiar.setVisible(false);
//            modelo.getVistaIngreso().btnOrdenar.setVisible(false);
//            modelo.getVistaIngreso().btnQuitar.setVisible(false);
//        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

//        if (e.getComponent().equals(modelo.getVistaIngreso().btnCalcular)) {
//            Vista.PanelNoAgrupados vPanelP = new PanelNoAgrupados();
//            MostrarPanel(vPanelP);
//
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnOrdenar)) {
//            Vista.PanelAgrupados vPanelA = new PanelAgrupados();
//            MostrarPanel(vPanelA);
//
////        }else if(e.getComponent().equals(modelo.getVistaIngreso().btnQuitar)){
////            Vista.VistaLogin vLogin = new VistaLogin();
////            vLogin.setVisible(true);
////            modelo.getVistaIngreso().dispose();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

//        if (e.getComponent().equals(modelo.getVistaIngreso().btnAgregar)) {
//            modelo.getVistaIngreso().btnAgregar.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnCalcular)) {
//            modelo.getVistaIngreso().btnCalcular.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnLimpiar)) {
//            modelo.getVistaIngreso().btnLimpiar.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnOrdenar)) {
//            modelo.getVistaIngreso().btnOrdenar.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnQuitar)) {
//            modelo.getVistaIngreso().btnQuitar.setBackground(new Color(102, 102, 102));
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

//        if (e.getComponent().equals(modelo.getVistaIngreso().btnAgregar)) {
//            modelo.getVistaIngreso().btnAgregar.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnCalcular)) {
//            modelo.getVistaIngreso().btnCalcular.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnLimpiar)) {
//            modelo.getVistaIngreso().btnLimpiar.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnOrdenar)) {
//            modelo.getVistaIngreso().btnOrdenar.setBackground(new Color(102, 102, 102));
//        } else if (e.getComponent().equals(modelo.getVistaIngreso().btnQuitar)) {
//            modelo.getVistaIngreso().btnQuitar.setBackground(new Color(102, 102, 102));
//        }
    }
}
