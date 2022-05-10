<h1 align="center">☕Practica N°4 </h1>

### ```Objetivos```

- Modelar un árbol n-ario
- Realizar recorridos sobre árboles generales
- Implementar ejercicios de aplicación sobre árboles generales.

### ```Importante:```

Se recomienda continuar trabajando dentro del proyecto AyED y generar paquetes y subpaquetes para esta práctica.

Descargue el archivo **tp04_ag.zip** El archivo zip descargado desde la página de la cátedra no es un proyecto eclipse, por lo tanto:

- `1)` Descomprima el archivo zip.
- `2)` Sobre la carpeta src de su proyecto AyED haga click con el botón derecho del mouse y seleccione la opción Import > FileSystem.
- `3)` Haga click en “Browse”, busque la carpeta descomprimida y seleccione la carpeta tp04_ag (haga click para que aparezca el check seleccionado). 
- `4)` Haga click en el botón finalizar.


### `Ejercicio 1` 

Considere la siguiente especificación de la clase **ArbolGeneral** (con la representación de **Lista de Hijos**)


<div align="center"> 
<img src="https://user-images.githubusercontent.com/55964635/165874058-09457e1d-bf45-4be2-a944-781d6da9c582.png"/>

``NOTA:`` La clase **Lista** es la utilizada en la práctica 2.

 </div>

El constructor `ArbolGeneral(T dato)` inicializa un árbol que tiene como raíz un nodo general. Este nodo tiene el dato pasado como parámetro y una lista vacía.

El constructor `ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos)` inicializa un árbol que tiene como raíz un nodo general. Este nodo tiene el dato pasado como parámetro y tiene como hijos la lista pasada como parámetro.

El método `getDato():T` retorna el dato almacenado en la raíz del árbol.

El método `getHijos():ListaGenerica<ArbolGeneral<T>>`, retorna la lista de hijos de la raíz del árbol.

El método `agregarHijo(ArbolGeneral<T> unHijo)` agrega unHijo a la lista de hijos del árbol

El método `eliminarHijo(ArbolGeneral<T> unHijo)` elimina unHijo del árbol.

El método `tieneHIjos()` devuelve verdadero si la lista de hijos del árbol no es null y tampoco es vacía 

El método `esVacio()` devuelve verdadero si el dato del árbol es null y además no tiene hijos.

Los métodos `altura(), nivel(T) y ancho()` se resolverán en el ejercicio 4. 

Analice la implementación en JAVA de las clases `ArbolGeneral` brindadas por la cátedra


### `Ejercicio 2` 

- `a)` ¿Qué recorridos conoce para recorrer en profundidad un árbol general? Explique brevemente.

<details>

<summary>📚 Resolución</summary>
<br/>

Para recorrer un árbol no vacío en orden de profundidad-primero, hay que realizar las siguientes operaciones recursivamente en cada nodo:

1. Realice la operación pre-orden
2. Para i=1 a n-1 haga
    1. Visite al hijo[i], si existe
    2. Realice la operación in-orden
3. Visite al hijo[n], si existe
4. Realice la operación post-orden

N = nro. de hijos .

</details>

- `b)` ¿Qué recorridos conoce para recorrer por niveles un árbol general? Explique brevemente.


<details>
<summary>📚 Resolución</summary>
<br/>

PseudoCodigo: 

```
public ListaGenerica<T> porNiveles(ArbolGeneral<T> arbol) {
 ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
 ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 ArbolGeneral<T> arbol_aux;
 cola.encolar(arbol);
 while (!cola.esVacia()) {
	 arbol_aux = cola.desencolar();
	 result.agregarFinal(arbol_aux.getDato());
	 if (arbol_aux.tieneHijos()) {
		 ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
		 hijos.comenzar();
		 while (!hijos.fin()) {
				cola.encolar(hijos.proximo());
		 }
	 }
 }
 return result;
}
```

Java: 

