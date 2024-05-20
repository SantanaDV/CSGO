/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Clases.Coordenada3D;
import Clases.Jugador;

/**
 *
 * @author santa
 */
public interface Acciones {

    void mover(Coordenada3D posicion);

    void agacharse();

    void saltar();

    void caminar();

    void morir();

    void respawnear(Coordenada3D posicion);

    boolean estaMuerto();

    Jugador cambioBando();

}
