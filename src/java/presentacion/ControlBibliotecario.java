
package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Ubibliotecario;
import negocio.Ucliente;
import negocio.Usuario;
import persistencia.Operacion;
import servicio.ServicioFichaPrestamo;
import servicio.ServicioFichaPrestamoImp;
import servicio.ServicioLibro;
import servicio.ServicioLibroImp;
import servicio.ServicioUsuario;
import servicio.ServicioUsuarioImp;

@WebServlet(name = "ControlBibliotecario", urlPatterns = {"/ControlBibliotecario"})
public class ControlBibliotecario extends HttpServlet {
    private ModeloPrincipal modPri;
    private ServicioLibro serLib;
    private ServicioFichaPrestamo serfp;
    private Operacion ope;
    private ServicioUsuario serUsu;
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        String acc= request.getParameter("acc");
            modPri= new ModeloPrincipal();
            serfp= new ServicioFichaPrestamoImp();
            serLib= new ServicioLibroImp();
            serUsu= new ServicioUsuarioImp();
            ope= new Operacion();
        if(acc.equals("Libros")){
            modPri.setLis(serfp.verificarExistencia(""));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibros.jsp");// abrir la ventana  empleado
        }if(acc.equals("Regresar")){ 
            request.getRequestDispatcher("ControlBibliotecario?acc=Libros").forward(request, response);
        }
        
           
        if(acc.equals("Buscar")){
            String texto=request.getParameter("nombre");
            modPri.setLis(serfp.verificarExistencia(texto));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibros.jsp");// abrir la ventana  empleado
        }
       
        if(acc.equals("Nuevo")){
            Object[] filAuto={ope.getAutoCodigoID("Libro")};
            modPri.setFil(filAuto);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibrosCrear.jsp");// abrir la ventana  empleado
        }
         if(acc.equals("Crear")){
            String ISBN=request.getParameter("ISBN");
            String Titulo=request.getParameter("Titulo");
            String Editorial=request.getParameter("Editorial");
            String Stock=request.getParameter("Stock");
            if(Titulo.equals("")||Editorial.equals("")||Stock.equals("")){
                modPri.setMsg("Complete todos los campos");
            }else{
                modPri.setMsg(serLib.Registrar(ISBN, Titulo, Editorial, Integer.parseInt(Stock)));
            }
            ope= new Operacion();
            Object[] filAuto={ope.getAutoCodigoID("Libro")};
            modPri.setFil(filAuto);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibrosCrear.jsp");// abrir la ventana  empleado
        }
        if(acc.equals("Eliminar")){ 
            String ISBN=(request.getParameter("ISBNList"));
            serLib.Eliminar(ISBN);
            modPri.setLis(serfp.verificarExistencia(""));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibros.jsp");// abrir la ventana  empleado
        }
         if(acc.equals("Editar")){
            String ISBN=request.getParameter("ISBNList");
            Object[]filauto=serLib.Buscar(ISBN);
            modPri.setFil(filauto);
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibrosActualizar.jsp");// abrir la ventana  empleado
            
        }if(acc.equals("Actualizar")){
            String ISBN=request.getParameter("ISBNEdit");
            String Titulo=request.getParameter("TituloEdit");
            String Editorial=request.getParameter("EditorialEdit");
            String Stock=request.getParameter("StockEdit");
            Object[]filauto={ISBN,Titulo,Editorial,Stock};
            modPri.setFil(filauto);
            modPri.setMsg(serLib.Actualizar(ISBN, Titulo, Editorial, Integer.parseInt(Stock)));
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("MantenerLibrosActualizar.jsp");// abrir la ventana  empleado
        }
        
        if(acc.equals("Usuarios")){
            request.getSession().setAttribute("msgMantenerUser", "");
            response.sendRedirect("MantenerUsuarios.jsp");// abrir la ventana  empleado
        }
         if(acc.equals("Grabar")){
            String msg="";
            Usuario usu;
            String perfil=request.getParameter("perfil");
            if(perfil.equalsIgnoreCase("B")){
                usu= new Ubibliotecario();
            }else{
                usu=new Ucliente();
            }
            usu.setDocIdent(request.getParameter("docident"));
            usu.setNombre(request.getParameter("nombre"));
            usu.setDireccion(request.getParameter("direc"));
            usu.setPass(request.getParameter("pass"));
                if(usu.getDocIdent().equals("")||usu.getNombre().equals("")||usu.getDireccion().equals("")||usu.getPass().equals("")){
                    msg="Complete todos los campos";
                }else{
                    msg=serUsu.Registrar(usu.getDocIdent(), usu.getNombre(), usu.getDireccion(), usu.getPerfil(),usu.getPass());  
                }

            request.getSession().setAttribute("msgMantenerUser", msg);
            response.sendRedirect("MantenerUsuarios.jsp");
            }
        if(acc.equals("Cancelar")){
            request.getRequestDispatcher("ControlBibliotecario?acc=Usuarios").forward(request, response);
            }
        
        
        if(acc.equals("Fichas")){
            response.sendRedirect("MantenerFichas.jsp");// abrir la ventana  empleado
        }
        if(acc.equals("Listas")){
            response.sendRedirect("MantenerListas.jsp");// abrir la ventana  empleado
        }
        
        
    
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
