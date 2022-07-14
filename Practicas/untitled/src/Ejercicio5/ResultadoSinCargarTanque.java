package Ejercicio5;
import PackDeCosas.*;
public class ResultadoSinCargarTanque<T> {
    private ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
    private int cantNafta;

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
