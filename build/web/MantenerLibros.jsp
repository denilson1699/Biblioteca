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
        <style>@import"Estilos.css";</style>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>           
        <title>Mantener Libros</title>
    <body><hr>
            <% List lista =(List) mp.getLis(); %>
            <table border="0">
                <tr>
            <form action="ControlBibliotecario">
                    <td> <input type="search" size="20" name="nombre" value=""/></td>
                    <td> <input type="submit" name="acc" value="Buscar"/></td>
                    <td> <input type="submit" name="acc" value="Nuevo"/></td>
            </form>
                </tr>
                <tr>
                    <td> <label>ISBN</label></td>
                    <td> <label>TITULO</label></td>
                    <td> <label>EDITORIAL</label></td>
                    <td> <label>STOCK</label></td>
                    <td> <label>ACCION</label></td>
                </tr>
                <% if(lista!=null){ %>
                    <% for(int i=0;i<lista.size();i++){ %>
                    <% Libro libLista=(Libro) lista.get(i); %>
                <tr>
                <form action="ControlBibliotecario">
                    <td> <input readonly type="text" size="20" value='<%= libLista.getISBN() %>'/></td>
                    <td> <input readonly type="text" size="20" value='<%= libLista.getTitulo() %>' /></td>
                    <td> <input readonly size="20" value='<%= libLista.getEditorial() %>' /></td>
                    <td> <input readonly size="20" value='<%= libLista.getStock() %>'/></td>
                    <td colspan="2" >
                        <a href="ControlBibliotecario?acc=Editar&ISBNList=<%= libLista.getISBN() %>">Editar</a>
                        <a href="ControlBibliotecario?acc=Eliminar&ISBNList=<%= libLista.getISBN() %>" onclick="javascript:if(!confirm('Desea Eliminar'))return false">Eliminar</a>
                    </td>
                </form>
                </tr>
                <% } %>
                <% }else{ %> 
                   <label id="mensaje" >NO hay Elementos</label>
                <% } %>
                
            </table>
    </body>
</html>
