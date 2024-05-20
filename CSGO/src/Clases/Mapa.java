/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author santa
 */
public class Mapa {
    private String nombre;
    private Cubo area;
    private ArrayList<Zona> zonasPlante;

    public Mapa(String nombre, Cubo area, ArrayList<Zona> zonasPlante) {
        this.nombre = nombre;
        this.area = area;
        this.zonasPlante = zonasPlante;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cubo getArea() {
        return area;
    }

    public void setArea(Cubo area) {
        this.area = area;
    }

    public ArrayList<Zona> getZonasPlante() {
        return zonasPlante;
    }

    public void setZonasPlante(ArrayList<Zona> zonasPlante) {
        this.zonasPlante = zonasPlante;
    }

    @Override
    public String toString() {
        return "Mapa " + "nombre=" + nombre + ", area=" + area + ", zonasPlante=" + zonasPlante + '}';
    }
    
    
}
