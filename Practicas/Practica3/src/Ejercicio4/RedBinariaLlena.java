package Ejercicio4;
import PackFabo.ArbolBinario;
public class RedBinariaLlena {
    private static ArbolBinario<Integer> arbol = new ArbolBinario<>();
    public void setArbol(ArbolBinario<Integer> arbol) {
        RedBinariaLlena.arbol = arbol;
    }
    public static ArbolBinario<Integer> getArbol() {
        return arbol;
    }
    public static int retardoReenvio(ArbolBinario <Integer> arbol){
        int HI,HD,max;
        if (arbol.esHoja()){
            return arbol.getDato();
        }else{
            HI=retardoReenvio(arbol.getHijoIzquierdo());
            HD=retardoReenvio(arbol.getHijoDerecho());
            max=Math.max(HI,HD);
            return max+arbol.getDato();
        }
    }
}