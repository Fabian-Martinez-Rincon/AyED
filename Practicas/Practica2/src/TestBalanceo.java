import java.util.Scanner;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
public class TestBalanceo {
    public static boolean esBalanceado(String cadena) {
        ListaGenerica<Character> inicio = new ListaEnlazadaGenerica<Character>();
        inicio.agregarFinal('(');
        inicio.agregarFinal('[');
        inicio.agregarFinal('{');

        ListaGenerica<Character> cierre = new ListaEnlazadaGenerica<Character>();
        cierre.agregarFinal('(');
        cierre.agregarFinal('[');
        cierre.agregarFinal('{');

        PilaGenerica<Character> pila = new PilaGenerica<Character>();
        
        Character actual,elem;

        for (int i=0 ; i<cadena.length(); i++){
            actual = cadena.charAt(i);
            if (inicio.incluye(actual)){
                pila.apilar(actual);
            }
            else{
                elem = pila.desapilar();
                if (inicio.elemento(elem) != cierre.elemento(actual)) {
                    return false;
                }
            }

        }
        if (!pila.esVacia()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Solo puede ingresar los siguientes caracteres: ");
        System.out.println("{}[]() en el orden en el quiera: ");
		String cadena = consola.nextLine();
		consola.close();
  
        if (esBalanceado(cadena)){
            System.out.println("La expresion esta balanceada: " + cadena);
        }
        else 
            {
                System.out.println("La expresion no esta balanceada" );
            }
    }
}
