package modelos;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ModeloAgrupados {

    private List<Double> limitesSuperiores;
    private List<Double> limitesInferiores;
    private List<Integer> frecuencias;

    public ModeloAgrupados() {
        
        this.limitesSuperiores = new ArrayList<>();
        this.limitesInferiores = new ArrayList<>();
        this.frecuencias = new ArrayList<>();
    }

    //LIMITES Y FRECUENCIA
    public void setDatos(double[] superiores, double[] inferiores, int[] frecuencias) {
        
        this.limitesSuperiores.clear();
        this.limitesInferiores.clear();
        this.frecuencias.clear();

        for (double limite : superiores) {
            this.limitesSuperiores.add(limite);
        }
        for (double limite : inferiores) {
            this.limitesInferiores.add(limite);
        }
        for (int frecuencia : frecuencias) {
            this.frecuencias.add(frecuencia);
        }
    }

    //DESVIACIÓN MEDIA
    public double calcularDesviacionMedia() {
        
        double media = calcularMedia();
        double suma = 0;
        int n = 0;
        
        for (int i = 0; i < limitesSuperiores.size(); i++) {
            double marcaClase = (limitesSuperiores.get(i) + limitesInferiores.get(i)) / 2;
            suma += frecuencias.get(i) * Math.abs(marcaClase - media);
            n += frecuencias.get(i);
        }
        return suma / n;
    }

    //DESVIACIÓN TÍPICA
    public double calcularDesviacionTipica() {
        
        double media = calcularMedia();
        double suma = 0;
        int n = 0;
        
        for (int i = 0; i < limitesSuperiores.size(); i++) {
            double marcaClase = (limitesSuperiores.get(i) + limitesInferiores.get(i)) / 2;
            suma += frecuencias.get(i) * Math.pow(marcaClase - media, 2);
            n += frecuencias.get(i);
        }
        return Math.sqrt(suma / n);
    }

    //VARIANZA
    public double calcularVarianza() {
        
        double media = calcularMedia();
        double suma = 0;
        int n = 0;
        
        for (int i = 0; i < limitesSuperiores.size(); i++) {
            double marcaClase = (limitesSuperiores.get(i) + limitesInferiores.get(i)) / 2;
            suma += frecuencias.get(i) * Math.pow(marcaClase - media, 2);
            n += frecuencias.get(i);
        }
        return suma / n;
    }

    //MEDIA
    public double calcularMedia() {
        
        double suma = 0;
        int n = 0;
        
        for (int i = 0; i < limitesSuperiores.size(); i++) {
            double marcaClase = (limitesSuperiores.get(i) + limitesInferiores.get(i)) / 2;
            suma += frecuencias.get(i) * marcaClase;
            n += frecuencias.get(i);
        }
        return suma / n;
    }

    //MARCA DE CLASE
    public List<Double> calcularMarcasDeClase() {
        
        List<Double> marcasDeClase = new ArrayList<>();
        for (int i = 0; i < limitesSuperiores.size(); i++) {
            double marcaClase = (limitesSuperiores.get(i) + limitesInferiores.get(i)) / 2;
            marcasDeClase.add(marcaClase);
        }
        return marcasDeClase;
    }
    
    //MÉTODOS PARA IMPRIMIR
    public static void descargarPDF(JTable tblAgrupados, String destino, JTextField txtDato, JTextField txtLimSuperiores, JTextField txtLimInferiores, JLabel lblMedia, JLabel lblDesviacionMedia, JLabel lblDesviacionTipica, JLabel lblVarianza) throws Exception {

        Document documento = new Document();
        try {
            String rts = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(rts + "/Desktop/Estadisticas/Solucion Datos Agrupados.pdf"));

            Image header = Image.getInstance("src/Imagen/Img Datos Agrupados.png");
            header.scaleToFit(650, 800);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add(" Formato creado por Nova \n\n");
            parrafo.setFont(FontFactory.getFont("ARIAL", 18, Font.BOLD, BaseColor.BLACK));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            documento.add(new Paragraph("Resultados calculados:"));
            documento.add(new Paragraph("Media: " + lblMedia.getText()));
            documento.add(new Paragraph("Desviación Media: " + lblDesviacionMedia.getText()));
            documento.add(new Paragraph("Desviación Típica: " + lblDesviacionTipica.getText()));
            documento.add(new Paragraph("Varianza: " + lblVarianza.getText()));
            documento.add(new Paragraph("\n"));

            PdfPTable pdfTable = new PdfPTable(tblAgrupados.getColumnCount());

            for (int i = 0; i < tblAgrupados.getColumnCount(); i++) {
                pdfTable.addCell(new Paragraph(tblAgrupados.getColumnName(i), FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            }

            for (int row = 0; row < tblAgrupados.getRowCount(); row++) {
                for (int col = 0; col < tblAgrupados.getColumnCount(); col++) {
                    Object value = tblAgrupados.getValueAt(row, col);
                    pdfTable.addCell(new Paragraph(value != null ? value.toString() : ""));
                }
            }
            documento.add(pdfTable);
            documento.close();
            JOptionPane.showMessageDialog(null, "PDF Generado con exito en carpeta estadisticas ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede generar el pdf" + e.getMessage());
        }
    }
}
