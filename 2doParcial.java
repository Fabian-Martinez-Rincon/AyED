package p6;

import estructuras.grafos.*;
import estructuras.listas.*;

public class Mapa {
  
  	/**
  	 * Busca el vertice con el valor recibido.
  	 */
  	private Vertice<String> buscarVertice(Grafo<String> g, String dato) {
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
        Vertice<String> v;   
        vertices.comenzar(); 
        while (!vertices.fin()) {
          v = vertices.proximo();
          if (v.dato().equals(dato)) {
            return v;
          }
        }
      	return null;
    }
  
     /*
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a
     * ciudad2 en caso que se pueda
     * llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
     *** 
     * PRIMER CAMINO
     */
    public ListaGenerica<String> primerCamino (Grafo<String> grafo,String origen, String destino) {
      
			ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
      boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio() + 1];
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
      
      Vertice<String> v;   
      boolean encontro = false;
      vertices.comenzar(); 
      while (!vertices.fin() && !encontro) {
      	v = vertices.proximo();
        encontro = v.dato().equals(origen);   
      }
      
      if (encontro)
        dfs(v,grafo, destino, marcas, resultado);
      return resultado;
    }
  	private boolean dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, ListaGenerica<String> resultado){
    	resultado.agregarAlFinal(v.dato());
      marcas[v.posicion()] = true;
      boolean llega = false;
      //PastaBase
      if(v.dato().equals(destino)){
        return true;
      }
      //Recursivo
      else {
        ListaGenerica<Arista<String>> adyacentes = grafo.ListaDeAdyacentes(v);
        adyacentes.comenzar();
        while(! adyacentes.fin() && !llega){
				    Vertice<String> u = adyacentes.proximo().verticeDestino(); 
        		// if(! marcas[v.getPosicion()]){ mal
        		if(! marcas[u.getPosicion()]){
            	llega = dfs(u,grafo, destino, marcas, resultadoo); 
            }
        }
      }
      //Retorno
      if(! llega) {
        resultado.eliminarEn(resultado.tamanio());
        // resultado.eliminar(v.dato());
        // marcas[v.posicion()] = true;
      }
      return llega;
    }

  	//_______________________________________________________________
		/*
     * Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2,
     * sin pasar por las ciudades
     * que están contenidas en la lista ciudades pasada por parámetro, si no existe
     * camino retorna la lista
     * vacía. (Sin tener en cuenta el combustible).
     *** 
     * PRIMER CAMINO CON EXCEPCIONES
     */
    public ListaGenerica<String> primerCaminoRestringidos(Grafo<String> grafo,String origen, String destino, ListaGenerica<String> restringidas) {
			ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
      
      if (! (restringidas.incluye(origen) || restringidas.incluye(destino))){
        boolean [] marcas = new boolean [grafo.listaDeVerices().tamanio() + 1];
    	  Vertice<String> v = this.buscar(grafo, origen);
        
        restrigidas.comenzar();
        while (!restrigidas.fin()) {
          Vertice v = buscar(grafo, restringidas.proximo());
          if (v!= null) {
            marcas[v.getPosicion()] = true;
          }
        }
        
/*        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
        Vertice<String> v;   
        boolean encontro = false;
        vertices.comenzar(); 
        while (!vertices.fin() && !encontro) {
          v = vertices.proximo();
          encontro = v.dato().equals(origen);   
        }
  */      
        if (v != null)
          dfs(v,grafo, destino, marcas, resultado /*, restringidas */);
      }
      
      return resultado;
    }
  
    private boolean dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, ListaGenerica<String> resultado, ListaGenerica<String> restringidas){
    	resultado.agregarAlFinal(v.dato());
      marcas[v.posicion()] = true;
      boolean llega = false;
      //PastaBase
      if(v.dato().equals(destino)){
        return true;
      }
      //Recursivo
      else(){
        ListaGenerica<Arista<String>> adyacentes = grafo.ListaDeAdyacentes(v);
        adyacentes.comenzar();
			  while(! adyacentes.fin() && !llega){
				    Vertice<String> u = adyacentes.proximo().verticeDestino(); 
        		// if(! restringidas.incluye(v.dato()) && ! marca[v.getPosicion()]){ mal
        		if(!restringidas.incluye(u.dato()) && !marca[u.getPosicion()]) {
            	llega = dfs(u,grafo, destino, marcas, resultado, restringidas); 
            }
        }
      }
      //Retorno
      if(! llega) {
        resultado.eliminarEn(resultado.tamanio());
        //resultado.eliminar(v.dato());
      }
      return llega;
    }
                                                           

		 /*
     * Retorna la lista de ciudades que forman el camino más corto para llegar de
     * ciudad1 a ciudad2, si no
     * existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin
     * tener en cuenta el
     * combustible).
     *** 
     * CAMINO MINIMO
     */
    public ListaGenerica<String> caminoMenorPeso(Grafo<String> grafo,String origen, String destino){
      ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
      // boolean [] marcas = new boolean [grafo.ListaDeAdyacentes().tamanio() + 1]; mal
      boolean [] marcas = new boolean [grafo.listaDeVerices().tamanio() + 1];
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
      
      Vertice<String> v;   
      boolean encontro = false;
      vertices.comenzar(); 
      while (!vertices.fin() && !encontro) {
          v = vertices.proximo();
          encontro = v.dato().equals(origen);   
      }
      
      if (encontro){
         Resultado res = new Resultado();
         dfs(v,grafo, destino, marcas, res, new ListaGenericaEnlazada<String>(),0);
        if (res.existeResultado()) {
          resultado = res.camino;
        }
      }
      
      return resultado;
    }
  	
    public class Resultado {
      public int costo = Integer.MAX_VALUE;
      public ListaGenerica<String> camino;
      
      boolean existeResultado() {
        return costo < Integer.MAX_VALUE;
      }
    }
    
  
  
  
  	private void dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, Resultado resultado, 
      ListaGenerica<String> actual, int pesoAcumulado) {
			// actual.agregarAlFinal(v); mal
			actual.agregarAlFinal(v.dato());
      marcas[v.posicion()] = true;
      // Caso encontrado
      if( v.dato().equals(destino) && pesoAcumulado < resultado.costo){
        resultado.camino = actual.clonar();
        resultado.costo = pesoAcumulado;
        // pesoMin = pesoActual;
//        pesoMin = pesoAcumulado;
      }
      // Caso recursivo
      else{
        	ListaGenerica<aristas<String>> adyacentes = grafo.listaDeAdyacentes(v);
        	adyacentes.comenzar();
        	while (!adyacentes.fin()) {
            Arista<String> a = ayacentes.proximo();
            Vertice<String> u = a.verticeDestino();
            int pesoActual = pesoAcumulado + a.peso(); 
          	if (!marcas[u.getPosicion()] && pesoActual < resultado.costo)){
            	dfs(u, grafo, destino, marcas, resultado, actual, pesoActual);
            }
          }
      }
      // Retorno
      actual.eliminarEn(actual.tamanio());
      marcas[v.posicion()] = false;
    }

		/*
     * Retorna la lista de ciudades que forman un camino para llegar de ciudad1
     * a ciudad2. El auto no debe quedarse sin combustible y no puede cargar. Si no
     * existe camino retorna la
     * lista vacía.
     *** 
     * CAMINO CON UN PESO MÁXIMO
     */
    public ListaGenerica<String> caminoConMaximo(Grafo<String> grafo,String origen, String destino, int maximo){
      ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
      boolean [] marcas = new boolean [grafo.ListaDeAdyacentes().tamanio() + 1];
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
      Vertice<String> v;   
      boolean encontro = false;
      vertices.comenzar(); 
      while (!vertices.fin() && !encontro) {
          v = vertices.proximo();
          encontro = v.dato().equals(origen);   
      }
      if (encontro){
          dfs(v, grafo, destino, marcas, resultado, 0 , maximo);
      }
      return resultado;
    }
  
  	private boolean dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean [] marcas, ListaGenerica<String> resultado, int pesoAcumulado, int maximo){
      marcas[v.getPosicion()] = true; 
    	resultado.agregarAlFinal(v.dato());
      boolean llega = false;
      // Caso Encontrado
      if (v.dato().equals(destino)) {
      	return true;
      }
      // Caso Recursivo
    	else{
      	listaGenerica<Arista<String>> adyacentes = grafo.ListaDeAdyacentes(v); 
      	adyacentes.comenzar();
        while(! adyacentes.fin() && !llega){
          Arista<String> a = adyacentes.proximo();
        	Vertice<String> u  = a.verticeDestino();
          int pesoActual = pesoAcumulado + a.peso();
        	if(! marcas[v.getPosicion()] && ! (pesoActual <= maximo)){ // Ver mucho el problema
            llega = dfs(u, grafo, destino, marcas, resultado, pesoActual , maximo);
          }
        }
      }
      // Retorno
      if(! llega){
        resultado.eliminarEn(resultado.tamanio());
        marcas[v.getPosicion()] = false; 
      }
      
      return llega;
    }
  	/*
     
     * CAMINO CON UN PESO MINMO
     */
    public ListaGenerica<String> caminoConMinimo(Grafo<String> grafo,String origen, String destino, int minimo){
      ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
      boolean [] marcas = new boolean [grafo.ListaDeAdyacentes().tamanio() + 1];
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
      Vertice<String> v;   
      boolean encontro = false;
      vertices.comenzar(); 
      while (!vertices.fin() && !encontro) {
          v = vertices.proximo();
          encontro = v.dato().equals(origen);   
      }
      if (encontro){
          dfs(v, grafo, destino, marcas, resultado, 0 , maximo);
      }
      return resultado;
    }
  
  	private boolean dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean [] marcas, ListaGenerica<String> resultado, int pesoAcumulado, int minimo){
      marcas[v.getPosicion()] = true; 
    	resultado.agregarAlFinal(v.dato());
      boolean llega = false;
      // Caso Encontrado
      if (v.dato().equals(destino)&&(peso >= minimo)) {
      	return true;
      }
      // Caso Recursivo
    	else if(! v.dato().equals(destino)){
      	listaGenerica<Arista<String>> adyacentes = grafo.ListaDeAdyacentes(v); 
      	adyacentes.comenzar();
        while(! adyacentes.fin() && !llega){
          Arista<String> a = adyacentes.proximo();
        	Vertice<String> u  = a.verticeDestino();
        	if(! marcas[v.getPosicion()]){ // Ver mucho el problema
            llega = dfs(u, grafo, destino, marcas, resultado, pesoAcumulado + a.peso() , minimo);
          }
        }
      }
      // Retorno
      if(! llega){
        resultado.eliminarEn(resultado.tamanio);
        marcas[v.getPosicion()] = false; 
      }
      
      return llega;
    }
		/*
     * Retorna la lista de ciudades que forman un camino para
     * llegar de ciudad1 a ciudad2 teniendo en cuenta que el auto debe cargar la
     * menor cantidad de veces. El
     * auto no se debe quedar sin combustible en medio de una ruta, además puede
     * completar su tanque al
     * llegar a cualquier ciudad. Si no existe camino retorna la lista vacía.
     * 
     * *** MÁXIMO PESO TEMPORAL Y MINIMA CANTIDAD DE CONSUMICIONES DEL MISMO
     */
    public ListaGenerica<String> caminoMenoresConsumicionesPesoTemporal(Grafo<String> g, String origen, String destino, int maxTanque){
    	ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
      boolean [] marcas = new boolean [grafo.ListaDeAdyacentes().tamanio() + 1];
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
      Vertice<String> v;   
      boolean encontro = false;
      vertices.comenzar(); 
      while (!vertices.fin() && !encontro) {
          v = vertices.proximo();
          encontro = v.dato().equals(origen);   
      }
      if (encontro){
        	Integer cargas = 99999999;
        	dfs(v,grafo,origen,destino,marcas,resultado,new ListaEnlazadaGenerica<String>(),maxTanque,maxTanque,0,cargas)
      }
      return resultado;
    }
    private void dfs(Vertice<String> v, Grafo<String> grafo, String origen, String destino, boolean[] marcas, ListaGenerica<String> resultado,
		ListaGenerica<String> actual, int tanqueAuto, int tanqueActual, int cargasActuales, Integer cargasMin) {
      // Preparación
      actual.agregarFinal();
      marcas[v.getPosicion] = true;
      // Caso base
      if(v.dato().equals(destino) && (cargasActuales < cargasMin)){
          cargasMin = cargasActuales;
          resultado = actual.clone();
      }
      // Caso recursivo
      else{
        ListaGenerica<Arista<String>> adyacentes
        Arista<String> a;
        Vertice<String> u;
        adyacentes.comenzar();
        while(! adyacentes.fin()){
            a = adyacentes.proximo();
            u = a.verticeDestino();
            int pesoActual = tanqueActual - a.peso();
            if(! marcas[v.getPosicion()]){
                if(tanque actual >= 0)&&(cargasActuales+1 < cargasMin)
                  	dfs(u,grafo,origen,destino,marcas,resultado,actual,tanqueAuto,tanqueAuto,cargasActuales +1,cargasMin)
                else
                  	dfs(u,grafo,origen,destino,marcas,resultado,actual,tanqueAuto,pesoActual,cargasActuales,cargasMin)
            }
        }
      }
      // Retorno
      actual.eliminar(v.dato());
      marcas[v.getPosicion] = false;
    }
  
  
  
  
  