```Java
public ListaGenerica<T> porNiveles(ArbolGeneral<T> arbol) {
 ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
 ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 ArbolGeneral<T> arbol_aux;
 cola.encolar(arbol);
 while (!cola.esVacia()) {
	 arbol_aux = cola.desencolar();
	 result.agregarFinal(arbol_aux.getDato());
	 if (arbol_aux.tieneHijos()) {
		 ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
		 hijos.comenzar();
		 while (!hijos.fin()) {
				cola.encolar(hijos.proximo());
		 }
	 }
 }
 return result;
}
```

</details>

- `c)` ¿Existe alguna diferencia entre los recorridos preorden, postorden, inorden para recorrer los árboles generales respecto de los árboles binarios? Justifique su respuesta.

<details>

<summary>📚 Resolución</summary>
<br/>

Se diferencia en que se tienen recorrer listas sin saber su cantidad de nodos, en cambio en los arboles Binarios sabemos que cada nodo posee 2 hijos como máximo. Por esto mismo el Inorden toma de criterio recorrer primero el 1er elemento de la lista, su raíz, y luego los restantes de la lista. Con los demás sucede lo mismo se elijen criterios para printear toda la lista de hijos ya que no existe derecho o izquierdo.

</details>

- `d)` ¿Existe alguna noción de orden entre los elementos de un árbol general? Justifique su respuesta.

<details>
<summary>📚 Resolución</summary>
<br/>
Eso dependera de la politica utilizada y la necesidad que poseas para utilizar el arbol.
</details>

- `e)` En un árbol general se define el `grado de un nodo` como el número de hijos de ese nodo y el `grado del árbol` como el máximo de los grados de los nodos del árbol. ¿Qué relación encuentra entre los Árboles Binarios sin tener en cuenta la implementación? Justifique su respuesta

<details>
<summary>📚 Resolución</summary>
<br/>

Encontrar el grado de un árbol general será buscar cual nodo tiene mayor cantidad de hijos no habiendo limite alguno , en cambio en un árbol binario el máximo grado que puede poseer el árbol va a ser 2 . 

</details>

### `Ejercicio 3` 

- `a)` Implemente en la clase `RecorridosAG` los siguientes métodos:

```Java
public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral <Integer> a, Integer n)
```

Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros, recorrido en preorden.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.preOrden(lis, a, n);
		return lis;
	}

private void preOrden(ListaGenerica<Integer> l, ArbolGeneral<Integer> a, Integer n) {
		if (a.getDato() % 2 == 1 && a.getDato() > n) {
			l.agregarFinal(this.getDato());
		}
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = this.getHijos();
			lHijos.comenzar();
			while (!lHijos.fin()) {
				(lHijos.proximo()).preOrden(l,a,n);
			}
		}
	}
```

</details>

```Java
public ListaGenerica<Integer> numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n)
```



Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros, recorrido en inorden.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, int n) {
		ListaEnlazadaGenerica<Integer> lis = new ListaEnlazadaGenerica<Integer>();
		this.inOrden(lis, a, n);
		return lis;
	}

	private void inOrden(ListaGenerica<Integer> l, ArbolGeneral<Integer> a, int n) {
		if (a.tieneHijos()) { //Mientras tenga hijos 
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos(); //Obtenerlos
			lHijos.comenzar(); //Poner el puntero al inicio
      inOrden(l,lHijos.proximo(),n); // LLamar a este procedimiento hasta el ultimo nivel 
		}
		if ((int)(a.getDato()) % 2 == 1 && (int)(a.getDato()) > n) { //Al salir printeara el primer hijo a la izquierda y la raiz
			l.agregarFinal(a.getDato());
		}
		if (a.tieneHijos()) { //Printeo los restantes hijos 
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			while (!lHijos.fin()) {
				inOrden(l,lHijos.proximo(),n);
			}
		}
	}
```

</details>

```Java
public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral <Integer> a, Integer n)
```

Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros recorrido en postorden.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral <Integer> a, int n){
		ListaEnlazadaGenerica<Integer> lis = new ListaEnlazadaGenerica<Integer>();
		this.posOrden(lis,a,n);
		return lis;
	}
	private void posOrden(ListaGenerica<Integer> l,ArbolGeneral <Integer> a, int n) {
		if(a.tieneHijos()){
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			while (!lHijos.fin()) {
				posOrden(l,lHijos.proximo(),n);
			}
		}
		if ((int)(a.getDato()) % 2 == 1 && (int)(a.getDato()) > n) {
			l.agregarFinal(a.getDato());
		}
   }
