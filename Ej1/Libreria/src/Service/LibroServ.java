package Service;
import Entity.Autor;
import Entity.Editorial;
import Entity.Libro;
import Persistence.ControladorPersistencia;
import java.util.ArrayList;
import java.util.Scanner;
public class LibroServ {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControladorPersistencia control = new ControladorPersistencia();
    Autor aut = new Autor();
   public void crearLibro() {
    String alta1;
    String respuesta;
    do {
        System.out.println("Ingrese el Id del Libro");
        Integer id = leer.nextInt();
        System.out.println("Ingrese el ISBN del Libro");
        Long isbn = leer.nextLong();
        System.out.println("Ingrese el Nombre del Libro:");
        String titulo = leer.next();
        System.out.println("Esta el libro dado de alta?");
        alta1 = leer.next();
        boolean alta2;
        if (alta1.equals("si")) {
            alta2 = true;
        } else {
            alta2 = false;
        }
        System.out.println("Cuantos ejemplares totales hay?");
        Integer ejemplares = leer.nextInt();
        System.out.println("Cuantos ejemplares vendidos hay?");
        Integer ejemplaresPrest = leer.nextInt();
        System.out.println("Ejemplares restantes: ");
        Integer ejemplaresRest = ejemplares - ejemplaresPrest;
        System.out.println("Total ejemplares: " + ejemplaresRest);
        System.out.println(" ");
        ArrayList<Editorial> lista = new ArrayList(control.traerEditoriales());
        for (Editorial ed : lista) {
            System.out.println("Estas son las editoriales: " + ed.getNombre());
        }
        System.out.println("Elija una editorial");
        String nombre2 = leer.next();
        Editorial edit = new Editorial();
        for (Editorial editorial : lista) {
            if (nombre2.equals(editorial.getNombre())) {
                edit = editorial;
            }
        }

        ArrayList<Autor> lista2 = new ArrayList(control.traerAutores());
        for (Autor au : lista2) {
            System.out.println("Estos son los autores: " + au.getNombre());
        }
        System.out.println("Elija un autor");
        String aut2 = leer.next();
        Autor aut = new Autor();
        for (Autor autor : lista2) {
            if (aut2.equals(autor.getNombre())) {
                aut = autor;
            }
        }
        System.out.println("Libro ingresado correctamente.");
        System.out.println("--------------");
        System.out.println("    ");
        System.out.println("Desea ingresar otro Libro? (si/no)");
        respuesta = leer.next();
        Libro lib = new Libro(id, isbn, titulo, ejemplares, ejemplaresPrest, ejemplaresRest, alta2, aut, edit);
        control.crearLibro(lib);
    } while (respuesta.equalsIgnoreCase("si"));
}
    public void eliminarLibro(Integer id) {
        System.out.println("Libro eliminado correctamente");
        System.out.println("--------------");
        System.out.println("    ");
        control.eliminarLibro(id);
    }
    public void editarLibro(Libro lib, Autor autor, Editorial edi){
        System.out.println("Ingrese todos los datos del libro");
        System.out.println("Titulo");
        lib.setTitulo(leer.next());
        System.out.println("ISBN");
        lib.setIsbn(leer.nextLong());
        System.out.println("ID");
        lib.setId(leer.nextInt());
        System.out.println("ID AUTOR");
        lib.setAutor(autor);
        System.out.println("ID EDITORIAL");
        lib.setEditorial(edi);
        System.out.println("Ejemplares totales y vendidos");
        lib.setEjemplares(leer.nextInt());
        lib.setEjemplaresPrestados(leer.nextInt());
        Integer ejemplaresRest = lib.getEjemplares() - lib.getEjemplaresPrestados();
        System.out.println("Ejemplares en circulacion: " + ejemplaresRest);
        System.out.println("Como quiere llamarlo?");
        lib.setTitulo(leer.next());
        if (lib.getTitulo() != null && !lib.getTitulo().isEmpty()) {
            lib.setAlta(true);
        }
        
        System.out.println("Libro Editado");
        control.editarLibro(lib);
    }
    public Libro buscarLibro(Integer id){
        return control.buscarLibro(id);
    }
    public ArrayList<Libro> traerLibros(){
    return control.traerLibros();
    }
    public void buscarLibroPorTitulo() {
     ArrayList<Libro> lista = new ArrayList(control.traerLibros());   
    System.out.println("Ingrese el titulo del libro que busca: ");          
       String elim= leer.next();
       Libro libro2 = new Libro();
       for (Libro libros : lista) {
            if (elim.equals(libros.getTitulo())) {
                libro2 = libros;
            }
        }
        System.out.println(libro2.toString());
    }
    public void buscarLibroAutor() {
        ArrayList<Libro> lista = new ArrayList(control.traerLibros());
        System.out.println("Indica el nombre del autor: ");

        String elim = leer.next();
        Libro libro2 = new Libro();
        for (Libro libros : lista) {
            if (elim.equals(libros.getAutor().getNombre())) {
                libro2 = libros;
            }
        }
        System.out.println(libro2.toString());
    }

    public void buscarLibroEditorial() {
        ArrayList<Libro> lista = new ArrayList(control.traerLibros());
        System.out.println("Indica el nombre de la editorial: ");

        String elim = leer.next();
        Libro libro2 = new Libro();
        for (Libro libros : lista) {
            if (elim.equals(libros.getEditorial().getNombre())) {
                libro2 = libros;
            }
        }

        System.out.println(libro2.toString());
    }
}

