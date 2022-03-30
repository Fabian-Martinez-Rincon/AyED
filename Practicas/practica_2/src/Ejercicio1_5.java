import tp02.ejercicio1.*;
public class Ejercicio1_5 {
    //__________________________________________________
    public static void imprimirInverso(ListaDeEnteros l, int numero) {
        if (numero>0) {
            System.out.print(l.elemento(numero));
            numero--;
            imprimirInverso(l, numero);
        }
    }
    //__________________________________________________
    public static void main(String[] args) {
        ListaDeEnterosConArreglos L = new ListaDeEnterosConArreglos();
        L.agregarFinal(1);
        L.agregarFinal(3);
        L.agregarFinal(6);
        imprimirInverso(L,L.tamanio());
    }
}
