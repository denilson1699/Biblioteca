/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.ArrayList;
import java.util.List;
import negocio.Libro;
import persistencia.Operacion;
import servicio.ServicioFichaPrestamo;
import servicio.ServicioFichaPrestamoImp;
import servicio.ServicioLibro;
import servicio.ServicioLibroImp;

/**
 *
 * @author denilson
 */
public class prueb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Operacion ope= new Operacion();
        ModeloPrincipal modPri= new ModeloPrincipal();
            Object[] filAuto={ope.getAutoCodigoID("Libro")};
            modPri.setFil(filAuto);
            System.out.println(modPri.getFil()[0]);
       
    }
    
}
