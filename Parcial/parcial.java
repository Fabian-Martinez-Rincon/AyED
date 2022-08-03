public ListaGenerica<String> Recorrido (Grafo<String> grafo, int cantLocalidades, int CantNafta, ListaGenericaEnlazada<String> localidadesExceptuadas){
    Boolean [] marcas = new Boolean [grafo.listadeVertices().tamanio() + 1 ];
    Boolean Encontro = false;
    ListaGenerica<String> Resultado = new ListaEnlazadaGenerica<String>();
    if (!Exceptuadas.incluye('Mendoza')) {
        Vertice<String> v;
        ListaGenerica<Vertice<String>> Vertices = grafo.listaDeVertices();
        Vertices.comenzar();
        while(!Vertices.fin() && !encontro) {
            v = vertices.proximo();
            Encontro = v.dato().equals('Mendoza');
        }
    }
    if (!encontro) {
        DFS(grafo, v, Resultado, CantLocalidades, CantNafta, LocalidadesExceptuadas, 0, 0);
    }
}

private Boolean DFS(Grafo<String> grafo, Vertice<String> v, ListaGenerica<String> Resultado, int cantLocalidades, int cantNafta, ListaGenerica<String> Exceptuadas, int LocAcumuladas, int naftaAcumulada){
    marcas[v.posicion()] = True;
    Resultado.AgregarAlFinal(v.dato());
    ListaGenerica<Arista<String>> adyacentes = grafo.ListaDeAdyacentes();
    Boolean Termino = false;
    adyacentes.comenzar();
    if (adyacentes.fin()){
        return true;
    }
    else
        while (!adyacentes.fin() && !Termino){
            Arista<String> a = adyacentes.Proximo();
            Vertice<String> u = a.verticeDestino();
            int LocActuales = LocAcumuladas + 1;
            int naftaActual = a.peso() + naftaAcumulada;
            if (!marcas[u.posicion]) && (naftaActual <= cantNafta) && cantLocalidades < LocActuales && !Exceptuadas.incluye(u){
                Termino = DFS(grafo, u, Resultado, cantLocalidades, cantNafta, Exceptuadas, LocActuales, naftaActual);
            }
        }
    if (!Termino){
        Resultado.Eliminar(v.dato());
    }
    return Termino;
}