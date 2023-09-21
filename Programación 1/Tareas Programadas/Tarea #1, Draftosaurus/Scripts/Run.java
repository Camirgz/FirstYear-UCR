//Imports
import java.util.Random;

public class Run {
    public void run(){

        //Especies a Jugar con
        BolsaDinosaurios juego = new BolsaDinosaurios();

        //Ronda 1
        String jugador1_ronda1 = juego.primeraRonda();
        String jugador2_ronda1 = juego.primeraRonda();

        //Ronda 2
        String jugador1_ronda2 = juego.primeraRonda();
        String jugador2_ronda2 = juego.primeraRonda();

        System.out.println(jugador1_ronda1);
        System.out.println(jugador2_ronda1);
        System.out.println(jugador1_ronda2);
        System.out.println(jugador2_ronda2);

        //pruebitas wuju
        String prueba = "abcdefghijklmno";

        int pruebita = -1;

        juego.zonaValidador(pruebita);

    }
}
