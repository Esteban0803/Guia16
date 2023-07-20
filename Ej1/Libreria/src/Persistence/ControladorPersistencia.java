package Persistence;

import Entity.Autor;
import Entity.Editorial;
import Entity.Libro;
import Persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {
    
    AutorJpaController autJpa = new AutorJpaController();
    EditorialJpaController ediJpa = new EditorialJpaController();
    LibroJpaController libJpa = new LibroJpaController();
    public ArrayList<Editorial> traerEditoriales;

    public void crearAutor(Autor aut) {
        autJpa.create(aut);
    }

    public void eliminarAutor(Integer Id) {
        try {
            autJpa.destroy(Id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, "Este Id no existe en la base de datos", ex);
        }
    } 

    public void editarAutor(Autor aut) {
        try {
            autJpa.edit(aut);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, "El autor no existe", ex);
        }
    }

    public Autor buscarAutor(Integer id) {
        return autJpa.findAutor(id);
    }

    public ArrayList<Autor> traerAutores() {
        List<Autor> lista = autJpa.findAutorEntities();
        ArrayList<Autor> listaAutores = new ArrayList<Autor> (lista);
        return listaAutores;
    }

    public void crearEditorial(Editorial edi) {
        ediJpa.create(edi);
    }

    public void eliminarEditorial(Integer id) {
        try {
            ediJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, "Esta id no existe en la base de datos", ex);
        }
    }

    public void editarEditorial(Editorial edi) {
        try {
            ediJpa.edit(edi);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, "Esta editorial no existe", ex);
        }
    }

    public Editorial buscarEditorial(Integer id) {
       return ediJpa.findEditorial(id); 
    }

    public ArrayList<Editorial> traerEditoriales() {
        List<Editorial> lista = ediJpa.findEditorialEntities();
        ArrayList<Editorial> listaEditoriales = new ArrayList<Editorial>(lista);
        return listaEditoriales;
    }

    public void crearLibro(Libro lib) {
        libJpa.create(lib);
    }

    public void eliminarLibro(Integer id) {
        try {
            libJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, "Libro inexistente", ex);
        }
    }

    public void editarLibro(Libro lib) {
        try {
            libJpa.edit(lib);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, "Libro inexistente", ex);
        }
    }

    public Libro buscarLibro(Integer id) {
        return libJpa.findLibro(id);
    }

    public ArrayList<Libro> traerLibros() {
        List<Libro> lista = libJpa.findLibroEntities();
        ArrayList<Libro> listaLibro = new ArrayList<Libro>(lista);
        return listaLibro;
    }
 
}
