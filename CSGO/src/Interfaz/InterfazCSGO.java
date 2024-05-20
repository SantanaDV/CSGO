/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Clases.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InterfazCSGO {

    public static void main(String[] args) {
        // Crear jugadores y mapa
        Jugador[] equipoCT = new Jugador[5];
        Jugador[] equipoT = new Jugador[5];
        ArrayList<Zona> zonasBomba = new ArrayList<>();

        Coordenada3D coordeA = new Coordenada3D(0, 5, 10);
        Cubo cuboA = new Cubo(2, 4, 15);
        Zona a = new Zona(coordeA, cuboA);
        zonasBomba.add(a);

        Mapa mapa = new Mapa("Airstrip", new Cubo(20, 30, 30), zonasBomba);

        // Inicializar jugadores CT
        for (int i = 0; i < equipoCT.length; i++) {
            if (i % 2 == 0) {
                equipoCT[i] = new CT(true, "CT" + (i + 1), 1, new Coordenada3D(i, 0, 0), true, false, new ArmaLarga("AK-47", 1.6));
            } else {
                equipoCT[i] = new CT(false, "CT" + (i + 1), 1, new Coordenada3D(i, 0, 0), false, true, new ArmaCorta("USP-S", 1.1));
            }
        }

        // Inicializar jugadores T
        for (int i = 0; i < equipoT.length; i++) {
            equipoT[i] = new T(null, "T" + (i + 1), 2, new Coordenada3D(i + 5, 0, 0), true, true, new ArmaCorta("Glock-18", 1.1));
        }

        // Asignar la bomba a un jugador aleatorio del equipo T
        Random random = new Random();
        int jugadorConBomba = random.nextInt(equipoT.length);
        T jugadorTConBomba = (T) equipoT[jugadorConBomba];
        jugadorTConBomba.setExplosivo(new Explosivo(new Coordenada3D(jugadorTConBomba.getPosicion().getX(), jugadorTConBomba.getPosicion().getY(), jugadorTConBomba.getPosicion().getZ()), a, false));

        // Variables de juego
        int rondas = 0;
    Scanner scanner = new Scanner(System.in);

        // Bucle de juego
        while (rondas < 3) {
            System.out.println("Comienza la ronda " + (rondas + 1) + "\n");

            // Simular ronda
            if (rondas == 2) {
                simularRondaConPlanteBomba(equipoCT, equipoT, mapa, random);
            } else {
                simularRonda(equipoCT, equipoT, mapa, random);
            }
            rondas++;

            // Verificar condiciones de fin de juego
            if (rondas < 3) {
                // Respawn de jugadores
                for (Jugador jugador : equipoCT) {
                    jugador.respawnear(new Coordenada3D(random.nextDouble() * 10, random.nextDouble() * 10, random.nextDouble() * 10));
                }
                for (Jugador jugador : equipoT) {
                    jugador.respawnear(new Coordenada3D(random.nextDouble() * 10, random.nextDouble() * 10, random.nextDouble() * 10));
                }

                // Asignar nuevamente la bomba a un jugador aleatorio del equipo T
                jugadorConBomba = random.nextInt(equipoT.length);
                jugadorTConBomba = (T) equipoT[jugadorConBomba];
                jugadorTConBomba.setExplosivo(new Explosivo(new Coordenada3D(jugadorTConBomba.getPosicion().getX(), jugadorTConBomba.getPosicion().getY(), jugadorTConBomba.getPosicion().getZ()), a, false));
            }

            // Pausa entre rondas
            System.out.println("\nFin de la ronda " + (rondas) + "\n");
            System.out.println("------------------------------");
            try {
                Thread.sleep(2000); // Pausa de 2 segundos entre rondas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Preguntar si quiere jugar otra partida
        System.out.println("¿Quiere jugar otra partida? (s/n)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            cambiarDeBando(equipoCT, equipoT);
            main(args); // Reiniciar el juego
        } else {
            System.out.println("Gracias por jugar!");
        }
    }

    private static void simularRonda(Jugador[] equipoCT, Jugador[] equipoT, Mapa mapa, Random random) {
        // Simular acciones de los jugadores en la ronda
        boolean bombaPlantada = false;
        boolean bombaDesactivada = false;
        Explosivo bomba = null;

        // Los T intentan plantar la bomba
        for (Jugador jugador : equipoT) {
            if (jugador instanceof T) {
                T terrorista = (T) jugador;
                if (terrorista.getExplosivo() != null && !bombaPlantada) {
                    bomba = terrorista.plantarExplosivo();
                    if (bomba != null && bomba.isPlantado()) {
                        bombaPlantada = true;
                        System.out.println(jugador.getNick() + " ha plantado la bomba!");
                    }
                }
            }
        }

        // Equipo 1 dispara a equipo 2
        for (Jugador jugador : equipoCT) {
            if (random.nextBoolean()) {
                Jugador objetivo = equipoT[random.nextInt(equipoT.length)];
                jugador.disparar(objetivo, "cabeza");
            }
        }

        // Equipo 2 dispara a equipo 1
        for (Jugador jugador : equipoT) {
            if (random.nextBoolean()) {
                Jugador objetivo = equipoCT[random.nextInt(equipoCT.length)];
                jugador.disparar(objetivo, "tronco");
            }
        }

        // Si la bomba está plantada, los CT intentan desactivarla
        if (bombaPlantada) {
            for (Jugador jugador : equipoCT) {
                if (jugador instanceof CT) {
                    CT counterTerrorist = (CT) jugador;
                    if (counterTerrorist.desactivaExplosivo(bomba)) {
                        bombaDesactivada = true;
                        System.out.println(jugador.getNick() + " ha desactivado la bomba!");
                        break;
                    }
                }
            }
        }

        if (bombaPlantada && !bombaDesactivada) {
            System.out.println("La bomba ha explotado, los Terroristas ganan la ronda!");
        } else if (bombaDesactivada) {
            System.out.println("La bomba ha sido desactivada, los Counter-Terroristas ganan la ronda!");
        } else {
            System.out.println("Los Counter-Terroristas han eliminado a todos los Terroristas, ganan la ronda!");
        }
    }

    private static void simularRondaConPlanteBomba(Jugador[] equipoCT, Jugador[] equipoT, Mapa mapa, Random random) {
        // Simular acciones de los jugadores en la ronda
        boolean bombaPlantada = false;
        boolean bombaDesactivada = false;
        Explosivo bomba = null;

        // Forzar que un jugador T plante la bomba en una zona de plantado
        for (Jugador jugador : equipoT) {
            if (jugador instanceof T) {
                T terrorista = (T) jugador;
                if (terrorista.getExplosivo() != null) {
                    // Mover al terrorista a la zona de plantado
                    terrorista.mover(mapa.getZonasPlante().get(0).getCentro());
                    bomba = terrorista.plantarExplosivo();
                    if (bomba != null && bomba.isPlantado()) {
                        bombaPlantada = true;
                        System.out.println(jugador.getNick() + " ha plantado la bomba en la tercera ronda!");
                        break;
                    }
                }
            }
        }

        // Equipo 1 dispara a equipo 2
        for (Jugador jugador : equipoCT) {
            if (random.nextBoolean()) {
                Jugador objetivo = equipoT[random.nextInt(equipoT.length)];
                jugador.disparar(objetivo, "cabeza");
            }
        }

        // Equipo 2 dispara a equipo 1
        for (Jugador jugador : equipoT) {
            if (random.nextBoolean()) {
                Jugador objetivo = equipoCT[random.nextInt(equipoCT.length)];
                jugador.disparar(objetivo, "tronco");
            }
        }

        // Si la bomba está plantada, los CT intentan desactivarla
        if (bombaPlantada) {
            for (Jugador jugador : equipoCT) {
                if (jugador instanceof CT) {
                    CT counterTerrorist = (CT) jugador;
                    if (counterTerrorist.desactivaExplosivo(bomba)) {
                        bombaDesactivada = true;
                        System.out.println(jugador.getNick() + " ha desactivado la bomba!");
                        break;
                    }
                }
            }
        }

        if (bombaPlantada && !bombaDesactivada) {
            System.out.println("La bomba ha explotado, los Terroristas ganan la ronda!");
        } else if (bombaDesactivada) {
            System.out.println("La bomba ha sido desactivada, los Counter-Terroristas ganan la ronda!");
        } else {
            System.out.println("Los Counter-Terroristas han eliminado a todos los Terroristas, ganan la ronda!");
        }
    }

    private static void cambiarDeBando(Jugador[] equipoCT, Jugador[] equipoT) {
        for (Jugador jugador : equipoCT) {
            jugador.cambioBando();
        }
        for (Jugador jugador : equipoT) {
            jugador.cambioBando();
        }
    }
}
