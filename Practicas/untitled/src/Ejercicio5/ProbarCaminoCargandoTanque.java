package Ejercicio5;
import PackDeCosas.*;
public class ProbarCaminoCargandoTanque {
    public static void main(String[] args){
        //PRUEBA2
        //Paso 1 - Creacion del Grafo
        Grafo<String> grafo2 = new GrafoImplListAdy<>();

        //Paso 2 - Creacion de los nodos (vertices)
        Vertice<String> BuenosAires = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> LaPlata = new VerticeImplListAdy<>("La Plata");
        Vertice<String> Tokyo = new VerticeImplListAdy<>("Tokyo");
        Vertice<String> Berlin = new VerticeImplListAdy<>("Berlin");
        Vertice<String> Cordoba = new VerticeImplListAdy<>("Cordoba");

        //Paso 3 - Agregar vertices a la lista de vertices del grafo
        grafo2.agregarVertice(BuenosAires);
        grafo2.agregarVertice(LaPlata);
        grafo2.agregarVertice(Tokyo);
        grafo2.agregarVertice(Berlin);
        grafo2.agregarVertice(Cordoba);

        //Paso 4 - conectar los vertices
        grafo2.conectar(BuenosAires,LaPlata,10);
        grafo2.conectar(BuenosAires,Berlin,30);
        grafo2.conectar(LaPlata,Tokyo,40);
         grafo2.conectar(Tokyo,Cordoba,30);
        grafo2.conectar(Berlin,LaPlata,20);
        grafo2.conectar(Berlin,Cordoba,60);
        
        Mapa m2 = new Mapa();
        m2.setMapaCiudades(grafo2);
        ListaGenerica<String> camino2 = m2.caminoCargandoCombustible("Buenos Aires", "Cordoba",50);
        System.out.println("Prueba: ");
        camino2.comenzar();
        while(!camino2.fin()){
            System.out.println(camino2.proximo());
        }
    }
}        

