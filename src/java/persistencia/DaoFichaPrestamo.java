
package persistencia;

import java.util.List;
import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Usuario;

public interface DaoFichaPrestamo {
    
    
public FichaPrestamo Buscar(String numID);
public String Registrar(FichaPrestamo fp);
public String Actualizar(FichaPrestamo fp);
public String Eliminar(String NumID);
public List verificarExistencia(String nombre);
public String VerificarDisponibilidad(String fRetiro, String fDevolucion, String DocIdent);
}
