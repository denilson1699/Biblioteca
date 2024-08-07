<%-- 
    Document   : CrearFichaPrestamo
    Created on : 01/11/2023, 10:48:49 PM
    Author     : denilson
--%>

<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Ficha De Prestamo</h1>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>
        <label id="mensaje" ><%= mp.getMsg() %></label>
        <form action="ControlCliente">
            
            <table border="2">
                <thead>
                    <tr>
                        <th>Num ID</th>
                        <th>ISBN</th>
                        <th>Fecha Retiro</th>
                        <th>Fecha Devolución</th>
                        <th>Doct Identidad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <input readonly type="text" size="20" name="numID" value='<%= mp.getFil()[0] %>'/></td>
                        <td> <input readonly type="text" size="20" name="ISBN" value='<%= mp.getFil()[1] %>'/></td>
                        <td> <input readonly type="text" size="20" name="fRetiro" value='<%= mp.getFil()[2] %>'/></td>
                        <td> <input readonly type="text" size="20" name="fDevolucion" value='<%= mp.getFil()[3] %>'/></td>
                        <td> <input readonly type="text" size="20" name="DocIdent" value='<%= mp.getFil()[4] %>'/></td>
                    </tr>
                    <tr>
                    <td> <input type="submit" name="acc" value="Crear Ficha Prestamo"/></td>
                    <td> <input type="submit" name="acc" value="Regresar"/></td>
                    </tr>
                </tbody>
            </table>
                    
        <% mp.setFil(mp.getFil()); %>
        </form>
    </body>
</html>
