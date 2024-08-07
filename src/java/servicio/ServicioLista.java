
package servicio;

import negocio.Lista;


public interface ServicioLista {
 
    public Lista Buscar(String IDLFP);
    public String RegistrarPrestamo(String IDLFP,String numId, String ISBN, String estado);
    public String Actualizar(String IDLFP, String numId, String ISBN, String estado);
    public String Eliminar(String IDLFP);
}
