package Ejercicio2;
import PackFabo.*;
public class Ej2 {
    public static void main(String[] args) {
        //          A
        //        /   \
        //       B     C
        //        \
        //         D
        ArbolBinario<String> a =new ArbolBinario("A");
        ArbolBinario<String> b =new ArbolBinario("B");
        ArbolBinario<String> c =new ArbolBinario("C");
        ArbolBinario<String> d =new ArbolBinario("D");
        a.agregarHijoIzquierdo(b);
        a.agregarHijoDerecho(c);
        b.agregarHijoDerecho(d);

        System.out.println("Su arbol tiene "+a.contarNodos()+" nodos");
        System.out.println("Su arbol tiene "+a.contarHojas()+" hojas");
        System.out.println("Su arbol tiene una altura de "+a.altura());
        System.out.println("-------INORDEN--------");
        a.printInorden();
        System.out.println("-------POSTORDEN-------");
        a.printPostorden();
        System.out.println("-------PREORDEN--------");
        a.printPreorden();
        System.out.println("-------POR NIVELES------");
        a.printPorNiveles();
        System.out.println("-------ENTRE NIVELES-----");
        a.entreNiveles(1,2);

        ArbolBinario<String> arbolEspejo = a.espejo();
        System.out.println("----PREORDEN ESPEJO---");
        arbolEspejo.printPreorden();

        if(a.esLleno()){
            System.out.println("ES LLENO");
        }else{
            System.out.println("NO ES LLENO");
        }
    }
}