package Ejercicio5;
import PackDeCosas.*;
public class Mapa {
    private Grafo<String> mapaCiudades = new GrafoImplListAdy<>();

    public void setMapaCiudades(Grafo<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }
    
//------------------------------------------------------------------------------------------------------    
    //el primer camino que encuentre
    public ListaEnlazadaGenerica<String> devolverCamino(String c1,String c2){
        ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
        boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio()+1];
        Vertice<String> origen=null,destino=null;
        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<String> actual= vertices.proximo();
            if(actual.dato().equals(c1)){  //busco el vertice del origen
                origen=actual;
            }
            if(actual.dato().equals(c2)){ //busco el vertice destino
                destino=actual;
            }
        }
        if((origen != null) && (destino != null)){
            devolverCamino(origen,destino,marcas,camino);
        }
        return camino;        
    }

    private boolean devolverCamino (Vertice<String> origen,Vertice<String> destino,boolean[] marcas, ListaGenerica<String> camino){
        marcas[origen.getPosicion()]=true;
        camino.agregarFinal(origen.dato());
        if (origen == destino){
            return true;
        }else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if(!marcas[sig.getPosicion()]){
                    boolean resultado = devolverCamino(sig,destino,marcas,camino);
                    if (resultado){
                        return true;
                    } 
                }    
            }
        }
    //marca[origen.getPosicion()] = false <-- cuando busco todos los caminos o un mejor camino
    camino.eliminarEn(camino.tamanio());
    return false;    
    }
    
 //------------------------------------------------------------------------------------------------------   
    //devolverCamino exceptuando los datos que estan en la lista
    public ListaEnlazadaGenerica<String> devolverCaminoExceptuando(String c1,String c2, ListaGenerica<String> exceptuar){
        ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
        boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio()+1];
        Vertice<String> origen=null,destino=null;
        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<String> actual= vertices.proximo();
            if(actual.dato().equals(c1)){  //busco el vertice del origen
                origen=actual;
            }
            if(actual.dato().equals(c2)){ //busco el vertice destino
                destino=actual;
            }
        }
        if((origen != null) && (destino != null)){
            devolverCaminoExceptuando(origen,destino,marcas,camino,exceptuar);
        }
        return camino;
    }
    private boolean devolverCaminoExceptuando (Vertice<String> origen,Vertice<String> destino,boolean[] marcas, 
                                                ListaGenerica<String> camino, ListaGenerica<String> exceptuar){
        marcas[origen.getPosicion()]=true;
        camino.agregarFinal(origen.dato());
        if (origen == destino){
            return true;
        }else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                    if(exceptuar.incluye(sig.dato())){
                        marcas[sig.getPosicion()]=true;
                    }
                if(!marcas[sig.getPosicion()]){
                    boolean resultado = devolverCaminoExceptuando(sig,destino,marcas,camino,exceptuar);
                    if (resultado){
                        return true;
                    } 
                }    
            }
        }
        camino.eliminarEn(camino.tamanio());
        return false;    
    }
