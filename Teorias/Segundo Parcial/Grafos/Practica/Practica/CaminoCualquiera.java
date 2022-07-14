public CaminoCualquiera(Grafo<String> grafo, String origen, String destino){
    ListaGenerica<String>  camino= new ListaEnlazadaGenerica();
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeAdyacentes();
    boolean [] visitados = new boolean [grafo.listaDeAdyacentes().tamanio()+1];
    boolean fin = false;
    Vertice<String> v = null;
    vertices.comenzar();
    while (!vertices.fin()) && (!fin){
        v = vertices.proximo();
        if (v.dato().equals(origen)){
            fin = true;
        }
    }
    if (!fin()){
        this.dfs(visitados,v,camino,origen,destino);
    }
}
private dfs(Boolean [] visitados,Vertice<String> v,camino,origen,destino){

}