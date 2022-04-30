package Ejercicio2;
import PackFabo.*;

public class ArbolBinarioEj2<T> {
	private T dato;
	private ArbolBinarioEj2<T> hijoIzquierdo;
	private ArbolBinarioEj2<T> hijoDerecho;

	public ArbolBinarioEj2() {
		super();
	}

	public ArbolBinarioEj2(T dato) {
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
	public ArbolBinarioEj2<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinarioEj2<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinarioEj2<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinarioEj2<T> hijo) {
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
			return  1;
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


    public ArbolBinarioEj2<T> espejo() {
		if(this.esVacio()){
			return new ArbolBinarioEj2<>();
		}
		else{
			ArbolBinarioEj2<T> espejoAbb = new ArbolBinarioEj2<T>(this.getDato());
			if (this.tieneHijoIzquierdo())
				espejoAbb.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			if (this.tieneHijoDerecho())
				espejoAbb.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			return espejoAbb;
		}
	}

	public void entreNiveles(int n, int m){
		int altura = 0;
		ColaGenerica<ArbolBinarioEj2<T>> cola= new ColaGenerica<>();
		ArbolBinarioEj2<T> arbol;
		cola.encolar(this);
		cola.encolar(null);

		if (n>=0 && m<=altura){
			while (!cola.esVacia()){
				arbol = cola.desencolar();
				if (arbol == null){ //Si llegue al final del nivel
					if (!cola.esVacia()){
						cola.encolar(null);
						altura++;
					}
				}
				else{
					if (n<=altura && altura<=m){
						System.out.println(arbol.getDato());
					}
					if (arbol.tieneHijoIzquierdo()){
						cola.encolar(arbol.getHijoIzquierdo());
					}
					if (arbol.tieneHijoDerecho()){
						cola.encolar(arbol.getHijoDerecho());
					}
				}
			}
		}
	}
}
