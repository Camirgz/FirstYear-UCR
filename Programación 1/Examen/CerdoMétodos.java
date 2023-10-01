import java.util.Scanner;
import java.util.Random;

public class CerdoMétodos {

    //Variables Globales
    //Puntaje de Jugadores
    int J1 = 0;
    int J2 = 0;
    int J3 = 0;
    int J4 = 0;
    int J5 = 0;
    int J6 = 0;

    //Partidas Ganadas
    int J1G = 0;
    int J2G = 0;
    int J3G = 0;
    int J4G = 0;
    int J5G = 0;
    int J6G = 0;

    //Otras

    int turno = 1;
    int valorDado = 0;
    int entradaJugadores = 0;
    int cantidadPuntos = 20;

    boolean plantarse = false;
    boolean validadorEntrada = false;
    boolean hayGanador = false;
    boolean otraRonda = true;

    //Iniciar Imports
    Scanner in = new Scanner(System.in);
    Random random = new Random();

    //Métodos
    //Imprimir Tablero
    public void imprimirPuntajes(int entradaJugadoresValidada) {
        switch (entradaJugadoresValidada) {
            case 2: {
                System.out.println("J1: " + J1 + " J2: " + J2);
                break;
            }
            case 3: {
                System.out.println("J1: " + J1 + " J2: " + J2 + " J3: " + J3);
                break;
            }
            case 4: {
                System.out.println("J1: " + J1 + " J2: " + J2 + " J3: " + J3 + " J4: " + J4);
                break;
            }
            case 5: {
                System.out.println("J1: " + J1 + " J2: " + J2 + " J3: " + J3 + " J4: " + J4 + " J5: " + J5);
                break;
            }
            case 6: {
                System.out.println("J1: " + J1 + " J2: " + J2 + " J3: " + J3 + " J4: " + J4 + " J5: " + J5 + " J6: " + J6);
                break;
            }
        }
    }

    //Tirar dado
    public int tirarDado() {
        valorDado = random.nextInt(6) + 1;
        return valorDado;
    }


    //Turno
    public void cambioTurno() {
        System.out.println("Turno de J" + turno);
        if (turno != entradaJugadores) {
            turno += 1;
        } else {
            turno = 1;
        }
    }

    //Quién gana?
    public void ganador() {
        if (J1 > cantidadPuntos) {
            System.out.println("Felicidades J1 ha ganado!");
            J1G += 1;
        }
        if (J2 > cantidadPuntos) {
            System.out.println("Felicidades J2 ha ganado!");
            J2G += 1;
        }
        if (J3 > cantidadPuntos) {
            System.out.println("Felicidades J3 ha ganado!");
            J3G += 1;
        }
        if (J4 > cantidadPuntos) {
            System.out.println("Felicidades J4 ha ganado!");
            J4G += 1;
        }
        if (J5 > cantidadPuntos) {
            System.out.println("Felicidades J5 ha ganado!");
            J5G += 1;
        }
        if (J6 > cantidadPuntos) {
            System.out.println("Felicidades J6 ha ganado!");
            J6G += 1;
        }
    }

    //Hay ganador?
    public void hay_ganador() {
        if (J1 < cantidadPuntos && J2 < cantidadPuntos && J3 < cantidadPuntos && J4 < cantidadPuntos && J5 < cantidadPuntos && J6 < cantidadPuntos) {
            hayGanador = false;
        } else {
            ganador();
            hayGanador = true;
            plantarse = true;
        }
    }

    //Puntos a Sumar
    public void sumadorPuntos(int turno, int puntos) {
        switch (turno) {
            case 1: {
                J1 += puntos;
                break;
            }
            case 2: {
                J2 += puntos;
                break;
            }
            case 3: {
                J3 += puntos;
                break;
            }
            case 4: {
                J4 += puntos;
                break;
            }
            case 5: {
                J5 += puntos;
                break;
            }
            case 6: {
                J6 += puntos;
                break;
            }
        }
    }

    //Juego
    public void juego() {
        int puntos = 0;
        while (!plantarse) {
            if (valorDado != 6) {
                imprimirPuntajes(entradaJugadores);
                puntos += valorDado;
                System.out.println("El valor del dado es: " + valorDado);
                System.out.println("Ingrese [D] para lanzar, o [P] para plantarse: ");
                validadorEntrada = false; // Restablece validadorEntrada a false
                while (!validadorEntrada) {
                    String entrada = in.nextLine();
                    if (entrada.equalsIgnoreCase("D")) {
                        valorDado = tirarDado();
                        validadorEntrada = true;
                        hay_ganador();
                    } else if (entrada.equalsIgnoreCase("P")) {
                        sumadorPuntos(turno, puntos);
                        System.out.println("Ha decidido plantarse, avanza " + puntos + " casillas");
                        imprimirPuntajes(entradaJugadores);
                        puntos = 0;
                        cambioTurno();
                        valorDado = tirarDado();
                        hay_ganador();
                    } else {
                        System.out.println("Entrada inválida, vuelva a ingresar un valor");
                    }
                }
            }
            if (valorDado == 6) {
                imprimirPuntajes(entradaJugadores);
                puntos = 0;
                cambioTurno();
                validadorEntrada = true;
                System.out.println("El valor del dado es: " + valorDado);
                System.out.println("Fin del turno, sin puntos");
                valorDado = tirarDado();
                hay_ganador();
            }
        }
    }



    //Cantidad de Jugadores
    public void cantidadJugadores(){
        do {
            System.out.println("Por favor, ingresa un número entre 2 y 6:");
            String entrada = in.nextLine();

            try {
                entradaJugadores = Integer.parseInt(entrada);
                if (entradaJugadores >= 2 && entradaJugadores <= 6) {
                    break; // Salir del ciclo si el número está en el rango deseado
                } else {
                    System.out.println("Número fuera de rango. Debe estar entre 2 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
            }
        } while (true);
    }

    //Hay otro ronda?
    public void otraRonda() {
        System.out.println("Ingrese [R] para repetir y [S] para salir");
        String entradaRonda = in.nextLine();
        if (entradaRonda.equalsIgnoreCase("R")) {
            otraRonda = true;
        }
        if (entradaRonda.equalsIgnoreCase("S")) {
            otraRonda = false;
        }
    }

    //Cantidad final de ganadores
    public void ganadores(int entradaJugadoresValidada){
        System.out.println("Partidas ganadas:");
        switch (entradaJugadoresValidada) {
            case 2: {
                System.out.println("J1: " + J1G + " J2: " + J2G);
                break;
            }
            case 3: {
                System.out.println("J1: " + J1G + " J2: " + J2G + " J3: " + J3G);
                break;
            }
            case 4: {
                System.out.println("J1: " + J1G + " J2: " + J2G + " J3: " + J3G + " J4: " + J4G);
                break;
            }
            case 5: {
                System.out.println("J1: " + J1G + " J2: " + J2G + " J3: " + J3G + " J4: " + J4G + " J5: " + J5G);
                break;
            }
            case 6: {
                System.out.println("J1: " + J1G + " J2: " + J2G + " J3: " + J3G + " J4: " + J4G + " J5: " + J5G + " J6: " + J6G);
                break;
            }
        }
    }

    //Método Final
    public void Ronda(){
        System.out.println("=== Inicio de la partida ===");
        cantidadJugadores();
        while(otraRonda){
            while (!hayGanador) {
                valorDado = tirarDado();
                juego();
                System.out.println("¡La ronda ha terminado!");
                otraRonda();
            }
        }
        System.out.println("=== Fin de la partida ===");
        ganadores(entradaJugadores);
    }

}




