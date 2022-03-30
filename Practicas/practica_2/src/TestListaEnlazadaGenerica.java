import tp02.ejercicio2.*;

public class TestListaEnlazadaGenerica {
    public static void main(String[] args) {
        System.out.println("Hola");
        Estudiante est1 = new Estudiante("Fabian", "Martinez", "1b","gmail.com","74/23");
        Estudiante est2 = new Estudiante("Fabo", "Martin Garrix", "1a","hotmail.com","123");
        Estudiante est3 = new Estudiante("Fabian2", "Martinez2", "1b2","gmail.com2","74/232");
        Estudiante est4 = new Estudiante("Fabo2", "Martin Garrix2", "1a2","hotmail.com2","1232");
        ListaEnlazadaGenerica<Estudiante> l = new ListaEnlazadaGenerica<Estudiante>();
        l.agregarFinal(est1);
        l.agregarFinal(est2);
        l.agregarFinal(est3);
        l.agregarFinal(est4);
        l.comenzar();
        for (int i = 1; i <= l.tamanio(); i++){
            System.out.println(l.elemento(i).tusDatos());
        }
        
    }    
}
