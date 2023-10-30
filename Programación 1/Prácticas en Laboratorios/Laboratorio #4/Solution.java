import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file = "";
        String line = "";
        String nombreRepositorio = in.nextLine();
        while (in.hasNext()) {
            line = in.nextLine();
            if (line.equals("")) break;
            file += line + "\n";
        }
        String[] params = file.split("\n");
        Repositorio register = new Repositorio(nombreRepositorio, params);
        String movie = in.nextLine();
        double score = Double.parseDouble(in.nextLine());
        register.registrarCalificacion(movie, score);
        register.imprimirInformacion(movie);
        System.out.printf("Promedio general: %.2f", register.obtenerPromedioGeneral());
    }
}
