/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

/**
 *
 * @author santa
 */
public abstract  class Arma {
    private String nombre;
    private double multiplicadorDanio;

    public Arma(String nombre, double multiplicadorDanio) {
        this.nombre = nombre;
        this.multiplicadorDanio = multiplicadorDanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMultiplicadorDanio() {
        return multiplicadorDanio;
    }

    public void setMultiplicadorDanio(double multiplicadorDanio) {
        this.multiplicadorDanio = multiplicadorDanio;
    }
    
    
}
