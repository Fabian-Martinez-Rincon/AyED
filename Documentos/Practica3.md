<h1 align="center">☕Practica N°3 </h1>

***Importante***Puede continuar trabajando en su proyecto AyED. El archivo zip descargado desde la página de la cátedra no es un proyecto eclipse, por lo tanto:

- `1)` Descomprima el zip
- `2)` Sobre la carpeta **src** de su proyecto AyED haga click con el botón derecho del mouse y seleccione la opción Import > FileSystem.
- `3)` Haga click en “Browse”, busque la carpeta descomprimida y seleccione la carpeta src (haga click para que aparezca el check seleccionado).
- `4)` Haga click en el botón finalizar.

### ```Objetivos```

- Representar árboles binarios e implementar las operaciones de la abstracción
- Realizar distintos tipos de recorridos sobre árboles binarios
- Describir soluciones utilizando árboles binarios

### `Ejercicio 1` [Resolución](#Ejercicio_1)

Considere la siguiente especificación de la clase Java **ArbolBinario** (con la representación hijo izquierdo e hijo derecho)

<div align="center"> 
<img src="./img/practica3_1.png"/>
 </div>

- El constructor **ArbolBinario(T dato)** inicializa un árbol con el dato pasado como parámetro y ambos hijos nulos.

- Los métodos **getHijoI<quierdo():ArbolBinario<T>** y **getHijoDerecho:ArbolBinario<T>** , retornan los hijos izquierdo y derecho respectivamente del árbol.

- El método **agregarHijoIzquierdo(ArbolBinario<T> unHijo)** y **agregarHijoDerecho(ArbolBinario<T> unHijo)** agrega un hijo como hijo izquierdo o derecho del árbol.

- El método **eliminarHijoIzquierdo()** y **eliminarHijoDerecho()**, eliminan el hijo correspondiente.
- El método **esVacio()** indica si el árbol está vacío y el método **esHoja()** no tiene hijos.
- El método **tieneHijoIzquierdo()** y **tieneHijoDerecho()** devuelven un booleano indicando si tiene dicho hijo el árbol receptor del mensaje

``a)``  Analice la implementación en JAVA de las clases **ArbolBinario** brindadas por la cátedra.

### `Ejercicio 2` [Resolución](#Ejercicio_2)

Agregue a la clase **ArbolBinario** los siguientes métodos:

- `a)`  **contarHojas():int** Devuelve la cantidad de árbol/subárbol hojas del árbol receptor. 

```Java
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
```

- `b)` **espejo(): ArbolBinario<T>** Devuelve el árbol binario espejo del árbol receptor. Por ejemplo:



<div align="center"> 
<img src="https://user-images.githubusercontent.com/55964635/165864472-abf91dfe-2c90-4b5b-9b94-f3eaeb626494.png"/>
 </div>

```Java
public ArbolBinario<T> espejo() {
	if(this.esVacio()){
		return new ArbolBinario<>();
	}
	else{
		ArbolBinario<T> espejoAbb = new ArbolBinario<T>(this.getDato());
		if (this.tieneHijoIzquierdo())
			espejoAbb.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		if (this.tieneHijoDerecho())
			espejoAbb.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		return espejoAbb;
	}
}
```

- `c)` **entreNiveles(int n, m)** Imprime el recorrido por niveles de los elementos del árbol
receptor entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)

```Java
	public void entreNiveles(int n, int m){
		int altura = 0;
		ColaGenerica<ArbolBinario<T>> cola= new ColaGenerica<>();
		ArbolBinario <T> arbol;
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
```

### `Ejercicio 3` [Resolución](#Ejercicio_3)

Defina una clase Java denominada `ContadorArbol` cuya función principal es proveer métodos de validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un `ArbolBinario<Integer>`. Implemente en dicha clase un método denominado `numerosPares()` que devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del árbol (divisibles por 2). Defina la clase dentro del paquete `tp03.ejercicio3`.

- `a)` Implemente el método realizando un recorrido `InOrden`
- `b)` Implemente el método realizando un recorrido `PostOrden`

