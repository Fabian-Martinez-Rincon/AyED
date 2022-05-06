package tp02.ejercicio3;
import tp02.ejercicio2.*;
public class ColaGenerica<T> {
    //__________________________________________________
    private ListaGenerica<T> datos = new ListaEnsalzadaGenerica<T>();

    public void encontar(T elem){
        datos.agregarFinal(elem);    
    }
    public T desencolar(){
        T elemento = this.tope();
        datos.eliminarEn(1); //Elimino el primer elemento y despues lo retorno uwu
        return elemento;
    }
    public T tope(){
        return datos.elemento(1);
    }
    public boolean esVacia(){
        return datos.esVacia();
    }
}

