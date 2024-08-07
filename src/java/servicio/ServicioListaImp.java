
package servicio;

import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Lista;
import negocio.Usuario;
import persistencia.DaoFichaPrestamo;
import persistencia.DaoFichaPrestamoImp;
import persistencia.DaoLibro;
import persistencia.DaoLibroImp;
import persistencia.DaoLista;
import persistencia.DaoListaImp;
import persistencia.Operacion;

public class ServicioListaImp implements ServicioLista{

    private DaoLista daoLis;
    private DaoFichaPrestamo daofp;
    private DaoLibro daoLib;
    private Operacion opera;
    
    public ServicioListaImp() {
        daoLis= new DaoListaImp();
        daofp= new DaoFichaPrestamoImp();
        daoLib= new DaoLibroImp();
        opera= new Operacion();
        
    }
    
    
    @Override
    public Lista Buscar(String IDLFP) {
      return daoLis.Buscar(IDLFP);
    
    }

    @Override
    public String RegistrarPrestamo(String IDLFP,String numId, String ISBN, String estado) {
        Lista lista= new Lista(IDLFP, daofp.Buscar(numId),daoLib.Buscar(ISBN), estado);
        return daoLis.Registrar(lista);
    }

    @Override
    public String Actualizar(String IDLFP, String numId, String ISBN, String estado) {
        Lista lista= new Lista(opera.getAutoCodigoID("Lista"), daofp.Buscar(numId),daoLib.Buscar(ISBN), estado);
        return daoLis.Actualizar(lista);
    }

    @Override
    public String Eliminar(String IDLFP) {
        return daoLis.Eliminar(IDLFP);
    }
    


}
