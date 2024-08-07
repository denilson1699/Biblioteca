
package servicio;

import java.util.List;
import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Usuario;

public interface ServicioFichaPrestamo {
    
    public FichaPrestamo Buscar(String numID);
    public String Registrar(String numID, String docIdent, String fechaRetiro, String fechaDevolucion );
    public String Actualizar(String numID, String docIdent, String fechaRetiro, String fechaDevolucion );
    public String Eliminar(String NumID);
    public List  verificarExistencia(String nombre);
    public String VerificarDisponibilidad(String fRetiro, String fDevolucion, String DocIdent);
    public void SolictarPrestamo(Usuario usu, Libro lib);
    
}
