
package servicio;

import negocio.Libro;

public interface ServicioLibro {
    
    public Object[]  Buscar(String ISBN);
    public String Registrar(String ISBN, String titulo, String editorial, int stock);
    public String Actualizar(String ISBN, String titulo, String editorial, int stock);
    public String Eliminar(String ISBN);
}
