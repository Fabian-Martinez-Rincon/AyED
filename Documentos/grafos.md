# Grafos

- [Crear Camino](#crear-camino)


## Crear Camino

```Java
public crearCamino(Grafo<String> grafo, String origen, String destino){
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
    ListaGenerica<Vertice<String>> resultado = listaEnlazadaGenerica<String>();
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    Vertice<String> vertice = vertices.proximo();
    vertices.comenzar()
    while (!vertices.fin() && vertice.dato().equals(origen)){
        vertices.proximo();
    }
    if (vertice != null){
        dfs(grafo,vertice,destino,marcas,resultado,listaEnlazadaGenerica<String>());
    }
    return resultado;
}
 private void dfs(Grafo<String> grafo, Vertice<String> vertice, String destino, boolean[] marcas, ListaGenerica<String> resultado,ListaGenerica<String> recorrido) {
    recorrido.agregarAlFinal(vertice.dato());
    if (vertice.dato().equals(destino)) {
        resultado = recorrido.clonar();
    }
    else {
        marcas[vertice.posicion()] = true;
        ListaGenerica<Arista<String>> adyacentes = grafo.listaAdyacentes(vertice);
        adyacentes.comenzar()
        while (!adyacentes.fin() && resultado.esVacia()) {
            Vertice<String> vDestino = adyacentes.proximo().verticeDestino();
            if (!marcas[vDestino.posicion()]) {
                dfs(grafo, vDestino, destino, marcas, resultado,recorrido);
            }
        }
        marcas[vertice.posicion()] = false;
    }
    recorrido.eliminar(vertice.dato());
} 
```

## Crear Camino Con Restricciones

```Java
public crearCamino(Grafo<String> grafo, String origen, String destino, ListaGenerica<String> Restricciones){
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
    ListaGenerica<Vertice<String>> resultado = listaEnlazadaGenerica<String>();
    if (!Restricciones.incluye(origen) && !Restricciones.incluye(destino)){
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        Vertice<String> vertice = vertices.proximo();
        vertices.comenzar()
        while (!vertices.fin() && vertice.dato().equals(origen)){
            vertices.proximo();
        }
        if (vertice != null){
            dfs(grafo,vertice,destino,marcas,resultado,listaEnlazadaGenerica<String>());
        }
    }
    return resultado;
}
 private void dfs(Grafo<String> grafo, Vertice<String> vertice, String destino, boolean[] marcas, ListaGenerica<String> resultado,ListaGenerica<String> recorrido,ListaGenerica<String> Restricciones) {
    recorrido.agregarAlFinal(vertice.dato());
    if (vertice.dato().equals(destino)) {
        resultado = recorrido.clonar();
    }
    else {
        marcas[vertice.posicion()] = true;
        ListaGenerica<Arista<String>> adyacentes = grafo.listaAdyacentes(vertice);
        adyacentes.comenzar()
        while (!adyacentes.fin() && resultado.esVacia()) {
            Vertice<String> vDestino = adyacentes.proximo().verticeDestino();
            if (!marcas[vDestino.posicion()] && !Restricciones.incluye(vDestino.dato())) {
                dfs(grafo, vDestino, destino, marcas, resultado,recorrido,Restricciones);
            }
        }
        marcas[vertice.posicion()] = false;
    }
    recorrido.eliminar(vertice.dato());
} 
```

## Crear Camino Minimo

```Java
public crearCamino(Grafo<String> grafo, String origen, String destino){
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
    ListaGenerica<Vertice<String>> resultado = listaEnlazadaGenerica<String>();
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    Vertice<String> vertice = vertices.proximo();
    vertices.comenzar()
    while (!vertices.fin() && vertice.dato().equals(origen)){
        vertices.proximo();
    }
    if (vertice != null){
        int distancia = 0;
        Min minimo = new Min(9999);
        dfs(grafo,vertice,destino,marcas,resultado,minimo,listaEnlazadaGenerica<String>(),distancia);
    }
    return resultado;
}
 private void dfs(Grafo<String> grafo, Vertice<String> vertice, String destino, boolean[] marcas, ListaGenerica<String> resultado,int minimo,ListaGenerica<String> recorrido,distancia) {
    recorrido.agregarAlFinal(vertice.dato());
    if (vertice.dato().equals(destino)) {
        if(distancia<minimo){
            minimo.setMinimo(distancia);
            resultado = recorrido.clonar();
        }
    }
    else {
        marcas[vertice.posicion()] = true;
        ListaGenerica<Arista<String>> adyacentes = grafo.listaAdyacentes(vertice);
        adyacentes.comenzar()
        while (!adyacentes.fin() && resultado.esVacia()) {
            Vertice<String> vDestino = adyacentes.proximo().verticeDestino();
            if (!marcas[vDestino.posicion()]) {
                dfs(grafo, vDestino, destino, marcas, resultado,minimo,recorrido,distancia+vDestino.peso());
            }
        }
        marcas[vertice.posicion()] = false;
    }
    recorrido.eliminar(vertice.dato());
} 
```