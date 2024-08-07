<%-- 
    Document   : GestionLibro
    Created on : 20/10/2023, 11:22:30 AM
    Author     : denilson
--%>

<%@include file="Base.jsp" %>
<%@page import="servicio.ServicioFichaPrestamoImp"%>
<%@page import="servicio.ServicioFichaPrestamo"%>
<%@page import="negocio.Libro"%>
<%@page import="java.util.List"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualiza Libro</title>
    </head>
    <body><hr>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>
        <form action="ControlBibliotecario">
            <table border="0">
                <tr>
                    <td> <label>ISBN</label></td>
                    <td> <input disabled type="text" size="20" value='<%= mp.getFil()[0] %>'/></td>
                    <td> <input type=hidden size="20" name="ISBNEdit" value='<%= mp.getFil()[0] %>'/></td>
                </tr>
                <tr>
                    <td> <label>TITULO</label></td>
                    <td> <input type="text" size="20" name="TituloEdit" value='<%= mp.getFil()[1] %>'/></td>
                </tr>
                <tr>
                    <td> <label>EDITORIAL</label></td>
                    <td> <input type="text" size="20" name="EditorialEdit" value='<%= mp.getFil()[2] %>'/></td>
                </tr>
                <tr>
                    <td> <label>STOCK</label></td>
                    <td> <input type="text" size="20" name="StockEdit" value='<%= mp.getFil()[3] %>'/></td>
                    
                </tr>
                <tr>
                    <td >
                        <input type="submit" name="acc" value="Actualizar">
                    </td>
                    <td >
                        <input type="submit" name="acc" value="Regresar">
                    </td>
                </tr>
                
            </table>
        </form>
        <label id="mensaje" ><%= mp.getMsg() %></label>
    </body>
</html>
