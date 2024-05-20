/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Trassierra
 */
public class Coordenada3D {
    private double x;
    private double y;
    private double z;

    // Constructor
    public Coordenada3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Métodos para obtener y establecer las coordenadas en cada eje
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Metodo para imprimir la representacion de la coordenada
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}