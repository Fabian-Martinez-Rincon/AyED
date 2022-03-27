<h1 align="center">☕Practica N°1 </h1>

**Importante:** Descargue el material disponible en el sitio de la cátedra. Se recomienda trabajar a partir de esta práctica en un mismo proyecto (**Ayed**) y crear un paquete por cada ejercicio.

### ```1)``` Considere la siguiente especificación de operaciones de una lista de enteros:

```Java
comenzar(): //Se prepara para iterar los elementosde la lista.
proximo(): //Devuelve el elemento actual y avanza al próximo elemento de la lista.
fin(): //Determina si llegó o no al final de la lista.
elemento(int pos): //Retorna el elemento de la posición indicada
agregarEn(Integer elem, int pos): //Agrega el elemento en la posición indicada y retorna true si pudo agregar y false; si no pudo agregar.
agregarInicio(Integer elem): //Agrega al inicio de la lista.
agregarFinal(Integer elem): //Agrega al final de la lista.
eliminar(Integer elem): //Elimina elem de la lista y retorna true si lo pudo hacer y false si no lo encuentra.
eliminarEn(int pos): //Elimina el elemento de la posición indicada y retorna true si lo pudo eliminar y false en caso contrario.
incluye(Integer elem): // Retorna true si elem está contenido en la lista, false en caso contrario.
esVacia(): //Retorna true si la lista está vacía, false en caso contrario.
tamanio(): //Retorna la cantidad de elementos.
```

![](/Documentos/img/1.png)

```1.1)``` Importe en Eclipse  **ListasDe Enteros.zip** dado por la cátedra usando la opción Import > Existing Proyects into Workspace, y luego click en ``Select archive file`` y seleccione al archivo .zip descargado. Para poder usar las listas de enteros y sus operaciones, en cada una de las declaraciones de clases se debe agregar **import tp02.ejercicio1.***;

```1.2)``` Escriba una clase llamada **TestListaDeEnterosConArreglos** que reciba en su método **main** una secuencia de números, los agregue a un objeto de tipo **ListaDeEnterosConArreglos** y luego imprima los elementos de dicha lista.

```1.3)``` Escriba una clase llamada **TestListaDeEnterosEnlazada** que reciba en su método **main** una secuencia de números, los agregue a un objeto de tipo **ListaDeEnterosEnlazada** y luego imprima los elementos de dicha lista.

```1.4)``` ¿Qué diferencia encuentra entre las implementaciones de los puntos anteriores?

```1.5)``` Escriba un método recursivo que imprima los elementos de una lista en sentido inverso. La lista la recibe por parámetro.

```1.6)``` se aplica la siguiente función de forma recursiva a partir de un número n positivo se obtiene un sucesión que termina en 1:  

![](/Documentos/img/2.png) 

Por ejemplo para n = 6, se obtiene la siguiente sucesión:

- 1) f(6) = 6/2 = 3
- 2) f(3) = 3*3 + 1 = 10
- 3) f(10) = 10/2 = 5
- 4) ... 

Es decir la sucesión 6, 3, 10, 5, 16, 8, 4, 2, 1. Para cualquier n con el que se arranque siempre se llegará al 1.

- ```a)```  Escriba un programa recursivo que, a partir de un número n, devuelva una lista con cada miembro de la sucesión.

```Java
public ListaDeEnterosEnlazada calcularSucesion (int n) {
    public class Ejercicio1_6 {
    //código
    }
}
```

**Sugerencia:** Primero modele el problema sin tener que devolver una lista

- ```b)``` Escriba un método main que pruebe el método implementado en a) y recorra la lista resultado e imprima cada uno de los elementos.

```Java
public class Ejercicio1_6 {
    ...
    public static void main (String[] args) {
        ListaDeEnterosEnlazada l = f. calcularSucesion(4);
        Ejercicio1_6 f = new Ejercicio1_6();
        //código que recorre e imprime los valores de l
    }
}
```

```1.7)``` Analice las implementaciones de la clase **ListaDeEnteros** y sus subclases.

- ```a)``` ¿Podría darle comportamiento a algún método de la superclase **ListaDeEnteros**? ¿Por qué la clase se define como abstracta? Note que una subclase implementa la lista usando un arreglo de tamaño fijo y la otra usando nodos enlazados.
- ```b)``` Considerando los enlaces entre nodos, ¿qué diferencias existen entre agregar un nodo al principio de la lista, agregar un nodo en el medio y agregar un nodo al final?

- ```c)``` Una lista implementada con arreglos, ¿tiene su primer elemento en el índice del vector: 0, 1 o depende de la implementación?

### ```2)``` **Tipos Genericos**

Considere la siguiente especificación de operaciones de listas genéricas:

