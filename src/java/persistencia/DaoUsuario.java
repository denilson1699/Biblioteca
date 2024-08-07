
package persistencia;

import negocio.Usuario;

public interface DaoUsuario {

public Usuario  Buscar(String docIdent);
public String Registrar(Usuario usu);
public String Actualizar(Usuario usu);
public String Eliminar(String docIdent);
public String Login(String docIdent, String pass);

}
