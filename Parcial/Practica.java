public ListaGenerica<String> Recorrer(Grafo<String> grafo, String origen, String destino){
    Boolean [] marcas = new Boolean [grafo.listaDeVertices().tamanio()+1];
    ListaGenerica<Vertices<String>> vertices = grafo.listaDeVertices();
    Boolean encontro = false;
    Vertice<String> v; 
    ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
    
    vertices.comenzar();
    while (!vertices.fin()) &&(!encontro) {
        v = vertices.proximo();
        encontro = v.dato().equals(origen);
    }

    if (encontro){
        dfs(grafo,v,destino,marcas,resultado);
    }

    return resultado; 
}

private Boolean dfs(Grafo<String> grafo, Vertice<String> v, String destino, Boolean [] marcas, ListaGenerica<String> resultado){
    resultado.agregarAlFinal(v.dato());
    marcas[v.posicion()] = true;
    boolean llego = false;
    //Base
    if (v.dato().equals(destino)) {
        return true;
    }
    //Recursivo
    else {
        ListaGenerica<Arista> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while (adyacentes.fin()) {
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u = a.verticeDestino();
            if (!marcas[u.posicion]) {
                llego = dfs(grafo,u,destino,marcas,resultado);
            }
        }
    }
    //Retorno
    if (!llego){
        resultado.eliminar(v.tamanio());
    }
    return llego;
}
//_______________________________________________________________
private Boolean dfsRestricciones(Grafo<String> grafo, Vertice<String> v, String destino, Boolean [] marcas, ListaGenerica<String> resultado,ListaGenerica<String> Restringidas){
    resultado.agregarAlFinal(v.dato());
    marcas[v.posicion()] = true;
    boolean llego = false;
    //Base
    if (v.dato().equals(destino)) {
        return true;
    }
    //Recursivo
    else {
        ListaGenerica<Arista> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while (adyacentes.fin()) {
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u = a.verticeDestino();
            if !Restringidas.incluye(u) && (!marcas[u.posicion]){
                llego = dfsRestricciones(grafo,u,destino,marcas,resultado);
            }
        }
    }
    //Retorno
    if (!llego){
        resultado.eliminar(v.tamanio());
    }
    return llego;
}
//_______________________________________________________________
public class Minimo(){
    public int peso = MAX_VALUE;
    public ListaGenerica<String> recorrido= new ListaEnlazadaGenerica();
}
private void dfsMenorPeso(Grafo<String> grafo, Vertice<String> v, String destino, Boolean [] marcas,ListaGenerica<String> actual, Minimo min, int pesoAcumulado){
    actual.agregarAlFinal(v.dato());
    marcas[v.posicion()] = true;
    //Base
    if (v.dato().equals(destino)){
        min.peso = pesoAcumulado;
        min.recorrido = actual.clonar();
    }
    //Recursivo
    else{
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while !adyacentes.fin() {
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u = a.verticeDestino();
            int pesoActual = pesoAcumulado + a.peso();
            if (!marcas[u.posicion()] && pesoActual<min.peso){
                dfs(grafo,u,destino,marcas,actual,min,pesoActual);
            } 
        }
    }
    //Retorno
    actual.eliminar(v.tamanio());
    marcas[v.posicion()] = false;
}
//_______________________________________________________________
private Boolean dfsPesoLimite(Grafo<String>grafo, Vertice<String> v, String destino, Boolean [] marcas, int maximo, int pesoAcumulado, ListaGenerica<String> resultado){
    resultado.agregarAlFinal(v.dato());
    marcas[v.posicion()] = true;
    if v.dato().equals(destino) {
        return true;
    }
    else {
        boolean llega = false;
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v.dato());
        adyacentes.comenzar();
        while (!adyacentes.fin()){
            Arista<String> a = adyacentes.proximo();
            Vertice<String> u =a.verticeDestino();
            pesoActual = u.peso() + pesoAcumulado;
            if (!marcas[u.posicion()])&& (pesoActual<maximo) {
                llega = dfsPesoLimite(grafo,u,destino,marcas,maximo,pesoAcumulado,resultado);
            }
        }
    }   
    if (!llega){
        resultado.eliminarEn(v.tamanio());
    }
    return llega;
}

private void bfs(Grafo<String>grafo){

}