### `Ejercicio 4` [Resolución](#Ejercicio_4)

Una red binaria es una red que posee una topología de árbol binario lleno. Por ejemplo:

<div align="center"> 
<img src="https://user-images.githubusercontent.com/55964635/165870883-2c23dd28-d41e-4574-8b2c-5d666f31974e.png"/>
 </div>


Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre que un nodo recibe un mensaje y lo reenvía a sus dos hijos

Su tarea es calcular el <ins>mayor</ins> retardo posible, en el camino que realiza un mensaje desde la raíz hasta llegar a las hojas en una red binaria llena.

```
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado
en cantidad de segundos.
```

- `a)` Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el problema.
- `b)` Cree una clase Java llamada `RedBinariaLlena` (dentro del paquete `tp03.ejercicio4`) donde implementará lo solicitado en el método `retardoReenvio():int`.

### `Ejercicio 5` [Resolución](#Ejercicio_5)

Implemente una clase Java llamada `ProfundidadDeArbolBinario` que tiene como variable de instancia un árbol binario de números enteros y un método de instancia `sumaElementosProfundidad(int p):int` el cuál devuelve la suma de todos los nodos del árbol que se encuentren a la profundidad pasada como argumento.

Defina la clase dentro del paquete `tp03.ejercicio5`

Ejercicio_1
-----------

```Java
package tp03.ejercicio1;

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
		return 0;
	}
	
    public ArbolBinario<T> espejo() {
		
		return null;
	}

	public void entreNiveles(int n, int m){
		
	}
}
```

Ejercicio_2
-----------

```Java
package tp03.ejercicio1;
import PackFabo.*;

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


    public ArbolBinario<T> espejo() {
		if(this.esVacio()){
			return new ArbolBinario<>();
		}
		else{
			ArbolBinario<T> espejoAbb = new ArbolBinario<T>(this.getDato());
			if (this.tieneHijoIzquierdo())
				espejoAbb.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			if (this.tieneHijoDerecho())
				espejoAbb.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			return espejoAbb;
		}
	}

	public void entreNiveles(int n, int m){
		int altura = 0;
		ColaGenerica<ArbolBinario<T>> cola= new ColaGenerica<>();
		ArbolBinario <T> arbol;
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
```

Para_Probar
===========
```Java
package Ejercicio2;
import PackFabo.*;
public class Ej2 {
    public static void main(String[] args) {
        //          A
        //        /   \
        //       B     C
        //        \
        //         D
        ArbolBinario<String> a =new ArbolBinario("A");
        ArbolBinario<String> b =new ArbolBinario("B");
        ArbolBinario<String> c =new ArbolBinario("C");
        ArbolBinario<String> d =new ArbolBinario("D");
        a.agregarHijoIzquierdo(b);
        a.agregarHijoDerecho(c);
        b.agregarHijoDerecho(d);

        System.out.println("Su arbol tiene "+a.contarNodos()+" nodos");
        System.out.println("Su arbol tiene "+a.contarHojas()+" hojas");
        System.out.println("Su arbol tiene una altura de "+a.altura());
        System.out.println("-------INORDEN--------");
        a.printInorden();
        System.out.println("-------POSTORDEN-------");
        a.printPostorden();
        System.out.println("-------PREORDEN--------");
        a.printPreorden();
        System.out.println("-------POR NIVELES------");
        a.printPorNiveles();
        System.out.println("-------ENTRE NIVELES-----");
        a.entreNiveles(1,2);

        ArbolBinario<String> arbolEspejo = a.espejo();
        System.out.println("----PREORDEN ESPEJO---");
        arbolEspejo.printPreorden();

        if(a.esLleno()){
            System.out.println("ES LLENO");
        }else{
            System.out.println("NO ES LLENO");
        }
    }
}
```

Ejercicio_3
-----------

