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
        <title>Crear Libro</title>
    </head>
    <body><hr>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>
        <form action="ControlBibliotecario">
            <table border="0">
                <tr>
                    <td> <label>ISBN</label></td>
                    <td> <input disabled="" type="text" size="20" value='<%= mp.getFil()[0] %>'/></td>
                    <td> <input  type="hidden" size="20" name="ISBN" value='<%= mp.getFil()[0] %>'/></td>
                </tr>
                <tr>
                    <td> <label>TITULO</label></td>
                    <td> <input type="text" size="20" name="Titulo" value=""></td>
                </tr>
                <tr>
                    <td> <label>EDITORIAL</label></td>
                    <td> <input type="text" size="20" name="Editorial" value=""></td>
                </tr>
                <tr>
                    <td> <label>STOCK</label></td>
                    <td> <input type="number" size="20" name="Stock" value=""/></td>
                    
                </tr>
                <tr>
                    <td >
                        <input type="submit" name="acc" value="Crear"/>
                    </td>
                    <td >
                        <input type="submit" name="acc" value="Regresar"/>
                    </td>
                </tr>
                
            </table>
        </form>
        <label id="mensaje" ><%= mp.getMsg() %></label>
    </body>
</html>
