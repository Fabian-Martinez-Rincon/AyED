package PackDeCosas;
public class ArbolGeneral<T> {
    private T dato;
    private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
        if (hijos==null)
                this.hijos = new ListaEnlazadaGenerica<>();
        else
                this.hijos = hijos;
    }

    public ArbolGeneral(T dato) {
        this.dato = dato;
    }

    public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
        this(dato);
        if (hijos==null)
            this.hijos = new ListaEnlazadaGenerica<>();
        else
            this.hijos = hijos;
    }

    public ListaGenerica<ArbolGeneral<T>> getHijos() {
        return this.hijos;
    }

    public void agregarHijo(ArbolGeneral<T> unHijo) {
        this.getHijos().agregarFinal(unHijo);
    }

    public boolean esHoja() {
        return !this.tieneHijos();
    }

    public boolean tieneHijos() {
        return !this.hijos.esVacia();
    }

    public boolean esVacio() {
        return this.dato == null && !this.tieneHijos();
    }

    public void eliminarHijo(ArbolGeneral<T> hijo) {
        if (this.tieneHijos()) {
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            if (hijos.incluye(hijo)) 
                hijos.eliminar(hijo);
        }
    }

    private void preOrdenDevuelveLista(ListaGenerica<T> L){
        L.agregarFinal(this.getDato());
        ListaGenerica<ArbolGeneral<T>> Lhijos = this.getHijos();
        Lhijos.comenzar();
        while(!Lhijos.fin())
            Lhijos.proximo().preOrdenDevuelveLista(L);
    }
    public ListaEnlazadaGenerica<T> preOrdenDevuelveLista(){
        ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
        this.preOrdenDevuelveLista(lista);
        return lista;
    }

//-------------TODOS LOS IMPRIMIR---------------------
    
    public void preOrden(){
        System.out.println(this.getDato());
        ListaGenerica<ArbolGeneral<T>> Lhijos= this.getHijos();
        Lhijos.comenzar();
        while(!Lhijos.fin())
            Lhijos.proximo().preOrden();
    }
    
    public void postOrden(){
        ListaGenerica<ArbolGeneral<T>> Lhijos= this.getHijos();
        Lhijos.comenzar();
        while(!Lhijos.fin())
            Lhijos.proximo().preOrden(); 
        System.out.println(this.getDato());
    }
    public void inOrden(){
        ListaGenerica<ArbolGeneral<T>> hijos;
        if(!this.esVacio()) {		
            hijos = this.getHijos();
            hijos.comenzar();
            if(this.tieneHijos()) {
                this.getHijos().proximo().inOrden(); // Me quedo con el primer elemento (el HI)		
            }		
            System.out.println(this.getDato());
            while (!hijos.fin()) { // A este while ya entra con el 2do elemento de la lista
                hijos.proximo().inOrden();
            }
        }	
    }

//---------------------------------------------------
    public Integer altura(){
        // Falta implementar..
        return 0;
    }

    public Integer nivel(T dato){
        // falta implementar
        return -1;
    }

    public Integer ancho(){
        // Falta implementar..
        return 0;
    }

}