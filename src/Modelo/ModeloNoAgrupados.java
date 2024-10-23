package modelo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class ModeloNoAgrupados {
// metodo para calcular la medida que despues sera llamado para el controlador 
    public double calcularMedia(double[] datos) {

        double suma = 0;

        for (double dato : datos) {

            suma += dato;
        }
        return suma / datos.length;
    }
// metodo para calcular la mediana 
    public double calcularMediana(double[] datos) {
        Arrays.sort(datos);

        int mitad = datos.length / 2;
        if (datos.length % 2 == 0) {
            return (datos[mitad - 1] + datos[mitad]) / 2.0;

        } else {
            return datos[mitad];
        }
    }
// metodo para calcular media ponderada 
    public double calcularMediaPonderada(double[] datos, double[] numeros) {
        double suma = 0;
        double numero = 0;
        for (int i = 0; i < datos.length; i++) {
            suma += datos[i] * numeros[i];
            numero += numeros[i];
        }
        return suma / numero;
    }
// metodo para calcular moda datos simples
    public double calcularModa(double[] datos) {
        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double dato : datos) {
            frecuencia.put(dato, frecuencia.getOrDefault(dato, 0) + 1);
        }
        double moda = datos[0];
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }
}
