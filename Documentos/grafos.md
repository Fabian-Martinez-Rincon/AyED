# Grafos

- [Crear Camino](#crear-camino)

## Crear Camino

```Java
public crearCamino(Grafo<String> grafo, String origen, String, destino){
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
    ListaGenerica<Vertice<String>> camino = listaEnlazadaGenerica<String>();
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    Vertice<String> vertice = vertices.proximo();
    vertices.comenzar()
    while (!vertices.fin() && vertice.dato().equals(origen)){
        vertices.proximo();
    }
    if (vertice != null){
        dfs(grafo,vertice.getPosicion(),camino);
    }
    
}
 private void dfs(Grafo<String> grafo, Vertice<String> vertice, String destino, int montoMaximo, boolean[] marca, ListaGenerica<String> recorrido, ListaGenerica<String> resultado
    ) {
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
                dfs(grafo, vDestino, destino, marcas, recorrido, resultado);
            }
        }
        marcas[vertice.posicion()] = false;
    }
    recorrido.eliminar(vertice.dato());
    } 
```