```Java
package Ejercicio3;
import PackFabo.*;

public class ContadorArbol {
    private ListaEnlazadaGenerica<Integer> paresPostOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista){
        if (arbol.tieneHijoIzquierdo()){
            paresPostOrden(arbol.getHijoIzquierdo(),lista);
        }
        if (arbol.tieneHijoDerecho()){
            paresPostOrden(arbol.getHijoDerecho(),lista);
        }
        if ((arbol.getDato() % 2) == 0){
            lista.agregarFinal(arbol.getDato());
            //lista.agregarInicio(arbol.getDato()); Esto tambien se podria?
        }
        return lista;
    }
    private ListaEnlazadaGenerica<Integer> paresInOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista){
        if (arbol.tieneHijoIzquierdo()){
            paresInOrden(arbol.getHijoIzquierdo(),lista);
        }
        if ((arbol.getDato() % 2) == 0){
            lista.agregarFinal(arbol.getDato());
            //lista.agregarInicio(arbol.getDato()); Esto tambien se podria?
        }
        if (arbol.tieneHijoDerecho()){
            paresInOrden(arbol.getHijoDerecho(),lista);
        }
        return lista;
    }
    private ListaEnlazadaGenerica<Integer> numerosParesPostOrden(ArbolBinario<Integer> arbol){
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        this.paresPostOrden(arbol, lista);
        return lista;
    }
    private ListaEnlazadaGenerica<Integer> numerosParesInOrden(ArbolBinario<Integer> arbol){
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        this.paresInOrden(arbol, lista);
        return lista;
    }
}
```

Para_Probar
===========

```Java
package Ejercicio3;
import PackFabo.*;
public class Ej3 {
    public static void main(String[] args) {
        //          14
        //         /  \
        //        53   2
        //       /    / \
        //      12   33 102
        //Creo los nodos
        ArbolBinario<Integer> num14 =new ArbolBinario(14);
        ArbolBinario<Integer> num53 =new ArbolBinario(53);
        ArbolBinario<Integer> num2 =new ArbolBinario(2);
        ArbolBinario<Integer> num12 =new ArbolBinario(12);
        ArbolBinario<Integer> num33 =new ArbolBinario(33);
        ArbolBinario<Integer> num102 =new ArbolBinario(102);

        //Los agrego segun el arbol que tengo entre comentarios arriba
        num14.agregarHijoIzquierdo(num53);
        num14.agregarHijoDerecho(num2);
        num53.agregarHijoIzquierdo(num12);
        num2.agregarHijoIzquierdo(num33);
        num2.agregarHijoDerecho(num102);

        //Solo los imprimo dependiendo del orden
        System.out.println("---PARES DEL POSTORDEN---");
        ContadorArbol cont = new ContadorArbol();
        ListaEnlazadaGenerica<Integer> lista =cont.numerosParesPostOrden(num14);
        lista.comenzar();
        while(!lista.fin()){
            System.out.println(lista.proximo());
        }

        System.out.println("---PARES DEL INORDEN---");
        ListaEnlazadaGenerica<Integer> lista2 =cont.numerosParesInOrden(num14);
        lista2.comenzar();
        while(!lista2.fin()){
            System.out.println(lista2.proximo());
        }
    }
}
```

Ejercicio_4
-----------

```Java
package Ejercicio4;
import PackFabo.ArbolBinario;
public class RedBinariaLlena {
    private static ArbolBinario<Integer> arbol = new ArbolBinario<>();
    public void setArbol(ArbolBinario<Integer> arbol) {
        RedBinariaLlena.arbol = arbol;
    }
    public static ArbolBinario<Integer> getArbol() {
        return arbol;
    }
    public static int retardoReenvio(ArbolBinario <Integer> arbol){
        int HI,HD,max;
        if (arbol.esHoja()){
            return arbol.getDato();
        }else{
            HI=retardoReenvio(arbol.getHijoIzquierdo());
            HD=retardoReenvio(arbol.getHijoDerecho());
            max=Math.max(HI,HD);
            return max+arbol.getDato();
        }
    }
}
```
Para_Probar
===========

