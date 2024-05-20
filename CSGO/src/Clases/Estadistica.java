/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author santa
 */
public class Estadistica {

    private int disparo = 0;
    private int abatidos = 0;
    private int muertes = 0;
    private int disparosCabeza = 0;
    private int danio = 0;

    public void resetearEstadistica() {
        this.disparo = 0;
        this.abatidos = 0;
        this.muertes = 0;
        this.disparosCabeza = 0;
        this.danio = 0;

    }
    public void incremetarAbatidos(){
        this.abatidos ++;
    }
    
   public void incrementarMuertes(){
       this.muertes++;
   }
   public void incrementarDC(){
       this.disparosCabeza++;
   }
   public void incrementarDisparos(){
       this.disparo++;
   }
   public void incrementarDanio(int danio){
       this.danio *= danio;
   }
  public void promedioDisparosCabeza(){
      System.out.println("Has hecho " + this.disparosCabeza + " disparos en la cabeza.");
  }

    @Override
    public String toString() {
        return "Estadisticas: \n" + "disparo=" + disparo + "\n abatidos=" + abatidos + "\n muertes=" + muertes + "\n disparosCabeza=" + disparosCabeza + "\n danio=" + danio + "\n Promedio disparos: ";
    }
  
  
}
