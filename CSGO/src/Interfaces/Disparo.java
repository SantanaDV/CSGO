/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Clases.Jugador;

/**
 *
 * @author santa
 */
public interface Disparo {

    int disparar(Jugador objetivo, String parteCuerpo);

    boolean recibirDisparo(int da�o);
}