```

</details>

```Java
public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral <Integer> a, Integer n)
```

Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros, recorrido por niveles.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneralInt<Integer> a, Integer n) {
		ListaGenerica<Integer> result = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneralInt<Integer>> cola = new ColaGenerica<ArbolGeneralInt<Integer>>();
		ArbolGeneralInt<Integer> arbol_aux;
		cola.encolar(arbol);
		while (!cola.esVacia()) {

			arbol_aux = cola.desencolar();
			if (arbol_aux.getDato().intValue() % 2 == 1 && arbol_aux.getDato().intValue() > n)
				result.agregarFinal(arbol_aux.getDato());

			if (arbol_aux.tieneHijos()) {
				ListaGenerica<ArbolGeneralInt<Integer>> hijos = arbol_aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		return result;
	}
```

</details>

### `Ejercicio 4` 

Implemente en la clase `ArbolGeneral` los siguientes métodos

- `a)` **public int altura(): int** devuelve la altura del árbol, es decir, la longitud del camino más largo desde el nodo raíz hasta una hoja.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public Integer altura() {
		int i = -1;
		if (esHoja()) 
			return 0;
		else {
			if(tieneHijos()){
				ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
				lhijos.comenzar();
				while (!lhijos.fin()){
					i = Math.max(i,lhijos.proximo().altura());
				}
			}
		}
		return i +1;
	}
```

</details>

- `b)` **public int nivel(T dato)** devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo es la longitud del único camino de la raíz al nodo.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public int nivel(Integer dato) {
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
        ArbolGeneral<Integer> aux;

        cola.encolar(this);
        cola.encolar(null);

        int nivel = 0;

        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                if (aux.getDato() == dato) {
                    return nivel;
                }
                if (aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Integer>> lhijos = aux.getHijos();
                    lhijos.comenzar();
                    while (!lhijos.fin()) {
                        cola.encolar(lhijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                nivel++;
            }
        }
        return -1;
    }
```

</details>

- `c)` **public int ancho(): int** la amplitud (ancho) de un árbol se define como la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public int ancho() {
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
        ArbolGeneral<Integer> aux;

        cola.encolar(this);
        cola.encolar(null);

        int cantidad = 0, max = -1, nivel = 0;

        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                cantidad = cantidad + 1;
                if (aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Integer>> lhijos = aux.getHijos();
                    lhijos.comenzar();
                    while (!lhijos.fin()) {
                        cola.encolar(lhijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                nivel++;
                if (cantidad > max) {
                    max = cantidad;
                }
                cantidad = 0;
            }
        }
        return max;
    }
```

</details>


### `Ejercicio 5` 

El esquema de comunicación de una empresa está organizado en una estructura jerárquica, en donde cada nodo envía el mensaje a sus descendientes. Cada nodo posee el tiempo que tarda en transmitir el mensaje. 

<div align="center"> 
<img src="https://user-images.githubusercontent.com/55964635/165876426-6d51cc9e-6afa-4e52-9688-2896e0af1965.png"/>

``NOTA:`` La clase **Lista** es la utilizada en la práctica 2.

 </div>

Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.

Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. Por lo tanto, debe devolver 16.

- `a)` Indique y justifique qué tipo de recorrido utilizará para resolver el problema.
- `b)` Implementar en una clase AnalizadorArbol, el método con la siguiente firma:

```Java
public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>arbol)
```

Donde `AreaEmpresa` es una clase que representa a un área de la empresa mencionada y que contiene la identificación de la misma representada con un `String` y una tardanza de transmisión de mensajes interna representada con `int`.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
        int max = -1, candidato = 0, cant = 0,nivel = 0;;

        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
        ArbolGeneral<AreaEmpresa> arbol_aux; //AUXILIAR
 
        cola.encolar(arbol); // ENCOLO EL PASADO POR PARAMETRO
        cola.encolar(null);
        while (!cola.esVacia()) { //MIENTRAS NO SEA VACIA LA COLA CON ARBOLES
            arbol_aux = cola.desencolar();
            if (arbol_aux != null) {
              candidato = candidato + arbol_aux.getDato().getTardanza();
              cant++;
	              if (arbol_aux.tieneHijos()) {
	                  ListaGenerica<ArbolGeneral<AreaEmpresa>> lhijos = arbol_aux.getHijos();
	                  lhijos.comenzar();
	
	                  while (!lhijos.fin()) {
	                      cola.encolar(lhijos.proximo());
	                  }
	             }
	            } else {
                if (!cola.esVacia())
									 cola.encolar(null); //SEPARAR NIVEL
                nivel++;
                candidato = candidato / cant;
                if (max < candidato) 
                    max = candidato;
                
                cant = 0;
                candidato = 0;
            }

        }
        return max;
    }
```