```Java
package Ejercicio4;
import PackFabo.*;
public class Ej4 {
    public static void main(String[] args) {
        //           14
        //         /    \
        //        53     2
        //       / \    / \
        //      12  9  33 102
        ArbolBinario<Integer> catorce =new ArbolBinario(14);
        ArbolBinario<Integer> cincuentaYTres =new ArbolBinario(53);
        ArbolBinario<Integer> dos =new ArbolBinario(2);
        ArbolBinario<Integer> doce =new ArbolBinario(12);
        ArbolBinario<Integer> nueve = new ArbolBinario(9);
        ArbolBinario<Integer> treintaYTres =new ArbolBinario(33);
        ArbolBinario<Integer> cientoDos =new ArbolBinario(102);

        catorce.agregarHijoIzquierdo(cincuentaYTres);
        catorce.agregarHijoDerecho(dos);
        cincuentaYTres.agregarHijoIzquierdo(doce);
        cincuentaYTres.agregarHijoDerecho(nueve);
        dos.agregarHijoIzquierdo(treintaYTres);
        dos.agregarHijoDerecho(cientoDos);

        RedBinariaLlena red = new RedBinariaLlena();
        System.out.println("El mayor retardo es de "+red.retardoReenvio(catorce)+" segs");
    }
}
```

Ejercicio_5
-----------

```Java
package Ejercicio5;
import PackFabo.*;
public class ProfundidadDeArbolBinario {
    private ArbolBinario<Integer> arbol;
    private void setArbol(ArbolBinario<Integer> arbol){
        this.arbol = arbol;
    }
    //Cuando encuentra el nivel no sigue con los otros niveles
    public int sumaElementosProfundidad(int p){
        ColaGenerica <ArbolBinario<Integer>> cola = new ColaGenerica<>();
        ArbolBinario <Integer> arbolito;
        int contNivel=0,suma=0;
        cola.encolar(arbol);
        cola.encolar(null);
        if (p <= arbol.altura()){
            while(!cola.esVacia()){
                arbolito=cola.desencolar();
                if(arbolito != null){
                    if (contNivel == p){
                        while(arbolito != null){
                            suma+=arbolito.getDato();
                            arbolito=cola.desencolar();
                        }
                    } else{
                        if(arbolito.tieneHijoIzquierdo())
                            cola.encolar(arbolito.getHijoIzquierdo());
                        if(arbolito.tieneHijoDerecho())
                            cola.encolar(arbolito.getHijoDerecho());
                    }
                }else if (!cola.esVacia()){
                    contNivel++;
                    cola.encolar(null);
                }
            }
            return suma;
        } else return -1;
    }
}

```

Para_Probar
===========
```Java
package Ejercicio5;
import PackFabo.*;
public class Ej5 {
    public static void main(String[] args) {
        //           14
        //         /    \
        //        53     2
        //       / \    / \
        //      12  9  33 102
        ArbolBinario<Integer> num14 =new ArbolBinario(14);
        ArbolBinario<Integer> num53 =new ArbolBinario(53);
        ArbolBinario<Integer> num2 =new ArbolBinario(2);
        ArbolBinario<Integer> num12 =new ArbolBinario(12);
        ArbolBinario<Integer> num9 = new ArbolBinario(9);
        ArbolBinario<Integer> num33 =new ArbolBinario(33);
        ArbolBinario<Integer> num102 =new ArbolBinario(102);

        num14.agregarHijoIzquierdo(num53);
        num14.agregarHijoDerecho(num2);
        num53.agregarHijoIzquierdo(num12);
        num53.agregarHijoDerecho(num9);
        num2.agregarHijoIzquierdo(num33);
        num2.agregarHijoDerecho(num102);

        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
        prof.setArbol(num14);
        System.out.println("La suma del nivel 0 es: "+prof.sumaElementosProfundidad(0));
        System.out.println("La suma del nivel 1 es: "+prof.sumaElementosProfundidad(1));
        System.out.println("La suma del nivel 2 es: "+prof.sumaElementosProfundidad(2));
        System.out.println("La suma del nivel 3 es: "+prof.sumaElementosProfundidad(3));
    }
}
```