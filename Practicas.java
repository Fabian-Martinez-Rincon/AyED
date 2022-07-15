public ListaGenerica<String> devolverCamino(Grafo<String>grafo, String origen, String destino){
    Boolean [] marcas = new Boolean [grafo.listaDeVertices()+1];
    Vertice<String> v;
    ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    Boolean encontro = false;
    while (!vertices.fin()) &&(!encontro){
        v = vertices.proximo();
        encontro = v.dato().equals(origen);
    }
    if (encontro){
        dfs(grafo,v,destino,marcas,resultado);
    }
    return resultado;
}

private Boolean(Grafo<String> grafo,Vertice<String> v,String destino,Boolean [] marcas,ListaGenerica<String> resultado){
    marcas[v.posicion()] = true;
    resultado.agregarAlFinal(v.dato());
    Boolean llega = false; 
    //Base
    if (v.dato().equals(destino)) {
        return true;
    }
    //Recursivo
    else {
        ListaGenerica<Arista> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while (!adyacentes.fin() && (!llega)){
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u = a.verticeDestino();
            if (!marcas[u.posicion()]) {
                llega = dfs(grafo,u,destino,marcas,resultado);
            }
        }
    }
    //Retorno
    if (!llega){
        resultado.eliminar(v.dato());
    }
    return llega;
}

//_____________________________________________________________________________
public ListaGenerica<String> devolverCaminoRestricciones(Grafo<String>grafo, String origen, String destino, ListaGenerica<String>Restricciones){
    ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
    if (!(Restricciones.incluye(origen) || Restricciones.incluye(destino))){
        Boolean [] marcas = new Boolean [grafo.listaDeVertices()+1];
        Vertice<String> v;
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        Boolean encontro = false;
        while (!vertices.fin()) &&(!encontro){
            v = vertices.proximo();
            encontro = v.dato().equals(origen);
        }
        if (encontro){
            dfs(grafo,v,destino,marcas,resultado,Restricciones);
        }
    }
    return resultado;
}

private Boolean(Grafo<String> grafo,Vertice<String> v,String destino,Boolean [] marcas,ListaGenerica<String> resultado, ListaGenerica<String>Restricciones){
    marcas[v.posicion()] = true;
    resultado.agregarAlFinal(v.dato());
    Boolean llega = false; 
    //Base
    if (v.dato().equals(destino)) {
        return true;
    }
    //Recursivo
    else {
        ListaGenerica<Arista> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while (!adyacentes.fin() && (!llega)){
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u = a.verticeDestino();
            if (!marcas[u.posicion()] && Restricciones.incluye(u.dato())) {
                llega = dfs(grafo,u,destino,marcas,resultado);
            }
        }
    }
    //Retorno
    if (!llega){
        resultado.eliminar(v.dato());
    }
    return llega;
}
//_____________________________________________________________________________
public caminoMasCorto(Grafo<String> grafo, String origen, String destino){
    ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
    ListaGenerica<Vertice<String>>  vertices = grafo.listaDeVertices();
    Vertice<String> v;
    boolean encontro = false;
    vertices.comenzar();
    while (!vertices.fin && !encontro) {
        v = vertices.proximo();
        encontro = v.dato().equals(origen);
    }
    if (!encontro) {
        dfs(grafo,v,destino,marcas,resultado,new ListaEnlazadaGenerica<String>,0,9999);
    }
    return resultado;
}
private void dfs(Grafo<String> grafo,Vertice<String> v,String destino,Boolean [] marcas,ListaGenerica<String>resultado,ListaGenerica<String> actual,pesoAcumulado,minimo){
    marcas[v.posicion()] = true;
    actual.agregarAlFinal(v.dato());
    //Base
    if (v.dato().equals(destino))&&(pesoAcumulado<minimo){
        resultado = actual.clonar();
        minimo = pesoAcumulado;
    }
    //Recursivo
    else {
        ListaGenerica<Arista> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> a = adyacentes().proximo();
            Vertice<String> u = a.verticeDestino();
            int pesoActual = pesoAcumulado + u.peso();
            if (!mascas[u.posicion()] && pesoActual<minimo){
                dfs(grafo,u,destino,marcas,resultado,actual,pesoActual,minimo);
            }
        }
    }
    //Retorno
    resultado.eliminar(v.dato())
    marcas[v.posicion()] = false;
}
//_____________________________________________________________________________
public ListaGenerica<String> NoSupere(Grafo<String> grafo, String origen, String destino, int maximo){
    ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
    Vertice <String> v;
    ListaGenerica<String> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    boolean encontro = false;
    while (!vertices() && !encontro){
        v = vertices.proximo();
        encontro = v.dato().equals(origen);
    }
    if (encontro){
        dfs(grafo,v,destino,marcas,resultado, new ListaEnlazadaGenerica(),0,maximo);
    }
    return resultado;
} 
private boolean dfs(Grafo<String>grafo,Vertice<String>v,String destino,boolean [] marcas,ListaGenerica<String> resultado, ListaGenerica<String> actual,int pesoAcumulado,int maximo){
    marca[v.posicion()] = true;
    actual.agregarAlFinal(v.dato());
    boolean llega = false;
    //Base
    if (v.dato().equals(destino) && pesoAcumulado<=maximo){
        resultado = actual.clonar();
        return true;
    }
    //Recursivo
    else {
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v.dato()); 
        while !adyacentes.fin() && !llaga{
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u = a.verticeDestino(); 
            int pesoActual = pesoAcumulado + u.peso();
            if (pesoActual<=maximo)&&(!marcas[u.posicion]){
                llega = dfs(grafo,u,destino,marcas,resultado,actual,pesoActual,minimo);
            }
        }
    }
    //Retorno
    if !llega {
        resultado.eliminar(v.dato());
        marca[v.posicion()] = false;
    }
    return llega;
}