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

    //DinoValidador
    public boolean dinovalidador(char dino, String cartas) {

        for (int i = 0; i <cartas.length(); i++ ){
            char indiceCartas = cartas.charAt(i);
            if (dino == indiceCartas) {
                return true;
            }
        }
        System.out.println("Entrada de dinosaurio inválida");
        return false;
    }

    //ZonaValidador
    public boolean zonaValidador(int zona){
        if (zona <= 6 && zona > 0){
            return true;
        }
        System.out.println("Selección de zona inválida");
        return false;
    }



}
