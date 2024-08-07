<%-- 
    Document   : VerificarDisponibilidad
    Created on : 01/11/2023, 09:43:36 PM
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
        <h1>Verificar Disponibilidad</h1>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>
        <label id="mensaje" ><%= mp.getMsg() %></label>
        
        <form action="ControlCliente">
            
            <table border="2">
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>TITULO</th>
                        <th>DNI</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <input readonly type="text" size="20" name="ISBN" value='<%= mp.getFil()[0] %>'/></td>
                        <td> <input readonly type="text" size="20" name="Titulo" value='<%= mp.getFil()[1] %>'/></td>
                        <td> <input readonly type="text" size="20" name="DocIdent" value='<%= mp.getFil()[4] %>'/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        <table >
            <thead>
                <tr>
                    <th>Fecha Registro</th>
                    <th>Fecha Devolución</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="date" name="fRetiro"/></td>
                    <td><input type="date" name="fDevolucion"/></td>
                </tr>
                <tr>
                    <td> <input type="submit" name="acc" value="Verificar Disponibilidad"/></td>
                    <td> <input type="submit" name="acc" value="Regresar"/></td>
                </tr>
            </tbody>
        </table>
        </form>
                    

    </body>
</html>
