package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class PilaGenerica<T> {
    //__________________________________________________
    private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();

    public void apilar(T elem){
        datos.agregarFinal(elem);    
    }
    public T desapilar(){
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