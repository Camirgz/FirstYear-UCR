import java.util.Random;


public class BolsaDinosaurios {

    //Variable Inicial
    String bolsa_de_dinosaurios = "ttttttttvvvvvvvvaaaaaaaabbbbbbbbddddddddssssssss";

    //Metodo para elegir 6 especies de manera aleatoria
    public String primeraRonda() {

        //Variables
        String letrasSeleccionadas = "";
        Random random = new Random();

        //Extractor de letras
        for (int i = 0; i < 6; i++) {
            int indiceAleatorio = random.nextInt(bolsa_de_dinosaurios.length());
            char letra = bolsa_de_dinosaurios.charAt(indiceAleatorio);
            letrasSeleccionadas += letra;
            bolsa_de_dinosaurios = bolsa_de_dinosaurios.substring(0, indiceAleatorio) +
                    bolsa_de_dinosaurios.substring(indiceAleatorio + 1);
        }

        return letrasSeleccionadas;
    }

    public static void main(String[] args) {

        BolsaDinosaurios juego = new BolsaDinosaurios();

        String jugador1 = juego.primeraRonda();
        String jugador2 = juego.primeraRonda();

        System.out.println(jugador1);
        System.out.println(jugador2);
    }
}
