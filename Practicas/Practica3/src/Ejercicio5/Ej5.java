package Ejercicio5;
import PackFabo.*;
public class Ej5 {
    public static void main(String[] args) {
        //           14
        //         /    \
        //        53     2
        //       / \    / \
        //      12  9  33 102
        ArbolBinario<Integer> num14 =new ArbolBinario(14);
        ArbolBinario<Integer> num53 =new ArbolBinario(53);
        ArbolBinario<Integer> num2 =new ArbolBinario(2);
        ArbolBinario<Integer> num12 =new ArbolBinario(12);
        ArbolBinario<Integer> num9 = new ArbolBinario(9);
        ArbolBinario<Integer> num33 =new ArbolBinario(33);
        ArbolBinario<Integer> num102 =new ArbolBinario(102);

        num14.agregarHijoIzquierdo(num53);
        num14.agregarHijoDerecho(num2);
        num53.agregarHijoIzquierdo(num12);
        num53.agregarHijoDerecho(num9);
        num2.agregarHijoIzquierdo(num33);
        num2.agregarHijoDerecho(num102);

        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
        prof.setArbol(num14);
        System.out.println("La suma del nivel 0 es: "+prof.sumaElementosProfundidad(0));
        System.out.println("La suma del nivel 1 es: "+prof.sumaElementosProfundidad(1));
        System.out.println("La suma del nivel 2 es: "+prof.sumaElementosProfundidad(2));
        System.out.println("La suma del nivel 3 es: "+prof.sumaElementosProfundidad(3));
    }
}