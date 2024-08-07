<%-- 
    Document   : RegistrarPrestamo
    Created on : 01/11/2023, 11:15:27 PM
    Author     : denilson
--%>

<%@page import="negocio.Libro"%>
<%@page import="negocio.FichaPrestamo"%>
<%@page import="negocio.Lista"%>
<%@page import="servicio.ServicioLibroImp"%>
<%@page import="servicio.ServicioLibro"%>
<%@page import="servicio.ServicioFichaPrestamoImp"%>
<%@page import="servicio.ServicioFichaPrestamo"%>
<%@page import="servicio.ServicioListaImp"%>
<%@page import="servicio.ServicioLista"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar Datos</h1>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>
        <% ServicioFichaPrestamo serfp= new ServicioFichaPrestamoImp();
           ServicioLibro serLib= new ServicioLibroImp();
           FichaPrestamo fp= serfp.Buscar(mp.getFil()[1].toString());           
           Object lib[]=serLib.Buscar(mp.getFil()[2].toString());
        %>
        <label id="mensaje" ><%= mp.getMsg() %></label>
        <form action="ControlCliente">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID LFP</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <input readonly type="text" size="20" name="IDLFP" value='<%= mp.getFil()[0] %>'/></td>
                        <td> <input readonly type="text" size="20" name="ESTADO" value="Activo"/></td>
                    </tr>
                </tbody>
            </table><br>

            <table border="2">
                <thead>
                    <tr>
                        <th>FICHA PRESTAMO</th>
                        <th>LIBRO</th>
                        <th>CLIENTE</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <input readonly type="text" size="20" name="NUMID" value='<%= fp.getNumID() %>'/></td>
                        <td> <input readonly type="text" size="20" name="ISBN" value='<%= lib[0].toString() %>'/></td>
                        <td> <input readonly type="text" size="20" name="ISBN" value='<%= fp.getDocldent().getDocIdent() %>'/></td>
                    </tr>
                    <tr>
                        <td><strong>F.Retiro:&nbsp</strong><label><%= fp.getFechaRetiro() %></label><br>
                            <strong>F.Devolucion:&nbsp</strong><label><%= fp.getFechaDevolucion() %></label><br>
                        </td>
                        <td><strong>Titulo:&nbsp</strong><label><%= lib[1].toString() %></label><br>
                            <strong>Editorial:&nbsp</strong><label><%= lib[2].toString() %></label><br>
                        </td>
                        <td><strong>Nombre:&nbsp</strong><label><%= fp.getDocldent().getNombre() %></label><br>
                            <strong>Direccion:&nbsp</strong><label><%= fp.getDocldent().getDireccion() %></label><br>
                        </td>
                    </tr>
                    <tr>
                    <td> <input type="submit" name="acc" value="Registrar Prestamo"/></td>
                    <td> <input type="submit" name="acc" value="Regresar"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