</details>


### `Ejercicio 6` 

Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m.\
Se dice que un nodo n es descendiente de un nodo m si existe un camino desde m a n.\
Implemente un método en la clase ArbolGeneral con la siguiente firma:

**public Boolean esAncestro(T a, T b):** devuelve true si el valor a es ancestro del valor b.

El cual determine si un valor a es ancestro de un valor b. 

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public Boolean esAncestro(Integer a, Integer b) {
        boolean encontreA = false;

        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
        cola.encolar(this);
        cola.encolar(null);
        while(!cola.esVacia()){
            ArbolGeneral<Integer> arbol = cola.desencolar();
            if(arbol != null){
                if(arbol.getDato() == a){
                    encontreA = true;
                    while(!cola.esVacia()){
                        cola.desencolar();//Nos deshacemos de los  anteriores pq no interesan 
                    }
                }else if(encontreA && arbol.getDato() == b){
                    return true;
                }
                if(arbol.tieneHijos()){
                    ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
                    hijos.comenzar();
                    while(!hijos.fin()){
                        cola.encolar(hijos.proximo());
                }
            }
            }else{
								if (!cola.esVacia())
	                cola.encolar(null);
            }
            
        }
        return false;
    }
```

</details>

### `Ejercicio 7` 

Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo sucesivamente hasta llegar a cada una de las casas.\
Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo con
las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas. Es decir,
si un caño maestro recibe 1000 litros y tiene por ejemplo 4 bifurcaciones se divide en 4 partes iguales,
donde cada división tendrá un caudal de 250 litros.\
Luego, si una de esas divisiones se vuelve a dividir, por ej. en 5 partes, cada una tendrá un caudal de
50 litros y así sucesivamente hasta llegar un lugar sin bifurcaciones.

Se debe implementar una clase `RedDeAguaPotable` que contenga el método con la siguiente firma:

```Java
public double minimoCaudal(double caudal)
```

que calcule el caudal de cada nodo y determine cuál es el mínimo caudal que recibe una casa. Asuma
que la estructura de caños de la red está representada por una variable de instancia de la clase
RedAguaPotable y que es un ArbolGeneral.

Extendiendo el ejemplo en el siguiente gráfico, al llamar al método minimoCaudal con un valor de 1000.0
debería retornar 25.0

<div align="center"> 
<img src="https://user-images.githubusercontent.com/55964635/165877407-d0f16e13-54dc-4079-aa1b-f26314fa57cb.png"/>

 </div>

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
public double minimoCaudal(double caudal){
        Double min = 9999.999;
        if(estructura.tieneHijos()){
            ListaGenerica<ArbolGeneral<Double>> lHijos = estructura.getHijos();
            //le damos valor a cada hijo
            Double caudalHijo = caudal / lHijos.tamanio();
            for (int i = 1;i <= lHijos.tamanio();i++ )  {
                lHijos.elemento(i).setDato(caudalHijo);
            }          
            lHijos.comenzar();
            while (!lHijos.fin()){
                RedDeAguaPotable redHijo = new RedDeAguaPotable(lHijos.proximo());
                //Comparo cual es menor
                min = Math.min(redHijo.minimoCaudal(caudalHijo), min);
            }
            return min;
            
        }else {
            //System.out.println("HOJA QUE RETORNO " + estructura.getDato());
            return estructura.getDato();
        } // EL MAXIMO ES LA RAIZ U HOJA
    }
```

</details>