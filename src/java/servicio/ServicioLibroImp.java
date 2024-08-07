
package servicio;

import negocio.Libro;
import persistencia.DaoLibro;
import persistencia.DaoLibroImp;

public class ServicioLibroImp implements ServicioLibro{
    private DaoLibro daoLib;

    public ServicioLibroImp() {
        daoLib = new DaoLibroImp();
    }
    
    
    @Override
    public Object[] Buscar(String ISBN) {
       Libro lib= daoLib.Buscar(ISBN);
      if(lib!=null){
        Object[] l= new Object[4];
        l[0]= lib.getISBN();
        l[1]= lib.getTitulo();
        l[2]= lib.getEditorial();
        l[3]= lib.getStock();
        return l;
    }
    return null;  
    }

    @Override
    public String Registrar(String ISBN, String titulo, String editorial, int stock) {
        Libro lib = new Libro(ISBN, titulo, editorial, stock);
        return daoLib.Registrar(lib);
    }

    @Override
    public String Actualizar(String ISBN, String titulo, String editorial, int stock) {
        Libro lib = new Libro(ISBN, titulo, editorial, stock);
        return daoLib.Actualizar(lib);
    }

    @Override
    public String Eliminar(String ISBN) {
        return daoLib.Eliminar(ISBN);
    }
    
}
