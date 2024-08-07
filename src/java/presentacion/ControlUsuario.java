
package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.FichaPrestamo;
import negocio.Usuario;
import servicio.ServicioFichaPrestamo;
import servicio.ServicioFichaPrestamoImp;
import servicio.ServicioUsuario;
import servicio.ServicioUsuarioImp;


@WebServlet(name = "ControlUsuario", urlPatterns = {"/ControlUsuario"})
public class ControlUsuario extends HttpServlet {

    private ModeloPrincipal modPri;
    private ServicioFichaPrestamo serfp;
    private ServicioUsuario serUsu;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String acc= request.getParameter("acc");
        serfp= new ServicioFichaPrestamoImp();
        modPri= new ModeloPrincipal();
        serUsu= new ServicioUsuarioImp();
        
        if(acc.equals("Registrar")){
            modPri.setMsg("");
            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("ResitarUsuario.jsp");// abrir la ventana  empleado
        }
        if(acc.equals("Ingresar")){
            String docIdent=request.getParameter("docIdent");
            String pass=request.getParameter("pass");
            String msg=serUsu.Login(docIdent, pass);
            if(!docIdent.isEmpty()||!pass.isEmpty()){
                if(msg.equalsIgnoreCase("TRUE")){
                    Object[] usu=serUsu.Buscar(docIdent);
                    if(usu[3].toString().equalsIgnoreCase("C")){
                        modPri.setLis(serfp.verificarExistencia(""));
                        
                        request.getSession().setAttribute("DNI", docIdent);
                        request.getSession().setAttribute("modPri", modPri);
                        response.sendRedirect("ListarLibro.jsp");// abrir la ventana  empleado
                    }else{
                        response.sendRedirect("MenuBibliotecario.jsp");// abrir la ventana  empleado
                    }
                }else{
                    request.getSession().setAttribute("msg", msg);
                    response.sendRedirect("index.jsp");// abrir la ventana  empleado
                }
            }else{
                request.getSession().setAttribute("msg", "");
                response.sendRedirect("index.jsp");// abrir la ventana  empleado   
            }
        }
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
