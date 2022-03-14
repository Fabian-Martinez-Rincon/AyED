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
¿Cuantas comparaciones hace?

Si esta ***ordenado*** se usa una ```Busqueda binaria``` 

Comparo la clave con la entrada del centro

- Si es menor, voy hacia la izquierda
- Si es mayor, voy hacia la derecha
- Si es igual, la encontré

![image (1)](https://user-images.githubusercontent.com/55964635/158111409-3f002c61-9261-454d-ba76-d2f8fd1d0ca6.png)


```Java
public static int binarySearch(int[] a, int key)
{
  int lo = 0, hi = a.length-1;
  while (lo <= hi)
   {
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) hi = mid - 1;
    else if (key > a[mid]) lo = mid + 1;
    else return mid;
   }
  return -1;
}
```
¿Cuantas comparaciones hace?

|  | Busqueda Secuencial | Busqueda Binaria |
| :---         |     :---:      |          ---: |
|    N      |     Cantidad de operaciones      |          Cantidad de operaciones |
| 1000         |     1000      |          ~10 |
| 2000   | 2000    | ~11    |
| 4000     | 4000       | ~12      |
| 8000     | 8000       | ~13      |
| 16000     | 16000       | ~14     |
|      | Hace N operaciones       | Hace log(N) operaciones     |

[Log sub 2 online](https://miniwebtool.com/es/log-base-2-calculator/#:~:text=La%20base%20logar%C3%ADtmica%202%2C%20tambi%C3%A9n,binario%20de%204%20es%202.)

## [¿Como medir el tiempo?]()

- En forma empírica (Se realiza a posteriori)
- En forma teórica (Se realiza a priori) 

### Análisis empírico

Correr el programa para varios tamaños de la entrada y medir el tiempo. Suponemos que cada comparación tarda 1 seg

|  | Busqueda Secuencial | Busqueda Binaria |
| :---         |     :---:      |          ---: |
|    N      |     Tiempo(seg)      |          Tiempo(seg) |
| 1000         |     1000      |          ~10 |
| 2000   | 2000    | ~11    |
| 4000     | 4000 ~1 hs       | ~12      |
| 8000     | 8000 ~2 hs       | ~13      |
| 16000     | 16000 ~4 hs   | ~14     |

### Analisis de Algoritmos

![image (2)](https://user-images.githubusercontent.com/55964635/158115649-3f0713d4-caa8-4591-b833-e8b1d5ccc1e8.png)

## [Buscar un elemento en una lista dinámica]()

Si los elementos están almacenados en una lista dinámica

La lista puede estar:
- Desordenada
- Ordenada

![image (3)](https://user-images.githubusercontent.com/55964635/158118424-9ba89679-d6de-4dec-a028-0fe2c9088dcc.png)

## [Análisis de Algoritmos]()

Marco para predecir la performance y comparar algoritmos

Desafio:

Escribir programas que puedan resolver en forma eficiente problemas con una gran entrada de los datos

![image (4)](https://user-images.githubusercontent.com/55964635/158118790-e56875b9-a5f5-46db-a0a8-803fbe56f2e1.png)

Existe un modelo matemático para medir el tiempo

Tiempo total:

Suma del ***costo x frecuencia*** de todas las operaciones

- Es necesario analizar el algoritmo para determinar el conjunto de operaciones

```Costo``` depende de la máquina, del compilador, del lenguaje

```Frecuencia``` depende del algoritmo y de la entrada
