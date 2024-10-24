package modelos;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.ArrayList;
import java.util.List;

public class ModeloAgrupados {
    private List<Double> limitesSuperiores;
    private List<Double> limitesInferiores;
    private List<Integer> frecuencias;

    public ModeloAgrupados() {
        this.limitesSuperiores = new ArrayList<>();
        this.limitesInferiores = new ArrayList<>();
        this.frecuencias = new ArrayList<>();
    }

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

    public List<Double> calcularMarcasDeClase() {
        List<Double> marcasDeClase = new ArrayList<>();
        for (int i = 0; i < limitesSuperiores.size(); i++) {
            double marcaClase = (limitesSuperiores.get(i) + limitesInferiores.get(i)) / 2;
            marcasDeClase.add(marcaClase);
        }
        return marcasDeClase;
    }
}

