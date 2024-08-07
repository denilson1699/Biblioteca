
package persistencia;

import negocio.Libro;

public interface DaoLibro {

public Libro  Buscar(String ISBN);
public String Registrar(Libro lib);
public String Actualizar(Libro lib);
public String Eliminar(String ISBN);

}
