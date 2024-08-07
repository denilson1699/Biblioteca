
    package presentacion;

    import java.io.IOException;
    import java.io.PrintWriter;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import negocio.Libro;
    import negocio.Ucliente;
    import negocio.Usuario;
    import persistencia.Operacion;
    import servicio.ServicioFichaPrestamo;
    import servicio.ServicioFichaPrestamoImp;
    import servicio.ServicioLibro;
    import servicio.ServicioLibroImp;
    import servicio.ServicioLista;
    import servicio.ServicioListaImp;
    import servicio.ServicioUsuario;
    import servicio.ServicioUsuarioImp;


    @WebServlet(name = "ControlCliente", urlPatterns = {"/ControlCliente"})
    public class ControlCliente extends HttpServlet {
        private ServicioUsuario serUsu;
        private ModeloPrincipal modPri;
        private ServicioFichaPrestamo serfp;
        private Operacion ope;
        private ServicioLista serLis;
        private ServicioLibro serLib;
        private Libro lib;
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
           String acc=request.getParameter("acc");
           serUsu= new ServicioUsuarioImp();
           modPri= new ModeloPrincipal();
           serfp= new ServicioFichaPrestamoImp();
           ope= new Operacion();
           serLis= new ServicioListaImp();
           serLib = new ServicioLibroImp();
           lib= new Libro();

           if(acc.equals("Grabar")){
            Ucliente usuC= new Ucliente();
                usuC.setDocIdent(request.getParameter("docident"));
                usuC.setNombre(request.getParameter("nombre"));
                usuC.setDireccion(request.getParameter("direc"));
                usuC.setPass(request.getParameter("pass"));
                if(usuC.getDocIdent().equals("")||usuC.getNombre().equals("")||usuC.getDireccion().equals("")||usuC.getPass().equals("")){
                    modPri.setMsg("Complete todos los campos");
                }else{
                    modPri.setMsg(serUsu.Registrar(usuC.getDocIdent(), usuC.getNombre(), usuC.getDireccion(), usuC.getPerfil(),usuC.getPass()));
                }

            request.getSession().setAttribute("modPri", modPri);
            response.sendRedirect("ResitarUsuario.jsp");
            }
           if(acc.equals("Cancelar")){
            response.sendRedirect("index.jsp");
            }
           if(acc.equals("Buscar")){
                String texto=request.getParameter("nombre");
                modPri.setLis(serfp.verificarExistencia(texto));
                request.getSession().setAttribute("modPri", modPri);
                response.sendRedirect("ListarLibro.jsp");// abrir la ventana  empleado
            }
           if(acc.equals("SolicitarPrestamo")){
                String ISBN=request.getParameter("ISBN");
                String DNIusuario=request.getParameter("DNIusuario");
                Object[] filaLib= {serLib.Buscar(ISBN)[0],serLib.Buscar(ISBN)[1],serLib.Buscar(ISBN)[2],serLib.Buscar(ISBN)[3],DNIusuario};
                if(Integer.parseInt(filaLib[3].toString())>=1){
                    modPri.setFil(filaLib);
                    request.getSession().setAttribute("modPri", modPri);
                    response.sendRedirect("VerificarDisponibilidad.jsp");
                }else{
                String texto=request.getParameter("nombre");
                modPri.setLis(serfp.verificarExistencia(texto));
                modPri.setMsg("Libro sin stock");
                request.getSession().setAttribute("modPri", modPri);
                response.sendRedirect("ListarLibro.jsp");// abrir la ventana  empleado
                }
            }

           if(acc.equals("Regresar")){
                modPri.setLis(serfp.verificarExistencia(""));
                request.getSession().setAttribute("modPri", modPri);
                response.sendRedirect("ListarLibro.jsp");// abrir la ventana  empleado
            }
           if(acc.equals("Verificar Disponibilidad")){
                String ISBN=request.getParameter("ISBN");
                String Titulo=request.getParameter("Titulo");
                String DocIdent=request.getParameter("DocIdent");
                String fRetiro=request.getParameter("fRetiro");
                String fDevolucion=request.getParameter("fDevolucion");
                if(!fRetiro.isEmpty()&&!fDevolucion.isEmpty()){
                        String msg=serfp.VerificarDisponibilidad(fRetiro, fDevolucion, DocIdent);
                        if(msg.equalsIgnoreCase("Esta disponible")){
                            Object[]filauto={ope.getAutoCodigoID("FICHA_PRESTAMO"),ISBN,fRetiro,fDevolucion,DocIdent};
                            modPri.setFil(filauto);
                            request.getSession().setAttribute("modPri", modPri);
                            response.sendRedirect("CrearFichaPrestamo.jsp");
                        }else{
                            Object[]filauto={ISBN,Titulo,DocIdent};
                            modPri.setFil(filauto);
                            modPri.setMsg(msg);
                            request.getSession().setAttribute("modPri", modPri);
                            response.sendRedirect("VerificarDisponibilidad.jsp");
                        }
                }else{
                    Object[]filauto={ISBN,Titulo,DocIdent};
                    modPri.setFil(filauto);
                    modPri.setMsg("Seleccione una fecha");
                    request.getSession().setAttribute("modPri", modPri);
                    response.sendRedirect("VerificarDisponibilidad.jsp");
                }
            }
           if(acc.equals("Crear Ficha Prestamo")){
                String ISBN=request.getParameter("ISBN");
                String fRetiro=request.getParameter("fRetiro");
                String fDevolucion=request.getParameter("fDevolucion");
                String DocIdent=request.getParameter("DocIdent");
                String numID=request.getParameter("numID");
                String IDLFP=ope.getAutoCodigoID("LISTA");
                Object[]filauto={IDLFP,numID,ISBN};
                modPri.setFil(filauto);
                String msg=serfp.Registrar(numID,DocIdent, fRetiro, fDevolucion);
                if(msg.equalsIgnoreCase("Operacion exitosa")){
                    Object[]filLibro=serLib.Buscar(ISBN);
                    serLib.Actualizar(filLibro[0].toString(),filLibro[1].toString(),filLibro[2].toString(),Integer.parseInt(filLibro[3].toString())-1);
                    request.getSession().setAttribute("modPri", modPri);
                    response.sendRedirect("RegistrarPrestamo.jsp");//
                }else{
                    Object[] fila={numID,ISBN,fRetiro,fDevolucion,DocIdent};
                            modPri.setFil(fila);
                            modPri.setMsg(msg);
                            request.getSession().setAttribute("modPri", modPri);
                            response.sendRedirect("CrearFichaPrestamo.jsp");
                }

            }
           if(acc.equals("Registrar Prestamo")){
                String IDLFP=request.getParameter("IDLFP");
                String NUMID=request.getParameter("NUMID");
                String ISBN=request.getParameter("ISBN");
                Object[]filauto={IDLFP,NUMID,ISBN,"Activo"};
                modPri.setFil(filauto);
                modPri.setMsg(serLis.RegistrarPrestamo(IDLFP,NUMID, ISBN, "a"));
                request.getSession().setAttribute("modPri", modPri);
                response.sendRedirect("RegistrarPrestamo.jsp");// abrir la ventana  empleado
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
