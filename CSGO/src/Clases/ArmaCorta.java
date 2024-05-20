/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author santa
 */
public class ArmaCorta extends Arma {

    public ArmaCorta(String nombre, double multiplicadorDanio) {
        super(nombre, multiplicadorDanio);
    }

    @Override
    public void setMultiplicadorDanio(double multiplicadorDanio) {
        super.setMultiplicadorDanio(multiplicadorDanio);
    }

    @Override
    public double getMultiplicadorDanio() {
        return super.getMultiplicadorDanio();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

}
