package persistencia;
import negocio.Libro;

public class DaoLibroImp implements DaoLibro{



    @Override
    public Libro Buscar(String ISBN) {
    String sql="select *from libro where ISBN='"+ISBN+"'";
    Object[] fila=Operacion.buscar(sql);
        if(fila!=null){
            Libro lib= new Libro();
            lib.setISBN(fila[0].toString());
            lib.setTitulo(fila[1].toString());
            lib.setEditorial(fila[2].toString());
            lib.setStock((int)fila[3]);
            return lib;
        }
        return null;
    }
    
    @Override
    public String Registrar(Libro lib) {
        String msg;
        Libro libEncontrado = new Libro();
        libEncontrado=Buscar(lib.getISBN());
        if(libEncontrado==null){
            String sql="insert into libro values('"+lib.getISBN()+"','"+lib.getTitulo()+"','"+lib.getEditorial()+"','"+lib.getStock()+"')"; 
             msg=Operacion.ejecutar(sql);
        }else{
            msg="Ya existe una ISBM registrado";
        }
        return msg;
    }

    @Override
    public String Actualizar(Libro lib) {
        String msg;
        Libro libEncontrado = new Libro();
        libEncontrado=Buscar(lib.getISBN());
        if(libEncontrado!=null){
            String sql="update libro set titulo='"+lib.getTitulo()+"',editorial='"+lib.getEditorial()+"',stock='"+lib.getStock()+"' where ISBN='"+lib.getISBN()+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe ISBN registrado";
        }
        return msg;
    }

    @Override
    public String Eliminar(String ISBN) {
        
        String msg;
        Libro libEncontrado = new Libro();
        libEncontrado=Buscar(ISBN);
        if(libEncontrado!=null){
            String sql="delete libro where ISBN='"+ISBN+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe ISBN registrado";
        }
        return msg;
        
    }
    
}
