
package servicio;

import negocio.Usuario;

public interface ServicioUsuario {
    
public Object[]  Buscar(String docIdent);
public String Registrar(String docIdent, String Nombre, String Dreccion, String perfil, String pass);
public String Actualizar(String docIdent, String Nombre, String Dreccion, String perfil, String pass);
public String Eliminar(String docIdent);
public String Login(String docIdent, String pass);
}
