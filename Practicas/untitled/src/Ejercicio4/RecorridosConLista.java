package Ejercicio4;
import PackDeCosas.*;
public class RecorridosConLista<T> {
    
    //RECORRIDO DFS
    public ListaGenerica<T> dfs(Grafo<T> grafo) {
        ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
        boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio()+1];
        for(int i=1;i<=grafo.listaDeVertices().tamanio();i++){
            if(!marcas[i]){
                this.dfs(i,grafo,marcas,lista);
            }
        }
        return lista;
    }
    
    private void dfs (int i,Grafo<T> grafo, boolean[] marcas,ListaGenerica<T> lista){
        marcas[i]=true;
        Vertice<T> v= grafo.listaDeVertices().elemento(i); //pido el vertice
        lista.agregarFinal(v.dato()); //lo puedo Imprimir
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);//pido sus adyacentes
        ady.comenzar();
        while(!ady.fin()){ //recorro la lista de adyacencias (lista de aristas) CASO BASE
            int j=ady.proximo().verticeDestino().getPosicion();
            if(!marcas[j]){
                this.dfs(j, grafo, marcas, lista); //si no visite a ese adyacente
            }                                      //llamo recursivamente
        }        
        
    }
    
    //RECORRIDO BFS
    public ListaEnlazadaGenerica<T> bfs(Grafo<T> grafo) {
        ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
        boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio()+1];
        for(int i=1;i<=grafo.listaDeVertices().tamanio();i++){
            if(!marcas[i]){
                this.bfs(i,grafo,marcas,lista);
            }
        }
        return lista;
    }
    
    private void bfs(int i,Grafo<T> grafo,boolean[] marcas, ListaEnlazadaGenerica<T> lista){
        ListaGenerica<Arista<T>> ady;
        ColaGenerica<Vertice<T>> q= new ColaGenerica<>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marcas[i]=true;
        while(!q.esVacia()){
            Vertice<T> v=q.desencolar();
            lista.agregarFinal(v.dato());
            ady=grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while(!ady.fin()){
                Arista<T> arista= ady.proximo();
                int j= arista.verticeDestino().getPosicion();
                if(!marcas[j]){
                    Vertice<T> w = arista.verticeDestino();
                    marcas[j]=true;
                    q.encolar(w);
                }
            }
        }
    }   
}
