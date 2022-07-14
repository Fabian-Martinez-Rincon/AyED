public dfs (Grafo<T> grafo){
    Boolean [] marcas = new Boolean [grafo.ListaDeVertices().tamanio()+1];
    for (int i = 1; i<=grafo.ListaDeVertices().tamanio(); i++ ){
        if (!marca[i]) {
            dfs(i,marcas,grafo)
        }
    }
}

private dfs(int i, boolean[] marcas, Grafo<T> grafo){
    Vertice<T> v = grafo.ListaDeVertices().Elemento(i);
    ListaGenerica<arista> ard = grafo.ListaDeAdyacentes(v);
    marcas[i] = true;
    ady.comenzar();
    while (!ady.fin()){
        int j = ady.proximo().VerticeDestino().getPosicion();
        if (!marcas[j]){
            dfs(j,marcas,grafo)
        }
    } 
}

