package modelos;
// import del pdf 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;


import java.io.FileOutputStream;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ModeloNoAgrupados {
    /* METODO PARA ENCONTRAR rango que es donde se resta el mayor y el menor numero
    coloque una List<Double>datos para poder colocar datos en todos 
     los metodos esto para que se pueda guardar multiples  valores
 sin necesidad de llamar y se pueda manejar adecuadamaente muchos valroes
numericos en varios metodos 
*/
    List<Double>datos;
   public ModeloNoAgrupados() {
        this.datos = new ArrayList<>(); 
    }

    
    public void setDatos(double[] nuevosDatos) {
        datos.clear(); 
        for (double dato : nuevosDatos) {
            datos.add(dato); 
        }
    }
   public double CalcularRango(){
         Collections.sort(datos);
   double max = Collections.max(datos);
   double min = Collections.min(datos);
   return  max-min;
   
   }
   
  
    /**
     Metodo para desviacion media simepre con datos simples
     * ahora dm es desviacion media abreviado donde primero ecuentra el
     * promedio  y de ahi el abs es para que a cada dato le reste el promedio
     * pero que no de negativo para que asi al obterlo pues lo
     * divide en la cantidad de nuemeros que colocamos.
   
     */
     public  double CalculoDesviacionMedias(){
     int cantidadnumeros = datos.size();
     if(cantidadnumeros ==0 )return 0;
     double suma= 0.0;
     for(double dato: datos){
     suma += dato;
     }
    double promedios = suma/cantidadnumeros;
    double sumadm =0;
    for (double dato : datos){
    sumadm += Math.abs(dato - promedios);
    }
     return sumadm/cantidadnumeros;
     }
      /*metodo para calcular desviacion tipica 
   aqui use el math.pow que es para elevar y use el ciclo for para
   que primero encuentre el promedio despues sume los datos menos el 
   promedio y lo eleve al cuadrado
   al final para que me de la desviacion tipica puese un sqrt que es para
   que haga una raiz cuadrada del resultado de sumacuadrados  dividido 
   la cantidad de numeros que se hayan agregado
   */
   public double CalculoDesviacionTipica(){
    int numeros = datos.size();
    if (numeros ==0 ) return 0;
    Double sumasimples = 0.0;
    
       for(double dato: datos) {
        sumasimples+=dato; 
       }
       double promedio = sumasimples /numeros ;
       Double sumarCuadrados =0.0;
        for (double dato: datos){
   
        sumarCuadrados +=Math.pow(dato - promedio,2 );
        
        
        }
       
        return Math.sqrt(sumarCuadrados / numeros);
   }
   
   // aqui pondre el metodo para imprimir 
  

    public static void descargarPDF(JTable tblNoAgrupados, String destino,  JTextField txtDato) throws Exception {
        
    
        Document documento= new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Estadisticas/ Solucion Datos No Agrupados.pdf"));
            
     
        
        
            Image header = Image.getInstance("src/Imagen/Magenta Moderna Aula Virtual Google Classroom Header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
             
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add(" Formato creado por Nova \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));
            
        documento.open();
        documento.add(header);
        documento.add(parrafo);
         
         
        String datosIngresados = txtDato.getText();
         documento.add(new Paragraph ("Datos ingresados: \n" + datosIngresados)); 
          documento.add(new Paragraph ("\n")); 
        PdfPTable pdfTable = new PdfPTable(tblNoAgrupados.getColumnCount());
        for (int i = 0; i < tblNoAgrupados.getColumnCount(); i++) {
            pdfTable.addCell(new Paragraph(tblNoAgrupados.getColumnName(i))); 
        }
        for (int row = 0; row < tblNoAgrupados.getRowCount(); row++) {
            for (int col = 0; col < tblNoAgrupados.getColumnCount(); col++) {
                Object value = tblNoAgrupados.getValueAt(row, col);
                pdfTable.addCell(new Paragraph(value != null ? value.toString() : "")); 
            }
        }
        documento.add(pdfTable); 
        documento.close(); 
        JOptionPane.showMessageDialog(null, "PDF Generado con exito en carpeta estadisticas");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se puede generar el pdf"+e.getMessage());
        }
       
        
       
    }

   
}

