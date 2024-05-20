/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.AccionesT;

/**
 *
 * @author santa
 */
public class T extends Jugador implements AccionesT {

    private static boolean hayExplosivo = false;
    private Explosivo explosivo;

    public T(Explosivo explosivo, String nick, int equipo, Coordenada3D posicion, boolean chaleco,
            boolean casco, Arma arma) {
        super(nick, equipo, posicion, chaleco, casco, arma);
        this.explosivo = null;
        this.setSalud(100);
    }

    public Explosivo getExplosivo() {
        return explosivo;
    }

    public void setExplosivo(Explosivo explosivo) {
        if (hayExplosivo == false) {
            hayExplosivo = true;
            this.explosivo = explosivo;
        } else {
            System.out.println("Ya hay un explosivo asignado");
        }

    }

    @Override
    public Explosivo dropExplosivo() {
        Explosivo colocado = this.explosivo;
        colocado.setUbicacion(this.getPosicion());
        this.explosivo = null;
        return colocado;
    }

    @Override
    public Explosivo plantarExplosivo() {
        if (explosivo.getZona().estaDentro(this.getPosicion())) {
            this.explosivo.activar();
            return explosivo;
        } else {
            System.out.println("No estas en la zona de plantar la bomba");
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "T explosivo: " + explosivo;
    }

    @Override
    public boolean pickExplosivo() {
        if (this.explosivo != null && !this.explosivo.isPlantado()
                && this.explosivo.getZona().estaDentro(this.getPosicion())) {
            this.explosivo = null;
            return true; // Se recogió el explosivo
        }
        return false; // No se pudo recoger el explosivo
    }

    public static void reiniciarJuego() {
        hayExplosivo = false;
    }

}
