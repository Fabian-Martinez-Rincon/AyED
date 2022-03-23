package practica1.src;
import java.util.Scanner;
public class uno {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in) ;
        System.out.print("Ingrese un nro: ");
        int a = escaner.nextInt();

        System.out.print("Ingrese otro nro: ");
        int b = escaner.nextInt();
        ImprimirFor(a,b);
        System.out.println();
        ImprimirWhile(a, b);
        System.out.println();
        imprimir(a, b);
        escaner.close();
    }
    public static void ImprimirFor(int a, int b){
        for(int i=a; i<=b; i++){
            System.out.println(i);
        }
        
    }
    public static void ImprimirWhile(int a, int b){
        int i = a;
        while(i<=b){
            System.out.println(i);
            i++;
        }
    }
    public static void imprimir(int a, int b){
        if(a<=b){
            System.out.println(a);
            a++;
            imprimir(a, b);
        }
    }
}
