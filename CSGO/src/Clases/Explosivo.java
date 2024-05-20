/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author santa
 */
public class Explosivo {

    private Coordenada3D ubicacion;
    private Zona zonaIn;
    private boolean plantado;

    public Explosivo(Coordenada3D ubicacion, Zona zonaIn, boolean plantado) {
        this.ubicacion = ubicacion;
        this.zonaIn = zonaIn;
        this.plantado = plantado;
    }

    public Coordenada3D getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Coordenada3D ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Zona getZona() {
        return zonaIn;
    }

    public void setZona(Zona zona) {
        this.zonaIn = zona;
    }

    public boolean isPlantado() {
        return plantado;
    }

    public void activar() {
        this.plantado = true;
    }

    public void desactivar() {
        this.plantado = false;
    }

}
