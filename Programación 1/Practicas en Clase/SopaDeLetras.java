public class SopaDeLetras {
    public static void main(String[] args) {
        int filas = 10;
        int cols = 12;

        char[][] sopa = new char[filas][cols];
        llenar(sopa);
        insertarPalabra(sopa, "CAMI");
        imprimir(sopa);
    }

    // Crear tablero
    public static void imprimir(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
    }

    // Llenar de letras aleatorias
    public static void llenar(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (char) ((int) (Math.random() * 26) + 65);
            }
        }
    }

    // Insertar palabra
    public static void insertarPalabra(char[][] mat, String palabra) {
        if (palabra.length() <= mat[0].length) {
            int filaAleatoria = (int) (Math.random() * mat.length);
            int colAleatoria = (int) (Math.random() * (mat[filaAleatoria].length - palabra.length() + 1));

            for (int i = 0; i < palabra.length(); i++) {
                mat[filaAleatoria][colAleatoria + i] = palabra.charAt(i);
            }
        }
    }
}
