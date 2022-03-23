package practica1.src;
import java.util.Scanner;
public class dos {
    public static void main(String[] args){
        Scanner escaner = new Scanner(System.in) ;
        System.out.print("Ingrese un nro: ");
        int numero = escaner.nextInt();
        int []multiplos = new int[numero];
        multiplos = CalcularMultiplos(numero);
        for(int i = 0; i<numero; i++){
            System.out.println((i+1)+ ")" + multiplos[i]);
        }
        escaner.close();
    }
    public static int[] CalcularMultiplos(int num){
        int[] VecMultiplos = new int[num];
        for(int i=0; i<num; i++){
            VecMultiplos[i] = num * (i+1);
        }
        return VecMultiplos;
    }
}
