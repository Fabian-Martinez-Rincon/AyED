package Ejercicio3;
import PackFabo.*;
public class Ej3 {
    public static void main(String[] args) {
        //          14
        //         /  \
        //        53   2
        //       /    / \
        //      12   33 102
        //Creo los nodos
        ArbolBinario<Integer> num14 =new ArbolBinario(14);
        ArbolBinario<Integer> num53 =new ArbolBinario(53);
        ArbolBinario<Integer> num2 =new ArbolBinario(2);
        ArbolBinario<Integer> num12 =new ArbolBinario(12);
        ArbolBinario<Integer> num33 =new ArbolBinario(33);
        ArbolBinario<Integer> num102 =new ArbolBinario(102);

        //Los agrego segun el arbol que tengo entre comentarios arriba
        num14.agregarHijoIzquierdo(num53);
        num14.agregarHijoDerecho(num2);
        num53.agregarHijoIzquierdo(num12);
        num2.agregarHijoIzquierdo(num33);
        num2.agregarHijoDerecho(num102);

        //Solo los imprimo dependiendo del orden
        System.out.println("---PARES DEL POSTORDEN---");
        ContadorArbol cont = new ContadorArbol();
        ListaEnlazadaGenerica<Integer> lista =cont.numerosParesPostOrden(num14);
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }

        System.out.println("---PARES DEL INORDEN---");
        ListaEnlazadaGenerica<Integer> lista2 =cont.numerosParesInOrden(num14);
        lista2.comenzar();
        while(!lista2.fin()){
            System.out.println(lista2.proximo());
        }
    }
}
