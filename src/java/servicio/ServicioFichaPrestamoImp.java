
package servicio;

import java.util.List;
import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Usuario;
import persistencia.DaoFichaPrestamo;
import persistencia.DaoFichaPrestamoImp;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioimp;
import persistencia.Operacion;

public class ServicioFichaPrestamoImp  implements ServicioFichaPrestamo{

    private DaoFichaPrestamo daofp;
    private DaoUsuario daoUsu;
    private Operacion ope;

    public ServicioFichaPrestamoImp() {
        daofp= new DaoFichaPrestamoImp();
        daoUsu= new DaoUsuarioimp();
        ope= new Operacion();
    }
    
    
    
    @Override
    public FichaPrestamo Buscar(String numID) {
        return daofp.Buscar(numID);
    }

    @Override
    public String Registrar(String numID, String docIdent, String fechaRetiro, String fechaDevolucion) {
        FichaPrestamo fp= new FichaPrestamo(numID, fechaRetiro, fechaDevolucion, daoUsu.Buscar(docIdent));
        return daofp.Registrar(fp);
    }

    @Override
    public String Actualizar(String numID, String docIdent, String fechaRetiro, String fechaDevolucion) {
        FichaPrestamo fp= new FichaPrestamo(numID, fechaRetiro, fechaDevolucion, daoUsu.Buscar(docIdent));
        return daofp.Actualizar(fp);
    }

    @Override
    public String Eliminar(String NumID) {
        return daofp.Eliminar(NumID);
    }

    @Override
    public List verificarExistencia(String nombre) {
        return daofp.verificarExistencia(nombre);
    }

    @Override
    public String VerificarDisponibilidad(String fRetiro, String fDevolucion, String DocIdent) {
        String msg=null;
        String fechaActual=ope.getFechaActual();
        int fechaActualDia =Integer.parseInt(fechaActual.substring(8,10));
        int fechaActualMes =Integer.parseInt(fechaActual.substring(5,7));
        int fechaActualYear =Integer.parseInt(fechaActual.substring(0,4));
        
        int fechaRetiroDia =Integer.parseInt(fRetiro.substring(8,10));
        int fechaRetiroMes =Integer.parseInt(fRetiro.substring(5,7));
        int fechaRetiroYear =Integer.parseInt(fRetiro.substring(0,4));
        
        int fechaDevolucionDia =Integer.parseInt(fDevolucion.substring(8,10));
        int fechaDevolucionMes =Integer.parseInt(fDevolucion.substring(5,7));
        int fechaDevolucionYear =Integer.parseInt(fDevolucion.substring(0,4));
        
        
        if(fechaRetiroYear==fechaActualYear && fechaRetiroMes>=fechaActualMes && fechaRetiroDia>=fechaActualDia){
            if(fechaDevolucionYear==fechaRetiroYear && fechaDevolucionMes>=fechaRetiroMes && fechaDevolucionDia>fechaRetiroDia){
                msg=daofp.VerificarDisponibilidad(fRetiro, fDevolucion, DocIdent); 
            }else{
                msg="La F.Devolucion debe ser mayor a la F.Retiro"; 
            }      
        }else{
            msg="La F.Retiro debe ser  mayor o igual a la F.Actual";
        }
        return msg;
    }

    @Override
    public void SolictarPrestamo(Usuario usu1, Libro lib) {
    }
   
    
}
