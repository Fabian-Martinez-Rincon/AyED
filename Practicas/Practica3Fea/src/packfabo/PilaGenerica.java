package packfabo;

public class PilaGenerica<T> {
    //__________________________________________________
    private final ListaGenerica<T> pila;

    public PilaGenerica(){
       pila = new ListaEnlazadaGenerica<T>();
    }

    public void apilar(T elem){
        pila.agregarFinal(elem);    
    }
    public T desapilar(){
        T elemento = this.tope();
        pila.eliminarEn(1); //Elimino el primer elemento y despues lo retorno uwu
        return elemento;
    }
    public T tope(){
        return pila.elemento(1);
    }
    public boolean esVacia(){
        return pila.esVacia();
    }
}