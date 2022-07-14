package Ejercicio4;
import PackDeCosas.*;
public class Recorridos<T> {
    
    //RECORRIDO DFS
    public void dfs(Grafo<T> grafo) {
        boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio()+1];
        for(int i=1;i<=grafo.listaDeVertices().tamanio();i++){
            if(!marcas[i]){
                this.dfs(i,grafo,marcas);
            }
        }
    }
    
    private void dfs (int i,Grafo<T> grafo, boolean[] marcas){
        marcas[i]=true;
        Vertice<T> v= grafo.listaDeVertices().elemento(i); //pido el vertice
        System.out.println(v.dato());
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);//pido sus adyacentes
        ady.comenzar();
        while(!ady.fin()){ //recorro la lista de adyacencias (lista de aristas) CASO BASE
            int j=ady.proximo().verticeDestino().getPosicion();
            if(!marcas[j]){
                this.dfs(j, grafo, marcas); //si no visite a ese adyacente
            }                               //llamo recursivamente
        }        
        
    }
    
    //RECORRIDO BFS
    public void bfs(Grafo<T> grafo) {
        boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio()+1];
        for(int i=1;i<=grafo.listaDeVertices().tamanio();i++){
            if(!marcas[i]){
                this.bfs(i,grafo,marcas);
            }
        }
    }
    
    private void bfs(int i,Grafo<T> grafo,boolean[] marcas){
        ListaGenerica<Arista<T>> ady;
        ColaGenerica<Vertice<T>> q= new ColaGenerica<>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marcas[i]=true;
        while(!q.esVacia()){
            Vertice<T> v=q.desencolar();
            System.out.println(v.dato());
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