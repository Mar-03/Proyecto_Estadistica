package Vista;

import Controladores.ControladorNoAgrupados;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelos.ModeloNoAgrupados;

public class VistaNoAgrupados extends javax.swing.JFrame {

    public VistaNoAgrupados() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ModeloNoAgrupados modelo = new ModeloNoAgrupados();
        ControladorNoAgrupados controlador = new ControladorNoAgrupados(this, modelo);
    }

    //MÉTODOS GET
    public JTextField getTxtDato() {
        return txtDato;
    }

    public JTable getTblNoAgrupados() {
        return tblNoAgrupados;
    }

    //BOTÓN LIMPIAR
    public void limpiarTablaResultados() {
        int rowCount = tblNoAgrupados.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < tblNoAgrupados.getColumnCount(); j++) {
                tblNoAgrupados.setValueAt(null, i, j);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPanel = new javax.swing.JPanel();
        letTituloNoAgrupados = new javax.swing.JLabel();
        tablaNoAgrupados = new javax.swing.JScrollPane();
        tblNoAgrupados = new javax.swing.JTable();
        separador = new javax.swing.JSeparator();
        letDatos = new javax.swing.JLabel();
        txtDato = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        btnRegresarNoAgrupados = new javax.swing.JButton();
        letFondoNoAgrupados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        letTituloNoAgrupados.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        letTituloNoAgrupados.setForeground(new java.awt.Color(255, 255, 255));
        letTituloNoAgrupados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letTituloNoAgrupados.setText("DATOS NO AGRUPADOS");
        fondoPanel.add(letTituloNoAgrupados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 600, -1));

        tblNoAgrupados.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tblNoAgrupados.setForeground(new java.awt.Color(57, 54, 54));
        tblNoAgrupados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Rango", "Desviación Media", "Desviación Típica"
            }
        ));
        tblNoAgrupados.setSelectionForeground(new java.awt.Color(57, 54, 54));
        tablaNoAgrupados.setViewportView(tblNoAgrupados);

        fondoPanel.add(tablaNoAgrupados, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 480, 140));

        separador.setForeground(new java.awt.Color(255, 255, 255));
        fondoPanel.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 157, 310, -1));

        letDatos.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        letDatos.setForeground(new java.awt.Color(57, 54, 54));
        letDatos.setText("Datos:");
        fondoPanel.add(letDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        txtDato.setForeground(new java.awt.Color(57, 54, 54));
        txtDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoActionPerformed(evt);
            }
        });
        fondoPanel.add(txtDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 185, -1));

        btnCalcular.setBackground(new java.awt.Color(202, 183, 183));
        btnCalcular.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(57, 54, 54));
        btnCalcular.setText("Calcular");
        btnCalcular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        fondoPanel.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 75, -1));

        btnLimpiar.setBackground(new java.awt.Color(202, 183, 183));
        btnLimpiar.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(57, 54, 54));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 75, -1));

        btnImprimir.setBackground(new java.awt.Color(202, 183, 183));
        btnImprimir.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(57, 54, 54));
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        fondoPanel.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 75, -1));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/3.png"))); // NOI18N
        fondoPanel.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 120, 60));

        btnRegresarNoAgrupados.setBackground(new java.awt.Color(202, 183, 183));
        btnRegresarNoAgrupados.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnRegresarNoAgrupados.setForeground(new java.awt.Color(57, 54, 54));
        btnRegresarNoAgrupados.setText("Regresar");
        btnRegresarNoAgrupados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        btnRegresarNoAgrupados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarNoAgrupadosActionPerformed(evt);
            }
        });
        fondoPanel.add(btnRegresarNoAgrupados, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 80, 30));

        letFondoNoAgrupados.setBackground(new java.awt.Color(235, 200, 200));
        letFondoNoAgrupados.setOpaque(true);
        fondoPanel.add(letFondoNoAgrupados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtDato.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatoActionPerformed

    private void btnRegresarNoAgrupadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarNoAgrupadosActionPerformed
        VistaInicio vi = new VistaInicio();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarNoAgrupadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaNoAgrupados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaNoAgrupados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaNoAgrupados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaNoAgrupados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaNoAgrupados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresarNoAgrupados;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel letDatos;
    private javax.swing.JLabel letFondoNoAgrupados;
    private javax.swing.JLabel letTituloNoAgrupados;
    private javax.swing.JSeparator separador;
    private javax.swing.JScrollPane tablaNoAgrupados;
    public javax.swing.JTable tblNoAgrupados;
    public javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
