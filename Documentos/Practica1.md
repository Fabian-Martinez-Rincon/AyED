<h1 align="center">☕Practica N°1 </h1>

#### **Nota: Crea un proyecto llamado ```Practica1B``` para guardar todas las clases que implementes en esta práctica. Se recomienda crear un paquete por cada ejercicio.**

```1)``` Escriba tres **métodos de clase (static)** que reciban por parámetro dos números enteros (tipo **int**) a y b e impriman todos los números enteros comprendidos entre a;b (inclusive), uno por cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por cada uno de los siguientes incisos: 

- ``a)`` Que realice lo pedido por un **for**.
- ``b)`` Que realice lo pedido por un **while**.
- ``c)`` Que realice lo pedido **sin utilizar estructuras de control iterativas** (for, while, do while).

Por último, escriba en el método de clase **main** el llamado a cada uno de los métodos creados, con valores de ejemplo.

En su computadora, **ejecute el programa** y verifique que se cumple con todo lo pedido.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
package practica1.src;
import java.util.Scanner;
public class uno {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in) ;
        System.out.print("Ingrese un nro: ");
        int a = escaner.nextInt();

        System.out.print("Ingrese otro nro: ");
        int b = escaner.nextInt();
        ImprimirFor(a,b);
        System.out.println();
        ImprimirWhile(a, b);
        System.out.println();
        imprimir(a, b);
        escaner.close();
    }
    public static void ImprimirFor(int a, int b){
        for(int i=a; i<=b; i++){
            System.out.println(i);
        }
        
    }
    public static void ImprimirWhile(int a, int b){
        int i = a;
        while(i<=b){
            System.out.println(i);
            i++;
        }
    }
    public static void imprimir(int a, int b){
        if(a<=b){
            System.out.println(a);
            a++;
            imprimir(a, b);
        }
    }
}
```

</details>

```2)``` Escriba un método de clase que dado un número **n** devuelva un nuevo arreglo de tamaño **n** primeros múltiplos enteros de **n** mayores o iguales que 1. 

- ``Ejemplo: f(5) = [5, 10, 15, 20, 25] ; f(k) = {nk/k: 1..k}``

Agregue al programa la posibilidad de probar con distintos valores de **n** ingresándolos por teclado, mediante el uso de System.in. La clase **Scanner** permite leer de forma sencilla valores de entrada.

**Ayuda:** Como ejemplo de uso, para contar la cantidada de números leídos hasta el primer 42 se puede hacer:

```Java
import java.util.Scanner;
public class Contador {
    public static int contar42 ( ) {
        Scanner s = new Scanner(System.in) ;
        int cantidad = 1 ;
        while (s.nextInt() != 42) {
            cantidad++;
        }
        return cantidad;
    }
}
```

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
package practica1.src;
import java.util.Scanner;
public class dos {
    public static void main(String[] args){
        Scanner escaner = new Scanner(System.in) ;
        System.out.print("Ingrese un nro: ");
        int numero = escaner.nextInt();
        int []multiplos = new int[numero];
        multiplos = CalcularMultiplos(numero);
        for(int i = 0; i<numero; i++){
            System.out.println((i+1)+ ")" + multiplos[i]);
        }
        escaner.close();
    }
    public static int[] CalcularMultiplos(int num){
        int[] VecMultiplos = new int[num];
        for(int i=0; i<num; i++){
            VecMultiplos[i] = num * (i+1);
        }
        return VecMultiplos;
    }
}
```

</details>

```3)``` Creación de instancias mediante el uso del operador new. 

```a)``` Cree una clase llamada **Estudiante** con los atributos especificados abajo y sus correspondientes métodos getters y setters (haga uso de las facilidades que brinda eclipse)

- Nombre
- Apellido
- Comisión
- Email
- Dirección

```b)``` Cree una clase llamada **Profesor** con los atributos especificados abajo y sus correspondientes métodos getters y setters (haga uso de las facilidades que brinda eclipse)
- Nombre
- Apellido
- Email
- Catedra
- Facultad

```c)``` Agregue un método de instancia llamado **tusDatos()** en la clase **Estudiante** y en la clase **Profesor**, que retorne un **String** con los datos de los atributos de las mismas. Para acceder a los valores de los atributos **utilice los getters previamente definidos**-

```d)``` Escriba una clase llamada **Test** con el método **main**, el cual cree un arreglo con **2** objetos **Estudiante**, otro arreglo con **3** objetos **Profesor**, y luego recorra ambos arreglos imprimiendo los valores obtenidos mediante el método **tusDatos()**. Recuerde asignar los valores a los atributos de los objetos **Estudiante** y **Profesor** invocando los respectivos métodos setters. 

