
package negocio;

public class FichaPrestamo {

private String numID, fechaRetiro, fechaDevolucion;
private Usuario Docldent;

    public FichaPrestamo() {
    }

    public FichaPrestamo(String numID, String fechaRetiro, String fechaDevolucion, Usuario Docldent) {
        this.numID = numID;
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.Docldent = Docldent;
    }

    public String getNumID() {
        return numID;
    }

    public void setNumID(String numID) {
        this.numID = numID;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getDocldent() {
        return Docldent;
    }

    public void setDocldent(Usuario Docldent) {
        this.Docldent = Docldent;
    }

}
