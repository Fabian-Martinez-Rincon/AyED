Ejercicio_1
===========
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

Ejercicio_2
===========
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
Ejercicio_3
===========
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
Ejercicio_4
===========
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
        swap1(a,b);
        swap2(c,d);
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c + " d=" + d) ;
    }
            
}
```
Ejercicio_5
===========
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