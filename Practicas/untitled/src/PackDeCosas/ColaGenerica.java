package PackDeCosas;
public class ColaGenerica<T>{
    private final ListaGenerica<T> cola;
    
    public ColaGenerica(){
        this.cola= new ListaEnlazadaGenerica<>();
    }

    /**public ColaGenerica(ListaGenerica cosito T cosito tipoDeLista){ //CONSTRUCTOR donde especificio
        this.cola=tipoDeLista;                            //por parametro el tipo de lista
    }**/
    
    public void encolar(T elem){ //Agrega elem a la cola.
        cola.agregarFinal(elem);
    }
    public T desencolar(){ //Elimina y devuelve el primer elemento de la cola.
        T elem = tope(); //me guardo el elemento que voy a eliminar
        cola.eliminarEn(1);
        return elem; //retorno el elemento que borre
    }
    public T tope(){ //Devuelve el elemento en el tope de la cola sin eliminarlo
        return cola.elemento(1);
    }
    public boolean esVacia(){
        return cola.esVacia();
    }
    
}
