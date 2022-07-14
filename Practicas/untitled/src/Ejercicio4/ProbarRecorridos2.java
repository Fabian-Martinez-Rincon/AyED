package Ejercicio4;
import PackDeCosas.*;
public class ProbarRecorridos2 {
	public static void main(String[] args) {
		/*
		 * Ejemplo de un grafo dirigido no ponderado.
		 */

		// Paso 1 - Creacion de los nodos (vértices)
		Vertice<String> v1 = new VerticeImplListAdy<>("Buenos Aires"); 
		Vertice<String> v2 = new VerticeImplListAdy<>("Santiago"); 
		Vertice<String> v3 = new VerticeImplListAdy<>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<>("Asunción");
		Vertice<String> v6 = new VerticeImplListAdy<>("La Habana");
		Vertice<String> v7 = new VerticeImplListAdy<>("Caracas");
		
		// Paso 2 - Creacion del Grafo (implementado con lista ady) con su lista de vertices vacia. 
		Grafo<String> grafo = new GrafoImplListAdy<>();
		
		// Paso 3 - Agregar vertices, a la lista de vertices del grafo .
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		
		// Paso 4 - conectar los vertices
		grafo.conectar(v1, v2);
		grafo.conectar(v1, v3);
		grafo.conectar(v1, v4);
		grafo.conectar(v1, v5);
		grafo.conectar(v2, v5);
		grafo.conectar(v2, v6);
		grafo.conectar(v3, v5);
		grafo.conectar(v4, v5);
		grafo.conectar(v7, v6);
		grafo.conectar(v7, v5);
		
		RecorridosConLista<String> r = new RecorridosConLista<>();
		ListaGenerica<String> listaDFS=r.dfs(grafo);
                ListaGenerica<String> listaBFS=r.bfs(grafo);
                System.out.print("Lista DFS:");
                while(!listaDFS.fin()){
                  System.out.print(listaDFS.proximo()+"-");
                }
                System.out.println();
                System.out.print("Lista BFS:");
                while(!listaBFS.fin()){
                   System.out.print(listaBFS.proximo()+"-");
                }
	}
	
}