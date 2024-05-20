/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.Acciones;
import Interfaces.Disparo;
import java.util.Random;

/**
 *
 * @author santa
 */
public class Jugador implements Acciones, Disparo {

    private String nick;
    private int equipo;
    private Coordenada3D posicion;
    private Estadistica resultado;
    private int salud;
    private boolean chaleco;
    private boolean casco;
    private Arma arma;
    private boolean moviendo;
    private boolean agachando;
    private boolean caminado;
    private boolean saltando;

    public Jugador(String nick, int equipo, Coordenada3D posicion, boolean chaleco, boolean casco, Arma arma) {
        this.nick = nick;
        setEquipo(equipo);
        this.posicion = posicion;
        this.chaleco = chaleco;
        this.casco = casco;
        this.arma = arma;
        this.resultado = new Estadistica();
    }

    public String getNick() {
        return nick;
    }

    public int getEquipo() {
        return equipo;
    }

    public Coordenada3D getPosicion() {
        return posicion;
    }

    public Estadistica getResultado() {
        return resultado;
    }

    public int getSalud() {
        return salud;
    }

    public boolean isChaleco() {
        return chaleco;
    }

    public boolean isCasco() {
        return casco;
    }

    public Arma getArma() {
        return arma;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setEquipo(int equipo) {
        if (equipo == 1 || equipo == 2) {
            Random r = new Random();
            this.equipo = r.nextInt(1, 3);
        }

    }

    public void setResultado(Estadistica resultado) {
        this.resultado = resultado;
    }

    public void setSalud(int salud) {
        if (salud >= 0 || salud <= 100) {
            this.salud = salud;
        } else {
            throw new IllegalArgumentException("La salud tiene que estar entre 0 y 100");
        }

    }

    public void setChaleco(boolean chaleco) {
        this.chaleco = chaleco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void mover(Coordenada3D posicion) {

        this.posicion = posicion;
        this.moviendo = true;
    }

    @Override
    public void agacharse() {
        this.agachando = true;

    }

    @Override
    public void saltar() {
        this.saltando = true;
        this.moviendo = true;
    }

    @Override
    public void caminar() {
        this.caminado = true;
        this.moviendo = true;
    }

    @Override
    public Jugador cambioBando() {

        if (this instanceof T) {
            Jugador aCT = new CT(true, this.nick, this.equipo, this.posicion, this.chaleco, this.casco, this.arma);
            aCT.setResultado(this.resultado);
            return aCT;
        } else {
            Jugador aT = new T(null, this.nick, this.equipo, this.posicion, this.chaleco, this.casco, this.arma);
            aT.setResultado(this.resultado);
            return aT;
        }

    }

    public void levantarse() {
        this.agachando = false;
    }

    public void aterrizar() {
        this.saltando = false;
    }

    public void morir() {
        this.salud = 0;
        this.resultado.incrementarMuertes();
    }

    public void respawnear(Coordenada3D posicion) {
        this.posicion = posicion;
        this.salud = 100;
        System.out.println("Has vuelto a la vida ");
    }

    public int disparar(Jugador Objetivo, String parteCuerpo) {

        boolean acertar = false;
        Random r = new Random();
        int danio = 0;
        int danioV = 0;
      
       
        if (Objetivo.getSalud() >0) {

           
            if (parteCuerpo.equalsIgnoreCase("cabeza")) {
                acertar = true;
                this.resultado.incrementarDC();
                if (Objetivo.isCasco()) {
                    danio = r.nextInt(50, 71);

                } else {
                    this.resultado.incrementarDC();
                    danio = r.nextInt(80, 101);

                }
            } else if (parteCuerpo.equalsIgnoreCase("tronco")) {
                acertar = true;
                if (Objetivo.isChaleco()) {
                    danio = r.nextInt(40, 61);

                } else {
                    danio = r.nextInt(70, 101);

                }
            } else if (parteCuerpo.equalsIgnoreCase("extremidades")) {
                acertar = true;
                danio = r.nextInt(40, 51);

            } else {
                System.out.println("No acertastes");
            }
        } else {
            System.out.println("El objetivo ya estaba muerto :(");
        }
        if (acertar) {
            
             double danioProducido = danio * this.arma.getMultiplicadorDanio();
            danioV = this.danoVerdadero((int) danioProducido);   
           
           
            if(!Objetivo.recibirDisparo(danioV)){
                 this.resultado.incremetarAbatidos();
            }
            
            this.resultado.incrementarDanio(danioV);
            this.resultado.incrementarDisparos();
              String chapada = this.nick + " ha hecho " + danioV + " al jugador " + Objetivo.nick + "con su " + this.arma.getNombre();
            System.out.println(chapada);
            return danioV;
          
        }
        return danioV;

    }

    public boolean recibirDisparo(int danio) {
        if (danio >= this.salud){
           this.morir();
            return estaMuerto();
        }else{
            this.setSalud(this.salud - danio);
            return estaMuerto();
        }
        
    }

    public boolean estaMuerto() {
        if (this.salud == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int danoVerdadero(int danio) {
        if (danio > this.salud) {
            return this.salud;
        } else {
            return danio;
        }
    }

    @Override
    public String toString() {
        return "nick=" + nick + ", posicion=" + posicion + ", salud=" + salud + ']';
    }

}
