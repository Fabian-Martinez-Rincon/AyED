<h1 align="center">Teoria</h1>

## [Objetivos de la materia]()

- Analizar algoritmos y evaluar su eficiencia
- Estudiar estructuras de datos avanzadas: su implementación y aplicaciónes

## [Estructuras de Datos]()

- Los programas reciben, procesan y devuelven datos.
- Necesidad de organizar los datos de acuerdo al problema que vamos a resolver.
- Los programas reciben, procesan y devuelven datos.
- Necesidad de organizar los datos de acuerdo al problema que vamos a resolver

## [Objetivos del curso respecto de las estructuras de Datos]()

- Aprender a implementar las estructuras de datos usando abstracción
- Estudiar diferentes representaciones e implementaciones para las estructuras de datos
- Aprender a elegir la "mejor" estructura de datos para cada problema

## [Algoritmos y su Análisis]()

- ¿Qué es un algoritmo?
  - Es una secuencia de pasos que resuelven un problema
  - Es independiente del lenguaje de programación
- Existen varios algoritmos que resuelven correctamente un problema
- La elección de un algoritmo particular tiene un enorme impacto en el tiempo y la memoria que utiliza.

``
La elección de un algoritmo y de la estructura de datos para resolver un problema son independientes
``

## [Objetivos del curso respecto del Análisis de los Algoritmos]()

- Entender los fundamentos matemáticos necesarios para analizar algoritmos.
- Aprender a comparar la eficiencia de diferentes algoritmos en términos del tiempo de ejecución.
- Estudiar algunos algoritmos estándares para el manejo de las estructuras de datos y aprender a usarlos para resolver nuevos problemas.

## [Problemas y algoritmos]()

### Problemas

- Buscar un elemento en un arreglo
- Ordenar una lista de elementos 
- Encontrar el camino minimo entre dos puntos (Encontrar el algoritmo que lo resuelve)

## [Buscar un elemento en un arreglo]()

El arreglo puede estar: 
- Desordenado
- Ordenado

Si esta ***desordenado*** se usa una ```Busqueda secuencial```

![image](https://user-images.githubusercontent.com/55964635/158110397-7c7f6ec4-da1d-4422-bf5f-8ee31c334af1.png)

```Java
public static int seqSearch(int[] a, int key)
{
  int index = -1;
  for (int i = 0; i < N; i++)
    if (key == a[i])
      index = i;
  return index;
}
```

