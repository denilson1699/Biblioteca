
package negocio;

import java.util.List;

public class Prueba {

    public static void main(String[] arg){
        Ucliente ucli= new Ucliente();
        ucli.setNombre("cliente1");
        ucli.setDocIdent("12345678");
        ucli.setDireccion("direcc1");
        //ucli.setPerfil("m");
        Libro lib= new Libro("l001", "Libro1", "editorial",20);
        FichaPrestamo fp= new FichaPrestamo("f001","10/10/10","20/10/10", ucli);
        Lista lista= new Lista("l001", fp, lib,"A");

        System.out.println("libro:"+lista.getISBN().getTitulo());
        System.out.println("cliente:"+lista.getNumID().getDocldent().nombre+" perfil:"+lista.getNumID().getDocldent().getPerfil());
    }
}
