
package servicio;

import java.util.List;
import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Usuario;

public class Prueba {

    public static void main(String[] args) {
        
        ServicioUsuario serUsu= new ServicioUsuarioImp();
        /*
        Object[] usu=serUsu.Buscar("12345678");
        if(usu!=null){

            System.out.println(usu[0]);
            System.out.println(usu[1]);
        }else{
            System.out.println("NO existe usuario");
        }
        */
        //System.out.println(serUsu.Registrar("12345674", "no", "xx", "b"));
        
        /*
        ServicioLibro serLib= new ServicioLibroImp();
        Object[] lib=serLib.Buscar("N001");
        if(lib!=null){

            System.out.println(lib[0]);
            System.out.println(lib[1]);
        }else{
            System.out.println("NO existe libro");
        }
        */
        
        System.out.println(serUsu.Registrar("1", "n", "d", "B", "11"));
        
        ServicioFichaPrestamo serfp= new ServicioFichaPrestamoImp();
        //FichaPrestamo fp =serfp.Buscar("f0001");
        //System.out.println(fp.getNumID()+fp.getDocldent().getNombre()+fp.getFechaDevolucion());
        /*
        List lista =(List) serfp.verificarExistencia("lib");
        if(lista!=null){
            for(int i=0;i<lista.size();i++){
            Libro libLista=(Libro) lista.get(i);
            System.out.println(libLista.getISBN()+libLista.getStock());
           }
        }else{
            System.out.println("no hay lista");
        }
       */
        /*
        ServicioLista serLis= new ServicioListaImp();
        System.out.println(serLis.RegistrarPrestamo("f0001", "L0010", "A"));
        */
        
    }
    
}
