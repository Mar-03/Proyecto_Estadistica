/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cindy Ruano
 */
public class ModeloAgrupados {
    
    private int limSuperiores;
    private int limInferiores;
    private int frecuencias;
    private int marcaClase;
    private int media;
    private int mediana;
    private int moda;
    private int varianza;
    private int desMedia;
    private int desTipica;
    private int rango;
    private int noClase;
    private int tamClase;
    private int datos;

    public ModeloAgrupados(int limSuperiores, int limInferiores, int frecuencias, int marcaClase, int media, int mediana, int moda, int varianza, int desMedia, int desTipica, int rango, int noClase, int tamClase, int datos) {
        this.limSuperiores = limSuperiores;
        this.limInferiores = limInferiores;
        this.frecuencias = frecuencias;
        this.marcaClase = marcaClase;
        this.media = media;
        this.mediana = mediana;
        this.moda = moda;
        this.varianza = varianza;
        this.desMedia = desMedia;
        this.desTipica = desTipica;
        this.rango = rango;
        this.noClase = noClase;
        this.tamClase = tamClase;
        this.datos = datos;
    }

    public int getLimSuperiores() {
        return limSuperiores;
    }

    public void setLimSuperiores(int limSuperiores) {
        this.limSuperiores = limSuperiores;
    }

    public int getLimInferiores() {
        return limInferiores;
    }

    public void setLimInferiores(int limInferiores) {
        this.limInferiores = limInferiores;
    }

    public int getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(int frecuencias) {
        this.frecuencias = frecuencias;
    }

    public int getMarcaClase() {
        return marcaClase;
    }

    public void setMarcaClase(int marcaClase) {
        this.marcaClase = marcaClase;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getMediana() {
        return mediana;
    }

    public void setMediana(int mediana) {
        this.mediana = mediana;
    }

    public int getModa() {
        return moda;
    }

    public void setModa(int moda) {
        this.moda = moda;
    }

    public int getVarianza() {
        return varianza;
    }

    public void setVarianza(int varianza) {
        this.varianza = varianza;
    }

    public int getDesMedia() {
        return desMedia;
    }

    public void setDesMedia(int desMedia) {
        this.desMedia = desMedia;
    }

    public int getDesTipica() {
        return desTipica;
    }

    public void setDesTipica(int desTipica) {
        this.desTipica = desTipica;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getNoClase() {
        return noClase;
    }

    public void setNoClase(int noClase) {
        this.noClase = noClase;
    }

    public int getTamClase() {
        return tamClase;
    }

    public void setTamClase(int tamClase) {
        this.tamClase = tamClase;
    }

    public int getDatos() {
        return datos;
    }

    public void setDatos(int datos) {
        this.datos = datos;
    }
    
    
    
    
}
