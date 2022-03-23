package practica1.src;
public class uno {
    public static void main(String[] args) {
        int a = 4;
        int b = 10;
        ImprimirFor(a,b);
        System.out.println();
        ImprimirWhile(a, b);
        System.out.println();
        imprimir(a, b);
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
