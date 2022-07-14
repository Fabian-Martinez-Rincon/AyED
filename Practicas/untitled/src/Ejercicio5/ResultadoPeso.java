package Ejercicio5;
import PackDeCosas.*;
public class ResultadoPeso<T> {
    private ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
    private int peso;

    public ListaGenerica<T> getLista() {
        return lista;
    }

    public void setLista(ListaGenerica<T> lista) {
        this.lista = lista;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
