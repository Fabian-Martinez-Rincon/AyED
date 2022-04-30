package Ejercicio4;
import PackFabo.*;
public class Ej4 {
    public static void main(String[] args) {
        //           14
        //         /    \
        //        53     2
        //       / \    / \
        //      12  9  33 102
        ArbolBinario<Integer> catorce =new ArbolBinario(14);
        ArbolBinario<Integer> cincuentaYTres =new ArbolBinario(53);
        ArbolBinario<Integer> dos =new ArbolBinario(2);
        ArbolBinario<Integer> doce =new ArbolBinario(12);
        ArbolBinario<Integer> nueve = new ArbolBinario(9);
        ArbolBinario<Integer> treintaYTres =new ArbolBinario(33);
        ArbolBinario<Integer> cientoDos =new ArbolBinario(102);

        catorce.agregarHijoIzquierdo(cincuentaYTres);
        catorce.agregarHijoDerecho(dos);
        cincuentaYTres.agregarHijoIzquierdo(doce);
        cincuentaYTres.agregarHijoDerecho(nueve);
        dos.agregarHijoIzquierdo(treintaYTres);
        dos.agregarHijoDerecho(cientoDos);

        RedBinariaLlena red = new RedBinariaLlena();
        System.out.println("El mayor retardo es de "+red.retardoReenvio(catorce)+" segs");
    }
}