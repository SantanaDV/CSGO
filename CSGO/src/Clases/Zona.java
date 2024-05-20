/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Trassierra
 */
public class Zona {

    private Coordenada3D centro;
    private Cubo area;

    public Zona(Coordenada3D centro, Cubo area) {
        this.centro = centro;
        this.area = area;
    }

    public Coordenada3D getCentro() {
        return centro;
    }

    public void setCentro(Coordenada3D centro) {
        this.centro = centro;
    }

    public Cubo getArea() {
        return area;
    }

    public void setArea(Cubo area) {
        this.area = area;
    }

    public boolean estaDentro(Coordenada3D coordenada) {
        // Calculamos los li­mites del cubo
        double minX = centro.getX() - (area.getAncho() / 2);
        double minY = centro.getY() - (area.getLargo() / 2);
        double minZ = centro.getZ() - (area.getAlto() / 2);
        double maxX = centro.getX() + (area.getAncho() / 2);
        double maxY = centro.getY() + (area.getLargo() / 2);
        double maxZ = centro.getZ() + (area.getAlto() / 2);

        // Verificamos si la coordenada esta dentro de los li­mites del cubo
        return (coordenada.getX() >= minX && coordenada.getX() <= maxX)
                && (coordenada.getY() >= minY && coordenada.getY() <= maxY)
                && (coordenada.getZ() >= minZ && coordenada.getZ() <= maxZ);
    }

}
