package PackFabo;

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
            this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
        else
            this.hijos = hijos;
    }

    public ArbolGeneral(T dato) {
        this.dato = dato;
    }

    public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
        this(dato);
        if (hijos==null)
            this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
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

    //ejercicio 4
    public Integer altura() {
        Integer alt=0;
        if (!this.esHoja()) {
            ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
            lHijos.comenzar();
            while(!lHijos.fin()) {
                alt = 1 + lHijos.proximo().altura();
            }
        }else
            return 1;
        return alt;
    }



	/*public Integer nivel(T dato) {
		Integer nivel = 0;
		if(!this.esVacio()) {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			if(this.getDato().equals(dato)) return nivel;
			if(!lHijos.fin()) {
				nivel = 1 + lHijos.proximo().nivel(dato);
			}
		}
		return nivel;
	}*/

    public Integer nivel(T dato) {
        Integer nivel = 0;
        ArbolGeneral<T> arbol=null;
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
        cola.encolar(this);
        cola.encolar(null);
        while(!cola.esVacia()) {
            arbol = cola.desencolar();
            if(arbol !=null) {
                if(arbol.getDato().equals(dato)) return nivel;
                ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
                lHijos.comenzar();
                while(!lHijos.fin()) {
                    cola.encolar(lHijos.proximo());
                }
            }else if(!cola.esVacia()) {
                cola.encolar(null);
                nivel++;
            }
        }
        return -1;
    }
    public Integer ancho() {
        Integer ancho = -1;
        Integer cantNodos = 0;
        ArbolGeneral<T> arbol=null;
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
        cola.encolar(this);
        cola.encolar(null);
        while(!cola.esVacia()) {
            arbol = cola.desencolar();
            if(arbol !=null) {
                ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
                lHijos.comenzar();
                cantNodos++;
                while(!lHijos.fin()) {
                    cola.encolar(lHijos.proximo());
                }
                if(cantNodos > ancho) ancho=cantNodos;
            }else if(!cola.esVacia()) {
                cola.encolar(null);

                cantNodos = 0;
            }
        }
        return ancho;
    }

    //ejercicio 3
    public ListaEnlazadaGenerica<T> preOrden(){
        ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
        this.preOrden(l);
        return l;
    }
    private void preOrden(ListaGenerica<T> l) {
        //raiz, hijos
        l.agregarFinal(this.getDato());
        ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
        lHijos.comenzar();
        while(!lHijos.fin()) {
            (lHijos.proximo()).preOrden(l);
        }
    }

    public ListaEnlazadaGenerica<T> posOrden(){
        ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
        this.posOrden(l);
        return l;
    }
    private void posOrden(ListaGenerica<T> l) {
        //hijos, raiz
        ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
        lHijos.comenzar();
        while(!lHijos.fin()) {
            (lHijos.proximo()).posOrden(l);
        }
        l.agregarFinal(this.getDato());
    }

    public ListaEnlazadaGenerica<T> inOrden(){
        ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
        this.inOrden(l);
        return l;

    }
    private void inOrden(ListaGenerica<T> l) {
        //primer hijo, raiz, resto de hijos
        //11 1 12 0 2 3
        ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
        lHijos.comenzar();
        if(!lHijos.esVacia()) lHijos.proximo().inOrden(l);
        l.agregarFinal(this.getDato());
        while(!lHijos.fin()) {
            (lHijos.proximo()).inOrden(l);
        }
    }


    public ListaEnlazadaGenerica<T> recorridoPorNiveles (){
        ListaEnlazadaGenerica<T> l = new ListaEnlazadaGenerica<T>();
        this.recorridoPorNiveles(l);
        return l;
    }

    private void recorridoPorNiveles(ListaGenerica<T> l) {
        ArbolGeneral<T> arbol=null;
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
        cola.encolar(this);
        cola.encolar(null);
        while(!cola.esVacia()) {
            arbol = cola.desencolar();
            if(arbol !=null) {
                l.agregarFinal(arbol.getDato());
                ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
                lHijos.comenzar();
                while(!lHijos.fin()) {
                    cola.encolar(lHijos.proximo());
                }
            }else if(!cola.esVacia()) {
                cola.encolar(null);
            }
        }
    }

    //ejercicio6
    public Boolean esAncestro(T a, T b) {
        {
            boolean es = false;

            ArbolGeneral<T> arbol = null;
            ColaGenerica<ArbolGeneral<T>> cola =  new ColaGenerica<ArbolGeneral<T>>();

            ListaEnlazadaGenerica<T> descendientesA = new ListaEnlazadaGenerica<T>();

            cola.encolar(this);
            cola.encolar(null);

            // recorremos por niveles hasta encontrar a A
            // una vez lo encontramos obtenemos una lista de sus descendientes
            while(!cola.esVacia()){
                arbol = cola.desencolar();
                if(arbol != null){
                    if(a == arbol.getDato()){
                        // recuperamos los descendientes y vaciamos la cola
                        descendientesA = arbol.posOrden();
                        while(!cola.esVacia()){
                            cola.desencolar();
                        }
                    }
                    ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
                    hijos.comenzar();
                    while(!hijos.fin()){cola.encolar(hijos.proximo());}
                }else if(!cola.esVacia()){
                    cola.encolar(null);
                }
            }

            // una vez recuperamos los descendientes de A con A inclusive verificamos si esta B
            // no comparamos i <= tama�o pq esa es la raiz, osea A
            for(int i = 1; i < descendientesA.tamanio(); i++){
                if(descendientesA.elemento(i) == b){
                    es = true;
                }
            }
            return es;
        }
    }

}