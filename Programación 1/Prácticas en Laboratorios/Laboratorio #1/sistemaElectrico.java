import java.util.Scanner;
public class sistemaElectrico{
    public static void main (String args []){

        Scanner in = new Scanner (System.in);

        float V = in.nextFloat();

        float R = in.nextFloat();

        System.out.println(V/R);
    }
}
