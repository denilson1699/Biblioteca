
package negocio;

public class Lista {

private String IDLDF;
private FichaPrestamo numID;
private Libro ISBN;
private String estado;

  public Lista() {
    }
  
    public Lista(String IDLDF, FichaPrestamo numID, Libro ISBN, String estado) {
        this.IDLDF = IDLDF;
        this.numID = numID;
        this.ISBN = ISBN;
        this.estado=estado;
    }

    public String getIDLDF() {
        return IDLDF;
    }

    public void setIDLDF(String IDLDF) {
        this.IDLDF = IDLDF;
    }

    public FichaPrestamo getNumID() {
        return numID;
    }

    public void setNumID(FichaPrestamo numID) {
        this.numID = numID;
    }

    public Libro getISBN() {
        return ISBN;
    }

    public void setISBN(Libro ISBN) {
        this.ISBN = ISBN;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

}
