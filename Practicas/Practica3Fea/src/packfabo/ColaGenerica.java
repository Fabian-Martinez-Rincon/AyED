package packfabo;
public class ColaGenerica<T> {
    //__________________________________________________
    private final ListaGenerica<T> cola;

    public ColaGenerica(){
        this.cola= new ListaEnlazadaGenerica<>();
    }
    public void encolar(T elem){
        cola.agregarFinal(elem);    
    }
    public T desencolar(){
        T elemento = this.tope();
        cola.eliminarEn(1); //Elimino el primer elemento y despues lo retorno uwu
        return elemento;
    }
    public T tope(){
        return cola.elemento(1);
    }
    public boolean esVacia(){
        return cola.esVacia();
    }
}

