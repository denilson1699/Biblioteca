
package persistencia;

import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Lista;

public class DaoListaImp implements DaoLista{

    @Override
    public Lista Buscar(String IDLFP) {
        
    String sql="select *from lista where IDLFP='"+IDLFP+"'";
    Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Lista lista= new Lista();
            lista.setIDLDF(fila[0].toString());
            
            FichaPrestamo fp= new FichaPrestamo();
            DaoFichaPrestamo daofp= new DaoFichaPrestamoImp();
            fp=daofp.Buscar(fila[1].toString());
            lista.setNumID(fp);
            
            Libro lib= new Libro();
            DaoLibro daolib= new DaoLibroImp();
            lib=daolib.Buscar(fila[2].toString());
            lista.setISBN(lib);
            
            lista.setEstado(fila[3].toString());
            
            return lista;
        }
        return null;
    }

    @Override
    public String Registrar(Lista lista) {
        String msg;
        Lista LisEncontrado = new Lista();
        LisEncontrado=Buscar(lista.getIDLDF());
        if(LisEncontrado==null){
            String sql="insert into lista values('"+lista.getIDLDF()+"','"+lista.getNumID().getNumID()+"','"+lista.getISBN().getISBN()+"','"+lista.getEstado()+"')"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="Ya existe una Codigo registrado";
        }
        return msg;
    }

    @Override
    public String Actualizar(Lista lista) {
        String msg;
        Lista LisEncontrado = new Lista();
        LisEncontrado=Buscar(lista.getIDLDF());
        if(LisEncontrado!=null){
            String sql="update lista set estado='"+lista.getEstado()+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe un registrado";
        }
        return msg;
    }

    @Override
    public String Eliminar(String IDLFP) {
        String msg;
        Lista LisEncontrado = new Lista();
        LisEncontrado=Buscar(IDLFP);
        if(LisEncontrado!=null){
            String sql="delete lista where IDLFP='"+IDLFP+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe un registrado";
        }
        return msg;
    }

}
