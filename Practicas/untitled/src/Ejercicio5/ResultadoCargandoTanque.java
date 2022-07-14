package Ejercicio5;
import PackDeCosas.*;
public class ResultadoCargandoTanque<T> {
    private ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
    private int cantNafta;
    private int cantCargada;
    
    public int getCantCargada() {
        return cantCargada;
    }

    public void setCantCargada(int cantCargada) {
        this.cantCargada = cantCargada;
    }

    public int getCantNafta() {
        return cantNafta;
    }

    public void setCantNafta(int cantNafta) {
        this.cantNafta = cantNafta;
    }
     
    public ListaGenerica<T> getLista() {
        return lista;
    }

    public void setLista(ListaGenerica<T> lista) {
        this.lista = lista;
    }
   
}    
