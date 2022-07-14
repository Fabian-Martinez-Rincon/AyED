package Ejercicio5;
import PackDeCosas.*;
public class ProbarCaminoMasCortoVertices {
    public static void main(String[] args){
        //PRUEBA1
        //Paso 1 - Creacion del Grafo
        Grafo<String> grafo = new GrafoImplListAdy<>();
        
        //Paso 2 - Creacion de los nodos (vertices)
        Vertice<String> vertice1 = new VerticeImplListAdy<>("1");
        Vertice<String> vertice2 = new VerticeImplListAdy<>("2");
        Vertice<String> vertice3 = new VerticeImplListAdy<>("3");       
        Vertice<String> vertice4 = new VerticeImplListAdy<>("4");       
        Vertice<String> vertice5 = new VerticeImplListAdy<>("5");
        
        //Paso 3 - Agregar vertices a la lista de vertices del grafo
        grafo.agregarVertice(vertice1);
        grafo.agregarVertice(vertice2);
        grafo.agregarVertice(vertice3);
        grafo.agregarVertice(vertice4);
        grafo.agregarVertice(vertice5);
        
        //Paso 4 - conectar los vertices
        grafo.conectar(vertice1, vertice2);
        grafo.conectar(vertice2, vertice3);
        grafo.conectar(vertice1, vertice3);
        grafo.conectar(vertice3, vertice4);
        grafo.conectar(vertice3, vertice5);

        Mapa m = new Mapa();
        m.setMapaCiudades(grafo);

        ListaGenerica<String> camino = m.caminoMasCortoVertices("1","5");
        System.out.println("Prueba nro1: ");
        camino.comenzar();
        while(!camino.fin()){
            System.out.println(camino.proximo());
        }
        
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
        grafo2.conectar(BuenosAires,LaPlata);
        grafo2.conectar(BuenosAires,Berlin);    
        grafo2.conectar(Berlin,LaPlata);
        grafo2.conectar(Berlin,Cordoba);
        grafo2.conectar(LaPlata,Tokyo);
        grafo2.conectar(Tokyo,Cordoba);
        
        Mapa m2 = new Mapa();
        m2.setMapaCiudades(grafo2);
        ListaGenerica<String> camino2 = m2.caminoMasCortoVertices("Buenos Aires", "Cordoba");
        System.out.println("Prueba nro2: ");
        camino2.comenzar();
        while(!camino2.fin()){
            System.out.println(camino2.proximo());
        }
    }
}    
