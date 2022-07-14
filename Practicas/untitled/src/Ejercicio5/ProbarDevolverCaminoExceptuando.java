package Ejercicio5;

import PackDeCosas.*;

public class ProbarDevolverCaminoExceptuando {
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
        grafo.conectar(vertice2, vertice1);

        grafo.conectar(vertice2, vertice3);
        grafo.conectar(vertice3, vertice2);

        grafo.conectar(vertice1, vertice3);
        grafo.conectar(vertice3, vertice1);

        grafo.conectar(vertice3, vertice4);
        grafo.conectar(vertice4, vertice3);

        grafo.conectar(vertice3, vertice5);
        grafo.conectar(vertice5, vertice3);

        Mapa m = new Mapa();
        m.setMapaCiudades(grafo);

        ListaGenerica<String> exceptuar = new ListaEnlazadaGenerica<>();
        exceptuar.agregarFinal("2");
        exceptuar.agregarFinal("4");
        ListaGenerica<String> camino = m.devolverCaminoExceptuando("1", "5",exceptuar);
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
        Vertice<String> Paris = new VerticeImplListAdy<>("Paris");
        Vertice<String> Berlin = new VerticeImplListAdy<>("Berlin");
        Vertice<String> Cordoba = new VerticeImplListAdy<>("Cordoba");

        //Paso 3 - Agregar vertices a la lista de vertices del grafo
        grafo2.agregarVertice(BuenosAires);
        grafo2.agregarVertice(LaPlata);
        grafo2.agregarVertice(Paris);
        grafo2.agregarVertice(Berlin);
        grafo2.agregarVertice(Cordoba);

        //Paso 4 - conectar los vertices
        grafo2.conectar(BuenosAires,LaPlata);
        grafo2.conectar(LaPlata,BuenosAires);
        
        grafo2.conectar(BuenosAires,Paris);
        grafo2.conectar(Paris,BuenosAires);
        
        grafo2.conectar(Paris,Berlin);
        grafo2.conectar(Berlin,Paris);
        
        grafo2.conectar(Berlin,LaPlata);
        grafo2.conectar(LaPlata,Berlin);
        
        grafo2.conectar(LaPlata,Cordoba);
        grafo2.conectar(Cordoba,LaPlata);
        
        Mapa m2 = new Mapa();
        m2.setMapaCiudades(grafo2);
        ListaGenerica<String> exceptuar2 = new ListaEnlazadaGenerica<>();
        exceptuar2.agregarFinal("La Plata");
        ListaGenerica<String> camino2 = m2.devolverCaminoExceptuando("Buenos Aires","Berlin",exceptuar2);
        System.out.println("Prueba nro2: ");
        camino2.comenzar();
        while(!camino2.fin()){
            System.out.println(camino2.proximo());
        }
    }    
}