```e)``` Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la línea donde itera sobre los profesores.

```f)``` Ejecute el **Test** en modo debug y avance **paso a paso** visualizando si estudiante o el profesor recuperado es lo esperado.

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
package practica1.src;

public class tres {
    public static void main(String[] args) {
        Estudiante[] EstArray = new Estudiante[2];
        Profesor[] ProArray = new Profesor[3];
        EstArray[0] = new Estudiante("Fabian", "Martinez", "1b","gmail.com","74/23");
        EstArray[1] = new Estudiante("Fabo", "Martin Garrix", "1a","hotmail.com","123");

        ProArray[0] = new Profesor("Carlos","Menem","gmail.com","ideas","unlp");
        ProArray[1] = new Profesor("Pepe","Lotas","hotmail.com","ideas","unlp");
        ProArray[2] = new Profesor("Roberto","Tototo","mail.com","ideas","unlp");
        
        System.out.println("Estudiantes:");
        for(int i=0; i<2;i++){
            System.out.println(EstArray[i].tusDatos());
        }
        System.out.println("Profesores:");
        for(int i=0; i<3;i++){
            System.out.println(ProArray[i].tusDatos());
        }
    }
}
```

</details>

```4)``` ¿Qué imprime el siguiente programa al ejecutar **main**?
- ```a)``` Intente averiguarlo sin ejecutar el programa en su computadora.
- ```b)``` Ejecute el ejercicio en su computadora, y compare su resultado con lo esperado en el inciso anterior. 

```Java
public class SwapValores {
    public static void swap1 (int x, int y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }
    public static void swap2 (Integer x, Integer y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }
    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a,b);
        swap2(c,d);
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c + " d=" + d) ;
    }
}
```

- ```c)``` Inserte un breakpoint en las lineas donde se indica: ``y = tmp`` y ejecute en modo debug ¿los valores que adoptan las variables x, y coinciden con los valores impresos?

<details>

<summary>📚 Resolución</summary>
<br/>

```Java
package practica1.src;
public class cuatro {
    public static void swap1 (int x, int y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }
    public static void swap2 (Integer x, Integer y) {
        if (x < y) {
        int tmp = x ;
        x = y ;
        y = tmp;
        }
    }
    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a,b); //a = 1 b = 2 
        swap2(c,d); //c = 3 d = 4
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c + " d=" + d) ;
    }
            
}
```

</details>

```5)``` Dado un arreglo de valores tipo **int** se desea calcular el valor máximo, mínimo, y promedio de un único método. Escriba tres métodos de clase, donde respectivamente: 

- ```a)``` Devuelva lo pedido por el mecanismo de retorno de un método en Java (``return``)
- ```b)``` Devuelva lo pedido interactuando con algún parámetro
- ```c)```

<details>

<summary>📚 Resolución</summary>
<br/>

```java
package practica1.src;

public class cinco {
    public static int[] incisoA(int[] arreglo) {
        
        int[] array = new int[3];
        array[0] = -1;
        array[1] = 9999;
        array[2] = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i]>array[0]){
                array[0] = arreglo[i];  //Calculo el minimo en array[0]
            }
            if(arreglo[i]<array[1]){
                array[1] =  arreglo[i]; //Calculo el maximo en arra[1]
            }
            array[2]=array[2]+arreglo[i];   //Calculo el total en array[2]
        }
        array[2]=array[2]/arreglo.length;
        return array;
    }
    public static void MetodoB(IncisoB objetoB, int[] arreglo) {
        objetoB.setMax(-1);
        objetoB.setMin(9999);
        objetoB.setProm(0);

        for (int i=0; i<arreglo.length;i++){
            if(arreglo[i]>objetoB.getMax()){
                objetoB.setMax(arreglo[i]);
            }
            if(arreglo[i]>objetoB.getMin()){
                objetoB.setMin(arreglo[i]);
            }
            objetoB.setProm(objetoB.getProm()+arreglo[i]);
        }
        objetoB.setProm(objetoB.getProm()/arreglo.length);
    }
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4};
        int[] arregloA= new int[3];
        arregloA = incisoA(arreglo);
        for(int i=0; i<3;i++) {
			System.out.println(arregloA[i]);
		}

        IncisoB ObjetoB = new IncisoB();
        MetodoB(ObjetoB,arreglo);
        System.out.println(ObjetoB.toString());
    }
}
```

</details>

