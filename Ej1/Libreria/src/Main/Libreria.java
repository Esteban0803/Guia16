package Main;
import Entity.Autor;
import Entity.Editorial;
import Entity.Libro;
import Service.AutorServ;
import Service.EditorialServ;
import Service.LibroServ;
import java.util.Scanner;

public class Libreria {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        AutorServ s1 = new AutorServ();
        EditorialServ s2 = new EditorialServ();
        LibroServ s3 = new LibroServ();
        Autor aut = new Autor();
        Editorial edi = new Editorial();
        Libro lib = new Libro();
        int opcion;
        do {
            System.out.println("Selecciona una opcion:");
            System.out.println("/////////////////////////");
            System.out.println("         Libreria           ");
            System.out.println("1. Ingresar Autor");
            System.out.println("2. Ingresar Editorial");
            System.out.println("3. Ingresar Libro");
            System.out.println("--------------------------");
            System.out.println("4. Buscar Autor");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("6. Buscar libro por titulo");
            System.out.println("7. Bucar libro por autor");
            System.out.println("8. Buscar libro por editorial");
            System.out.println("/////////////////////////");
            System.out.println(" ");
            System.out.println("9. Salir");
            System.out.println(" ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> s1.crearAutor(aut);
                case 2 -> s2.crearEditorial(edi);
                case 3 -> s3.crearLibro();
                case 4 -> {
                    System.out.println("A que Autor quiere buscar?");
                    aut = s1.buscarAutor(leer.nextInt());
                    System.out.println("El autor es: " + aut.getNombre());
                    System.out.println("--------------");
                    System.out.println("    ");
                }
                case 5 -> {
                    System.out.println("Que libro quiere buscar?");
                    lib = s3.buscarLibro(leer.nextInt());
                    System.out.println("El libro es: " + lib.getTitulo() + " de " + lib.getAutor());
                    System.out.println("--------------");
                    System.out.println("    ");
                }
                case 6 -> s3.buscarLibroPorTitulo();
                case 7 -> s3.buscarLibroAutor();
                case 8 -> s3.buscarLibroEditorial();
            }
        } while (opcion != 9);
    }
}