//------------------------------------------------------------------------------------------------------ 
//el camino mas corto (pasa por menos vertices)
    public ListaGenerica<String> caminoMasCortoVertices(String c1,String c2){
        //declaracion de variables
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices(); //lista de vertices
        ResultadoVertices<String> res = new ResultadoVertices<>();
        boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio()+1]; //array de marcas
        ListaEnlazadaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>(); 
        int cantVerticesAux=0; //caminoAux, pesoAux variables para jugar con la recursion
        //fin de declaracion de variables
        res.setCantVertices(9999);
        Vertice<String> origen=null,destino=null;
        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<String> actual= vertices.proximo();
            if(actual.dato().equals(c1)){  //busco el vertice del origen
                origen=actual;
            }
            if(actual.dato().equals(c2)){ //busco el vertice destino
                destino=actual;
            }
        }
        if((origen != null) && (destino != null)){
            caminoMasCortoVertices(origen,destino,marcas,caminoAux,res,cantVerticesAux);
        }
        return res.getLista();
    }
    
    //en caminoAux,pesoAux voy almacenando el camino que recorro en el momento
    //en res guardo el camino con menor peso que vaya encontrando
    private void caminoMasCortoVertices(Vertice<String> origen,Vertice<String> destino, boolean[] marcas, 
                                    ListaEnlazadaGenerica<String> caminoAux, ResultadoVertices<String> res, int cantVerticesAux){
        marcas[origen.getPosicion()]=true; //marco el origen
        caminoAux.agregarFinal(origen.dato()); //lo agrego al camino
        if(origen.dato().equals(destino.dato())){ //si llegue al destino (puedo entrar varias veceS)
            if(cantVerticesAux < res.getCantVertices()){ //comparo si el peso actual es mejor que el que tenia guardado
                res.setCantVertices(cantVerticesAux);      
                res.setLista(caminoAux.clonar()); //uso copia para no desarmar caminoAux
            }
        }else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if(!marcas[sig.getPosicion()]){
                    cantVerticesAux++; //sumo un vertice
                    caminoMasCortoVertices(sig,destino,marcas,caminoAux,res,cantVerticesAux);
                    caminoAux.eliminar(sig.dato()); //elimino, resto los datos de caminoAux,pesoAux, ya se que 
                    cantVerticesAux--; //si es un camino minimo, ya lo guarde en res.peso y res.lista
                }                            //dejo caminoAux,pesoAux vacios para poder contabilizar otro camino
            }
        }
        //desmarco/borro despues de llamada recursiva
        caminoAux.eliminarEn(caminoAux.tamanio()); //elimino el que agrege al principio de la recursion
        marcas[origen.getPosicion()]=false; //desmarco para poder volver a pasar, ya que quizas hay un un camino minimo
    }
 
//------------------------------------------------------------------------------------------------------
    //el camino mas corto (midiendo los pesos) y pasando Strings (no vertices)
    public ListaGenerica<String> caminoMasCortoPeso(String c1,String c2){
        //declaracion de variables
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices(); //lista de vertices
        ResultadoPeso<String> res = new ResultadoPeso<>();
        boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio()+1]; //array de marcas
        ListaEnlazadaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>(); 
        int pesoAux=0; //caminoAux, pesoAux variables para jugar con la recursion
        //fin de declaracion de variables
        res.setPeso(9999);
        Vertice<String> origen=null,destino=null;
        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<String> actual= vertices.proximo();
            if(actual.dato().equals(c1)){  //busco el vertice del origen
                origen=actual;
            }
            if(actual.dato().equals(c2)){ //busco el vertice destino
                destino=actual;
            }
        }
        if((origen != null) && (destino != null)){
            caminoMasCortoPeso(origen,destino,marcas,caminoAux,res,pesoAux);
        }
        return res.getLista();
    }
    
    //en caminoAux,pesoAux voy almacenando el camino que recorro en el momento
    //en res guardo el camino con menor peso que vaya encontrando
    private void caminoMasCortoPeso(Vertice<String> origen,Vertice<String> destino, boolean[] marcas, 
                                    ListaEnlazadaGenerica<String> caminoAux, ResultadoPeso<String> res, int pesoAux){
        marcas[origen.getPosicion()]=true; //marco el origen
        caminoAux.agregarFinal(origen.dato()); //lo agrego al camino
        if(origen.dato().equals(destino.dato())){ //si llegue al destino (puedo entrar varias veceS)
            if(pesoAux < res.getPeso()){ //comparo si el peso actual es mejor que el que tenia guardado
                res.setPeso(pesoAux);      
                res.setLista(caminoAux.clonar()); //uso copia para no desarmar caminoAux
            }
        }else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if(!marcas[sig.getPosicion()]){
                    pesoAux+= arista.peso(); //sumo el peso de esa arista
                    caminoMasCortoPeso(sig,destino,marcas,caminoAux,res,pesoAux);
                    caminoAux.eliminar(sig.dato()); //elimino, resto los datos de caminoAux,pesoAux, ya se que si
                    pesoAux -= arista.peso(); //sies un camino minimo, ya lo guarde en res.peso y res.lista
                }                            //dejo caminoAux,pesoAux vacios para poder contabilizar otro camino
            }
        }
        //desmarco/borro despues de llamada recursiva
        caminoAux.eliminarEn(caminoAux.tamanio()); //elimino el que agrege al principio de la recursion
        marcas[origen.getPosicion()]=false; //desmarco para poder volver a pasar, ya que quizas hay un un camino minimo
    }
