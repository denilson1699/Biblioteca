package servicio;

import negocio.Usuario;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioimp;

public class ServicioUsuarioImp implements ServicioUsuario{

    private DaoUsuario daoUsu;
    
    public ServicioUsuarioImp() {
    daoUsu =new DaoUsuarioimp();
    }
    
    @Override
    public Object[] Buscar(String docIdent) {
        Usuario usu= daoUsu.Buscar(docIdent);
        if(usu!=null){
          Object[] u= new Object[5];
          u[0]= usu.getDocIdent();
          u[1]= usu.getNombre();
          u[2]= usu.getDireccion();
          u[3]= usu.getPerfil();
          u[4]= usu.getPass();
          return u;
      }
      return null;  
    }

    @Override
    public String Registrar(String docIdent, String nombre, String direccion, String perfil,String pass) {
        Usuario usu= new Usuario(docIdent, nombre, direccion, perfil,pass);
        return daoUsu.Registrar(usu);
    }

    @Override
    public String Actualizar(String docIdent, String nombre, String direccion, String perfil,String pass) {
        Usuario usu= new Usuario(docIdent, nombre, direccion, perfil,pass);
        return daoUsu.Actualizar(usu);
    }

    @Override
    public String Eliminar(String docIdent) {
        return daoUsu.Eliminar(docIdent);
    }

    @Override
    public String Login(String docIdent, String pass) {
        return daoUsu.Login(docIdent, pass);
    }
    
}
