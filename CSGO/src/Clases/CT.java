/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.AccionesCT;

/**
 *
 * @author santa
 */
public class CT extends Jugador implements AccionesCT {

    private boolean kitDesactvacion;

    public CT(boolean kitDesactvacion, String nick, int equipo, Coordenada3D posicion, boolean chaleco, 
            boolean casco, Arma arma) {
        super(nick, equipo, posicion, chaleco, casco, arma);
        this.kitDesactvacion = kitDesactvacion;  
        this.setSalud(100);
        
    }

    public boolean isKitDesactvacion() {
        return kitDesactvacion;
    }



    @Override
    public boolean desactivaExplosivo(Explosivo explosivo) {

        if(explosivo.getUbicacion() == this.getPosicion()){
            explosivo.desactivar();
            return true;
        }else{
            System.out.println("No estas en la ubicacion de la bomba");
            return false;
        }

    }

    @Override
    public String toString() {
       return    "CT " + "kitDesactvacion ? " + kitDesactvacion + super.toString();
    }

    
}
