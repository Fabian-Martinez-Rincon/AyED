package Ejercicio5;
import PackDeCosas.*;
public class ResultadoVertices<T> {
    private ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
    private int cantVertices;

    public ListaGenerica<T> getLista() {
        return lista;
    }

    public void setLista(ListaGenerica<T> lista) {
        this.lista = lista;
    }

    public int getCantVertices() {
        return cantVertices;
    }

    public void setCantVertices(int cantVertices) {
        this.cantVertices = cantVertices;
    }
    
    
}

