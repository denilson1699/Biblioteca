
package negocio;


public class Usuario {
    
protected String docIdent, nombre, direccion, perfil,pass;

    public Usuario() {
    }

    public Usuario(String docIdent, String nombre, String direccion, String perfil, String pass) {
        this.docIdent = docIdent;
        this.nombre = nombre;
        this.direccion = direccion;
        this.perfil = perfil;
        this.pass= pass;
    }

    public String getDocIdent() {
        return docIdent;
    }

    public void setDocIdent(String docIdent) {
        this.docIdent = docIdent;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    
}
