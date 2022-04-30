package packfabo;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int contHI = 0, contHD = 0;
		if (esHoja()){
			return contarHojas = 1;
		}
		else {
			if(tieneHijoIzquierdo()){
				contHI = this.getHijoIzquierdo().contarHojas();
			}
			if(tieneHijoDerecho()){
				contHD = this.getHijoDerecho().contarHojas();
			}
		}
		return contHD + contHI;
	}
	
    public ArbolBinario<T> espejo() {
		if (esVacio()){
			return new ArbolBinario();
		}
		else{
			ArbolBinario<T> espejoAbb = new ArbolBinario<T>(this.getDato());//Le paso la raiz
			if (this.tieneHijoIzquierdo()){
				espejoAbb.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			}
			if (this.tieneHijoDerecho()){
				espejoAbb.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			}
			return espejoAbb;
		}
	}


	public void entreNiveles(int n, int m){
		int altura = 0;
		ArbolBinario <T> arbol;
		ColaGenerica<ArbolBinario> cola = new ColaGenerica<ArbolBinario>();
		cola.encolar(this);
		cola.encolar(null);
		
	}

	

}

