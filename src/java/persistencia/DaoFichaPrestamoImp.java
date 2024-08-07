
package persistencia;

import java.util.ArrayList;
import java.util.List;
import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Ucliente;
import negocio.Usuario;


public class DaoFichaPrestamoImp implements DaoFichaPrestamo{

    @Override
    public FichaPrestamo Buscar(String numID) {
        
    String sql="select *from ficha_prestamo where num_id='"+numID+"'";
    Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            FichaPrestamo fp= new FichaPrestamo();
            fp.setNumID(fila[0].toString());
            Usuario usu= new Usuario();
            DaoUsuario daoUsu= new DaoUsuarioimp();
            usu=daoUsu.Buscar(fila[1].toString());
            fp.setDocldent(usu);
            fp.setFechaRetiro(fila[2].toString());
            fp.setFechaDevolucion(fila[3].toString());;
            return fp;
        }
        return null;
    }

    @Override
    public String Registrar(FichaPrestamo fp) {
        String msg;
        FichaPrestamo fpEncontrado = new FichaPrestamo();
        fpEncontrado=Buscar(fp.getNumID());
        if(fpEncontrado==null){
            String sql="insert into ficha_prestamo values('"+fp.getNumID()+"','"+fp.getDocldent().getDocIdent()+"','"+fp.getFechaRetiro()+"','"+fp.getFechaDevolucion()+"')"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="Ya existe una Codigo FP registrado";
        }
        return msg;
    }

    @Override
    public String Actualizar(FichaPrestamo fp) {
        String msg;
        FichaPrestamo fpEncontrado = new FichaPrestamo();
        fpEncontrado=Buscar(fp.getNumID());
        if(fpEncontrado!=null){
            String sql="update ficha_prestamo set fecha_retiro='"+fp.getFechaRetiro()+"',fecha_devolucion='"+fp.getFechaDevolucion()+"' where num_id='"+fp.getNumID()+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe un registrado";
        }
        return msg;
    }

    @Override
    public String Eliminar(String NumID) {
    
        String msg;
        FichaPrestamo fpEncontrado = new FichaPrestamo();
        fpEncontrado=Buscar(NumID);
        if(fpEncontrado!=null){
            String sql="delete ficha_prestamo where num_id='"+NumID+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe un registrado";
        }
        return msg;
    }

    @Override
    public List verificarExistencia(String nombre) {
         List lis=new ArrayList();
        String sql="select *from libro where titulo like'%"+nombre+"%'";
        List lista=Operacion.listar(sql);
        if(lista!=null){
          for(int i=1;i<lista.size();i++){
            Object[] fila=(Object[])lista.get(i);
            Libro lib= new Libro();
            lib.setISBN(fila[0].toString());
            lib.setTitulo(fila[1].toString());
            lib.setEditorial(fila[2].toString());
            lib.setStock(Integer.parseInt(fila[3].toString()));
            lis.add(lib);
          }
          return lis;
        }
    return null; 
    }

    @Override
    public String VerificarDisponibilidad(String fRetiro, String fDevolucion, String DocIdent) {   
    String sql="select *from ficha_Prestamo where fecha_retiro='"+fRetiro+"' and fecha_devolucion='"+fDevolucion+"' and doc_ident='"+DocIdent+"'";
    
   // String sql="select *from ficha_Prestamo where fecha_retiro='"+fRetiro+"' and fecha_devolucion='"+fDevolucion+"'";
    Object[] fila=Operacion.buscar(sql);
        if(fila==null){
            return "Esta disponible";
        }
        return "Tiene una ficha de prestamo asignada en esas fechas";
    }
    
}
