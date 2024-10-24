package modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

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
   double max = Collections.max(datos);
   double min = Collections.min(datos);
   return  max-min;
   
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
       Double sumarCuadrados =0.0;
       for(double dato: datos) {
        sumasimples+=dato; 
       }
       double promedio = sumasimples /numeros ;
        for (double dato: datos){
   
 
        sumarCuadrados +=Math.pow(dato - promedio,2 );
        
        
        }
       
        double desviaciontipica = Math.sqrt(sumarCuadrados /numeros);
   return desviaciontipica;
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
    sumadm = Math.abs(dato - promedios);
    }
     return sumadm/datos.size();
     }
}
