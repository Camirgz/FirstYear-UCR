import java.util.Random;

public class BolsaDinosaurios {

    String bolsa_de_dinosaurios = "ttttttttvvvvvvvvaaaaaaaabbbbbbbbddddddddssssssss";

    public void primeraRonda() {

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

        //Salida
        System.out.println("Letras seleccionadas en la primera ronda: " + letrasSeleccionadas);
        System.out.println("Bolsa de dinosaurios actualizada: " + bolsa_de_dinosaurios);
    }

    public static void main(String[] args) {
        BolsaDinosaurios juego = new BolsaDinosaurios();
        juego.primeraRonda();
    }
}