//------------------------------------------------------------------------------------------------------
//Un camino donde el auto no se quede sin combustible (no puede cargar)
    public ListaGenerica<String> caminoSinCargarCombustible(String c1, String c2,int tanqueAuto){
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
        ResultadoSinCargarTanque<String> res = new ResultadoSinCargarTanque<>();
        boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio()+1];
        ListaEnlazadaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>();
        int cantNafta=0;
        res.setCantNafta(tanqueAuto);
        Vertice<String> origen=null,destino=null;
        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<String> actual= vertices.proximo();
            if(actual.dato().equals(c1)){  //busco el vertice del origen
                origen=actual;
            }
            if(actual.dato().equals(c2)){ //busco el vertice destino
                destino=actual;
            }
        }
        if((origen != null) && (destino != null)){
            caminoSinCargarCombustible(origen,destino,marcas,cantNafta,caminoAux,res);
        }
        return res.getLista();
    }
    
    private boolean caminoSinCargarCombustible(Vertice<String> origen,Vertice<String> destino, boolean[] marcas,int cantNafta,
                                            ListaEnlazadaGenerica<String> caminoAux, ResultadoSinCargarTanque<String> res){
        marcas[origen.getPosicion()]=true;
        caminoAux.agregarFinal(origen.dato());
        if(origen.dato().equals(destino.dato())){
            if(cantNafta <= res.getCantNafta()){
                res.setLista(caminoAux.clonar());
            }
        }else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if(!marcas[sig.getPosicion()]){
                    cantNafta+=arista.peso();
                    boolean resultado = caminoSinCargarCombustible(sig,destino,marcas,cantNafta,caminoAux,res);
                    caminoAux.eliminar(sig.dato());
                    cantNafta-=arista.peso();
                    if(resultado){
                        return true;
                    }
                }
            }
        }
        marcas[origen.getPosicion()]=false;
        caminoAux.eliminarEn(caminoAux.tamanio());
        return false;
    }
    
//------------------------------------------------------------------------------------------------------
//Un camino cargando la menor cantidad de nafta posible
    public ListaGenerica<String> caminoCargandoCombustible(String c1, String c2,int tanqueAuto){
        ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
        ResultadoCargandoTanque<String> res = new ResultadoCargandoTanque<>();
        boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio()+1];
        ListaEnlazadaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>();
        int cantNafta=0;
        int cantVecesCargadas=0;
        res.setCantNafta(tanqueAuto);
        res.setCantCargada(99999);
        boolean alcanzaNafta=true;
        Vertice<String> origen=null,destino=null;
        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<String> actual= vertices.proximo();
            if(actual.dato().equals(c1)){  //busco el vertice del origen
                origen=actual;
            }
            if(actual.dato().equals(c2)){ //busco el vertice destino
                destino=actual;
            }
        }
        if((origen != null) && (destino != null)){
            caminoCargandoCombustible(origen,destino,marcas,cantNafta,cantVecesCargadas,caminoAux,res,alcanzaNafta);
        }
        return res.getLista();        
    }
    
    private void caminoCargandoCombustible(Vertice<String> origen,Vertice<String> destino, boolean[] marcas,int cantNafta,int cantVecesCargadas,
                                            ListaEnlazadaGenerica<String> caminoAux, ResultadoCargandoTanque<String> res,boolean alcanzaNafta){
        marcas[origen.getPosicion()]=true;
        caminoAux.agregarFinal(origen.dato());
        if(origen.dato().equals(destino.dato())&&(alcanzaNafta)){
            if(cantVecesCargadas <= res.getCantCargada()){
                res.setCantCargada(cantVecesCargadas);
                res.setLista(caminoAux.clonar());
            }
        }else{
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if(!marcas[sig.getPosicion()]){
                    cantNafta+=arista.peso();
                    if(arista.peso() > res.getCantNafta()){
                        alcanzaNafta=false;
                    }
                    if(cantNafta > res.getCantNafta()){
                        cantVecesCargadas++;
                    }
                    caminoCargandoCombustible(sig,destino,marcas,cantNafta,cantVecesCargadas,caminoAux,res,alcanzaNafta);
                    caminoAux.eliminar(sig.dato());
                    cantVecesCargadas=0;
                    cantNafta-=arista.peso();
                }
            }
        }
        caminoAux.eliminarEn(caminoAux.tamanio()); //elimino el que agrege al principio de la recursion
        marcas[origen.getPosicion()]=false; 
    }
//------------------------------------------------------------------------------------------------------
}
