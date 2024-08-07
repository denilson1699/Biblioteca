
package persistencia;

import java.sql.Connection;
import java.util.List;
import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Lista;
import negocio.Ucliente;
import negocio.Usuario;

public class Prueba {

    public static void main(String[] args) {
    /*
        // probar si hay conexion con la base de datos
        Connection cn= new Conexion().getConexionSqlServer();
        if(cn!=null){
            System.out.println("si hay conexion bd biblioteca");
        }else{
            System.out.println("no hay conexion bd biblioteca");
        }
    */
    
    DaoUsuarioimp  daoUsu= new DaoUsuarioimp();
    Ucliente ucli= new Ucliente();
    ucli.setNombre("cliente12");
    ucli.setDocIdent("12121212"); //12345677 bibliotecario 
    ucli.setDireccion("direcc12");
    ucli.setPass("1212");
    
    //**BUSCAR en bd tabla usuarios**
    Usuario usuEncotrado= new Usuario();
    usuEncotrado=daoUsu.Buscar("2");
    //System.out.println(usuEncotrado.getDocIdent()+usuEncotrado.getNombre()+usuEncotrado.getDireccion()+usuEncotrado.getPerfil()+usuEncotrado.getPass());
    
    //**REGISTRAR en bd tabla usuarios**
    //System.out.println(daoUsu.Registrar(ucli));
    
    //**ACTUALIZAR en bd tabla usuario**
    //System.out.println(daoUsu.Actualizar(ucli));
    
    //**ELIMINAR en bd tabla usuario**
    //System.out.println(daoUsu.Eliminar("12121212"));
    
    //**LOGIN bd tabla usuario**
    System.out.println("RESULTADO LOGIN:"+daoUsu.Login("123","123456"));
    
        
    
    DaoLibro  daoLib= new DaoLibroImp();
    Libro lib= new Libro("L0010","LIBRO3","EDITORIAL 3",20);
    
    //**BUSCAR en bd tabla usuarios**
    //Libro libEncotrado= new Libro();
    //libEncotrado=daoLib.Buscar(lib.getISBN());
    //System.out.println(libEncotrado.getISBN()+libEncotrado.getTitulo()+libEncotrado.getEditorial());
    
    //**REGISTRAR en bd tabla usuarios**
    //System.out.println(daoLib.Registrar(lib));
    
    //**ACTUALIZAR en bd tabla usuario**
    //System.out.println(daoLib.Actualizar(lib));
    
    //**ELIMINAR en bd tabla usuario**
    //System.out.println(daoLib.Eliminar(lib.getISBN()));
    
    
    
    
    DaoFichaPrestamo  daofp= new DaoFichaPrestamoImp();
    FichaPrestamo fp= new FichaPrestamo("f0001", "12/10/23", "12/20/23", ucli);
    
    
    //**BUSCAR en bd tabla ficha prestamos**
    //FichaPrestamo fpEncotrado= new FichaPrestamo();
    //fpEncotrado=daofp.Buscar(fp.getNumID());
    //System.out.println(fpEncotrado.getNumID()+fpEncotrado.getDocldent().getNombre()+fpEncotrado.getFechaRetiro()+fpEncotrado.getFechaDevolucion());
    
    //**REGISTRAR en bd ficha prestamos**
    //System.out.println(daofp.Registrar(fp));
    
    //**ACTUALIZAR en bd tabla usuario**
    //System.out.println(daofp.Actualizar(fp));
    
    //**ELIMINAR en bd tabla usuario**
    //System.out.println(daofp.Eliminar(fp.getNumID()));
    
    // LISTAR libros verificar existencia
    /*
    List lista =(List) daofp.verificarExistencia("lib");
    
    if(lista!=null){
        for(int i=0;i<lista.size();i++){
        Libro libLista=(Libro) lista.get(i);
         System.out.println(libLista.getISBN()+libLista.getTitulo());
        }
    }else
    {
        System.out.println("no hay lista");
    }
    */
    
    //VERIFICAR disponibilidad
    //System.out.println(daofp.VerificarDisponibilidad("12/10/23", "12/20/22", ucli.getDocIdent()));
    
    
    DaoLista daoLis= new DaoListaImp();
    //System.out.println(fp.getNumID());
    //System.out.println(fp.getDocldent().getDocIdent());
    //System.out.println(lib.getISBN());
    //Lista lis = new Lista("LFP01", fp, lib,"P");
    
    //**BUSCAR lista**
    //Lista lisEncotrado= new Lista();
    //lisEncotrado=daoLis.Buscar(lis.getIDLDF());
    //System.out.println(lisEncotrado.getIDLDF()+lisEncotrado.getISBN().getTitulo()+lisEncotrado.getNumID().getFechaDevolucion());
    
    //REGISTRAR lista**
    //System.out.println(daoLis.Registrar(lis));
    
    //**ACTUALIZAR lista**
    //System.out.println(daoLis.Actualizar(lis));
    
    //**ELIMINAR lista**
    //System.out.println(daoLis.Eliminar(lis.getIDLDF()));
    
    
    //ENCRIPTACION
    //Operacion opera= new Operacion();
    //System.out.println(opera.getAutoCodigoID("libro"));
    //opera.Encriptacion("hola■");
    
    }
    
}
