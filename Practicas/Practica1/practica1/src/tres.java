package practica1.src;

public class tres {
    public static void main(String[] args) {
        Estudiante[] EstArray = new Estudiante[2];
        Profesor[] ProArray = new Profesor[3];
        EstArray[0] = new Estudiante("Fabian", "Martinez", "1b","gmail.com","74/23");
        EstArray[1] = new Estudiante("Fabo", "Martin Garrix", "1a","hotmail.com","123");

        ProArray[0] = new Profesor("Carlos","Menem","gmail.com","ideas","unlp");
        ProArray[1] = new Profesor("Pepe","Lotas","hotmail.com","ideas","unlp");
        ProArray[2] = new Profesor("Roberto","Tototo","mail.com","ideas","unlp");
        
        System.out.println("Estudiantes:");
        for(int i=0; i<2;i++){
            System.out.println(EstArray[i].tusDatos());
        }
        System.out.println("Profesores:");
        for(int i=0; i<3;i++){
            System.out.println(ProArray[i].tusDatos());
        }
    }
}
