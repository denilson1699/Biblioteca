
package negocio;

public class Libro {
    
    private String ISBN, titulo, editorial;
    private int Stock;

    public Libro() {
    }

    public Libro(String ISBN, String titulo, String editorial, int Stock) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editorial = editorial;
        this.Stock=Stock;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
    
    
    
    
}
