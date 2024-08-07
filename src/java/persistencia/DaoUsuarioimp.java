
package persistencia;

import negocio.Usuario;

public class DaoUsuarioimp implements DaoUsuario{



    @Override
    public Usuario Buscar(String docIdent) {
    String sql=" EXECUTE SP_BUSCAR_USUARIO '"+docIdent+"'";
    Object[] fila=Operacion.buscar(sql);
    if(fila!=null){
        Usuario usu= new Usuario();
        usu.setDocIdent(fila[0].toString());
        usu.setNombre(fila[1].toString());
        usu.setDireccion(fila[2].toString());
        usu.setPerfil(fila[3].toString());
        usu.setPass(fila[4].toString());
        return usu;
    }
    return null;
    }
    
    @Override
    public String Registrar(Usuario usu) {
        String msg;
        Usuario usuEncontrado = new Usuario();
        usuEncontrado=Buscar(usu.getDocIdent());
        if(usuEncontrado==null){
            String sql="SP_CREAR_USUARIO '"+usu.getDocIdent()+"','"+usu.getNombre()+"','"+usu.getDireccion()+"','"+usu.getPerfil()+"','"+usu.getPass()+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="Ya existe DocInt asignado";
        }
        return msg;
    }

    @Override
    public String Actualizar(Usuario usu) {
        String msg;
        Usuario usuEncontrado = new Usuario();
        usuEncontrado=Buscar(usu.getDocIdent());
        if(usuEncontrado!=null){
            String sql="SP_ACTUALIZAR_USUARIO '"+usu.getDocIdent()+"','"+usu.getNombre()+"','"+usu.getDireccion()+"','"+usu.getPerfil()+"','"+usu.getPass()+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe un cuenta asignada";
        }
        return msg;
        
    }

    @Override
    public String Eliminar(String docIdent) {
        String msg;
        Usuario usuEncontrado = new Usuario();
        usuEncontrado=Buscar(docIdent);
        if(usuEncontrado!=null){
            String sql="SP_ELIMINAR_USUARIO '"+docIdent+"'"; 
            msg=Operacion.ejecutar(sql);
        }else{
            msg="No existe un cuenta asignada";
        }
        return msg;
        
    }

   
    @Override
    public String Login(String docIdent, String pass) {
        String sql="EXECUTE SP_VALIDAR_LOGIN '"+docIdent+"','"+pass+"'";
        Object[] fila=Operacion.buscar(sql);
        return fila[0].toString();
    }
    

    
}
