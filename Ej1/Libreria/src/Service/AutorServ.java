package Service;
import Entity.Autor;
import Persistence.ControladorPersistencia;
import java.util.ArrayList;
import java.util.Scanner;

public class AutorServ {
    Autor aut = new Autor();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControladorPersistencia control = new ControladorPersistencia();
    public void crearAutor(Autor aut){
     String respuesta;
        do {
            System.out.println("Ingrese el Id del Autor");
            aut.setId(leer.nextInt());
            System.out.println("Ingrese el Nombre del Autor:");
            aut.setNombre(leer.next());
            if (aut.getNombre() != null && !aut.getNombre().isEmpty()) {
                aut.setAlta(true);
            }
            System.out.println("Autor ingresado correctamente.");
            System.out.println("--------------");
            System.out.println("    ");
            System.out.println("Desea ingresar otro autor? si/no");
            respuesta = leer.next();
            control.crearAutor(aut);
        } while (respuesta.equalsIgnoreCase("si"));
    }

    public void eliminarAutor(Integer id){
        System.out.println("Autor eliminado correctamente");
        System.out.println("--------------");
        System.out.println("    ");
        control.eliminarAutor(id);
    }
    
    public void editarAutor (Autor aut){
        System.out.println("Ingrese el Nombre y la Id del Autor a Editar");
        aut.setNombre(leer.next());
        aut.setId(leer.nextInt());
        System.out.println("Como quiere llamarlo?");
        aut.setNombre(leer.next());
        if (aut.getNombre() != null && !aut.getNombre().isEmpty()) {
            aut.setAlta(true);
        }
        System.out.println("Autor Editado");
        control.editarAutor(aut);
    }
    public Autor buscarAutor(Integer Id){
        return control.buscarAutor(Id);
    }
    public ArrayList<Autor> traerAutores(){
        return control.traerAutores();
    }
}
