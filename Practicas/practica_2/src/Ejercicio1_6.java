import tp02.ejercicio1.*;
public class Ejercicio1_6 {
    public static int calcular(int n) {
        if (n > 1){
            if (n % 2 == 0){
                n = n / 2;
            }
            else{
                n = 3*n+1;
            }
        }
        return n;
    }
    //__________________________________________________________
    public ListaDeEnterosEnlazada calcularSucesion (int n) {
        ListaDeEnterosEnlazada l;
        if (n > 1){
            l = calcularSucesion(calcular(n));
        }
        else{
            l = new ListaDeEnterosEnlazada();
        }
        l.agregarInicio(n);
        return l;
    }
    //__________________________________________________________
    public static void main(String[] args) {
        Ejercicio1_6 f = new Ejercicio1_6();
        ListaDeEnterosEnlazada L = f. calcularSucesion(4);
        //Imprimir
        
        L.comenzar();
        while (!L.fin()) {
            System.out.println(L.proximo());
        }
        
    }
    
}

/*
1.7)
*/
