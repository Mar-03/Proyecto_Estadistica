/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author anyi4
 */
 import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Logica {


    // Método para datos no agrupados
    public String calcularNoAgrupados(String datosTexto) throws Exception {
        String[] datosStr = datosTexto.split(",");
        double[] datos = Arrays.stream(datosStr).mapToDouble(Double::parseDouble).toArray();

        if (datos.length == 0) {
            throw new Exception("No hay datos.");
        }

        double rango = Arrays.stream(datos).max().getAsDouble() - Arrays.stream(datos).min().getAsDouble();
        double media = Arrays.stream(datos).average().getAsDouble();
        double varianza = Arrays.stream(datos).map(d -> Math.pow(d - media, 2)).average().getAsDouble();
        double DesviacionMedia = Math.sqrt(varianza);

        return String.format("Rango: %s\nMedia: %s\nVarianza: %s\nDesviación Estándar: %s", rango, media, varianza, DesviacionMedia);
    }

    // Método para datos agrupados
    public String calcularAgrupados(List<String> intervalos, List<Integer> frecuencias) throws Exception {
        if (intervalos.size() != frecuencias.size()) {
            throw new Exception("El número de intervalos debe coincidir con el número de frecuencias.");
        }

        // Calcular rangos y marcas de clase
        List<Double[]> clases = intervalos.stream()
            .map(intervalo -> {
                String[] limites = intervalo.split("-");
                double inferior = Double.parseDouble(limites[0].trim());
                double superior = Double.parseDouble(limites[1].trim());
                double marca = (inferior + superior) / 2;
                return new Double[]{inferior, superior, marca};
            })
            .collect(Collectors.toList());

        double rango = clases.stream().mapToDouble(c -> c[1]).max().orElse(0) - clases.stream().mapToDouble(c -> c[0]).min().orElse(0);

        // Calcular media ponderada
        double sumaFrecuencias = frecuencias.stream().mapToInt(Integer::intValue).sum();
        double media = 0;
        for (int i = 0; i < clases.size(); i++) {
            media += clases.get(i)[2] * frecuencias.get(i);
        }
        media /= sumaFrecuencias;

        // Calcular varianza
        double varianza = 0;
        for (int i = 0; i < clases.size(); i++) {
            varianza += frecuencias.get(i) * Math.pow(clases.get(i)[2] - media, 2);
        }
        varianza /= sumaFrecuencias;

        double desviacionEstandar = Math.sqrt(varianza);

        return String.format("Rango: %s\nMedia Ponderada: %s\nVarianza: %s\nDesviación Estándar: %s", rango, media, varianza, desviacionEstandar);
    }
}


