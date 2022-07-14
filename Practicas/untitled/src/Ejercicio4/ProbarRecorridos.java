package Ejercicio4;
import PackDeCosas.*;

public class ProbarRecorridos {
        public static void main(String[] args) {
            //Paso 1 - Creacion de los nodos (vertices)    
            VerticeImplListAdy<Integer> v1 = new VerticeImplListAdy<>(1);
            VerticeImplListAdy<Integer> v2 = new VerticeImplListAdy<>(2);
            VerticeImplListAdy<Integer> v3 = new VerticeImplListAdy<>(3);
            
            //Paso 2 - Creacion del Grafo
            Grafo<Integer> grafo = new GrafoImplListAdy<>();
            
            //Paso 3 - Agregar vertices a la lista de vertices del grafo
            grafo.agregarVertice(v1);
            grafo.agregarVertice(v2);
            grafo.agregarVertice(v3);
            
            //Paso 4 - conectar los vertices
            grafo.conectar(v1, v2);
            grafo.conectar(v1, v3);
            grafo.conectar(v2, v3);
            grafo.conectar(v3, v2);
            
            //Prueba con Recorridos con Lista
            RecorridosConLista<Integer> r = new RecorridosConLista<>();
            ListaGenerica<Integer> listaDFS=r.dfs(grafo);
            ListaGenerica<Integer> listaBFS=r.bfs(grafo);
            System.out.print("Lista DFS:");
            while(!listaDFS.fin()){
              System.out.print(listaDFS.proximo()+"-");
            }
            System.out.println();
            System.out.print("Lista BFS:");
            while(!listaBFS.fin()){
               System.out.print(listaBFS.proximo()+"-");
            }
            
            //Prueba de Recorridos sin Lista
            System.out.println("");
            Recorridos<Integer> reco = new Recorridos<>();
            reco.bfs(grafo);
            System.out.println("----");
            reco.dfs(grafo);
    }
}
