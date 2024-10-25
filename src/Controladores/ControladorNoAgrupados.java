
package Controladores;

import Vista.VistaNoAgrupados;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
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
        this.vista.btnLimpiar.addActionListener(e -> limpiar());
        this.vista.btnImprimir.addActionListener(e -> imprimirPDF());
    
    }
    

    public void calcular() {
        String[] datosTexto = vista.txtDato.getText().split(",");
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
      
    }

    public void limpiar() {
        vista.limpiarCampos();
        vista.txtDato.setText("");
    }
   private void imprimirPDF() {
        try {
            String destino = "resultados.pdf";
            crearPDF(vista.tblNoAgrupados, destino);
            abrirPDF(destino);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al crear el PDF: " + ex.getMessage());
        }
    }

  

    private static void crearPDF(JTable tblNoAgrupados, String destino) throws Exception {
        
        File directorio = new File(destino);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        
        String archivo = destino + "/solucion.pdf";

        
        PdfWriter writer = new PdfWriter(archivo);
        PdfDocument pdf = new PdfDocument(pdf);
        Document document = new Document(pdf); 

        
        Table pdfTable = new Table(tblNoAgrupados.getColumnCount());

        
        for (int i = 0; i < tblNoAgrupados.getColumnCount(); i++) {
            pdfTable.addCell(new Paragraph(tblNoAgrupados.getColumnName(i)));
        }

        
        for (int row = 0; row < tblNoAgrupados.getRowCount(); row++) {
            for (int col = 0; col < tblNoAgrupados.getColumnCount(); col++) {
                Object value = tblNoAgrupados.getValueAt(row, col);
               pdfTable.addCell(new Paragraph(value != null ? value.toString() : ""));
            }
        }

       
        document.add(pdfTable);

       
        document.close();
    }

    private void abrirPDF(String destino) throws IOException {
        File pdfFile = new File(destino);
        if (pdfFile.exists() && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);  
        } else {
            JOptionPane.showMessageDialog(null, "No se puede abrir el PDF.");
        }
    }
}

  



