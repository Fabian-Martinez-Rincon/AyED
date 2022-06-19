<h1 align="center">Analisis de Algoritmos</h1>

### *Indice*

- [Introducción al concepto T(n)](#Introducción_al_concepto_T(n))
- [Cálculo del T(n)]()

### Introducción


Nos permite comparar algoritmos en forma independiente de una plataforma en particular. Mide la eficiencia de un algoritmo, dependiendo del tamaño de la entrada

#### Pasos a seguir

- Caracterizar los datos de entrada del algoritmo
- Identificar las operaciones abstractas, sobre las que se basa el algoritmo
- Realizar un análisis matemático, para encontrar los valores de las cantidades del punto anterior


### Introducción_al_concepto_T(n)

![](/Documentos/Img2/1.png)

Debemos enfocarnos en cuán rápido crece una función T(n) respecto al tamaño de la entrada. A esto lo llamamos la **tasa o velocidad de crecimiento** del tiempo de
ejecución.

### `Ejemplo`

supongamos que un algoritmo, que corre con una entrada de tamaño n, tarda `6n2+100n+300` instrucciones de máquina. El término `6n2` se vuelve más grande que el resto de los términos, `100n+300` una vez que n se hace suficientemente grande, 20 en este caso

Gráfica que muestra los valores de `6n2` y de `100n+300` para valores de n de 0 a 100:

![](/Documentos/Img2/2.png)


$$(n) = cte_{1}+\sum_{i=1}^{(n+1)/2} 

= cte_{1}+ cte_{2}/2 * (n+1) = 0(n)$$


- [En donde pude procesar las formulas](https://www.codecogs.com/eqnedit.php)