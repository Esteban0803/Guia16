package Service;
import Entity.Editorial;
import Persistence.ControladorPersistencia;
import java.util.ArrayList;
import java.util.Scanner;

public class EditorialServ {
    Editorial edi = new Editorial();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControladorPersistencia control = new ControladorPersistencia();
    public void crearEditorial(Editorial edi){
        String respuesta;
        do {
            System.out.println("Ingrese el Id del Editorial");
            edi.setId(leer.nextInt());
            System.out.println("Ingrese el Nombre de la Editorial:");
            edi.setNombre(leer.next());
            if (edi.getNombre() != null && !edi.getNombre().isEmpty()) {
                edi.setAlta(true);
            }
            System.out.println("Editorial ingresada correctamente.");
            System.out.println("--------------");
            System.out.println("    ");
            System.out.println("Desea ingresar otra Editorial? si/no");
            respuesta = leer.next();
            control.crearEditorial(edi);
        } while (respuesta.equalsIgnoreCase("si"));
    }
    public void eliminarEditorial(Integer id){
        System.out.println("Editorial eliminada correctamente");
        System.out.println("--------------");
        System.out.println("    ");
        control.eliminarEditorial(id);
    }
    public void editarEditorial(Editorial edi){
        System.out.println("Ingrese la nombre y la id de la Editorial");
        edi.setNombre(leer.next());
        edi.setId(leer.nextInt());
        System.out.println("Como quiere llamarlo?");
        edi.setNombre(leer.next());
        if (edi.getNombre() != null && !edi.getNombre().isEmpty()) {
            edi.setAlta(true);
        }
        System.out.println("Editorial Editada");
        control.editarEditorial(edi);
    }
    public Editorial buscarEditorial(Integer id){
        return control.buscarEditorial(id);
    }
    public ArrayList<Editorial> traerEditoriales(){
    return control.traerEditoriales();
}
}