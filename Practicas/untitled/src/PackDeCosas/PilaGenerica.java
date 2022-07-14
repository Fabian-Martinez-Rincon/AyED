package PackDeCosas;
public class PilaGenerica<T>{
    private final ListaGenerica<T> pila;
    
    /** public PilaGenerica(ListaGenerica<T> tipoDeLista){ //CONSTRUCTOR donde especifico
        this.pila=tipoDeLista;                             //por parametro el tipo de lista         
    }**/
    
    public PilaGenerica(){
        this.pila=new ListaEnlazadaGenerica<>();
    }
    
    public void apilar(T elem){ //Agrega elem a la pila
        pila.agregarFinal(elem);
    }
    public T desapilar(){
        if (!esVacia()){
            T elem=tope();
            pila.eliminarEn(1);
            return elem;
        }else{
            return null;
        }
    }
    public T tope(){
        return pila.elemento(1);
    }
    public boolean esVacia(){
        return pila.esVacia();
    }
}