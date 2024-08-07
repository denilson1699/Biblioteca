
package persistencia;

import negocio.FichaPrestamo;
import negocio.Libro;
import negocio.Lista;

public interface DaoLista {
    
public Lista Buscar(String IDLFP);
public String Registrar(Lista lista);
public String Actualizar(Lista lista);
public String Eliminar(String IDLFP);
}
