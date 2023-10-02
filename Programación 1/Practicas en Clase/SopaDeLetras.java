//Clase 2 de Otubre, Matrices, Sopa de Letras
public class SopaDeLetras {
    public static void main(String[] args) {
        int filas = 10;
        int cols = 12;

        char[][] sopa = new char[filas][cols];
        llenar(sopa);
        imprimir(sopa);
    }

    public static void imprimir(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void llenar(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (char) ((int) (Math.random() * 26) + 65);
            }
        }
    }

    public static void insertarID (char[][] mat, String palabra){
        if(palabra.length() <= mat[0].length){
            int filaAleatoria = (int)(Math.random()*mat.length);
            int colAleatoria = (int) (Math.random()*mat[filaAleatoria].length);
            if(colAleatoria + palabra.length() < mat[filaAleatoria].length){

            }
        }
    }


}//Fin de Toda la Clase
