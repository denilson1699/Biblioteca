<%-- 
    Document   : BuscarLibro
    Created on : 01/11/2023, 09:22:43 PM
    Author     : denilson
--%>

<%@page import="negocio.Libro"%>
<%@page import="java.util.List"%>
<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscar Libro</h1>
        <% ModeloPrincipal mp= (ModeloPrincipal)session.getAttribute("modPri"); %>           
        <% List lista =(List) mp.getLis(); %>
        
        <label id="mensaje" ><%= mp.getMsg() %></label>
            <table border="0">
                <tr>
            <form action="ControlCliente">
                    <td> <input type="search" size="20" name="nombre" value=""/></td>
                    <td> <input type="submit" name="acc" value="Buscar"/></td>
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
                    <td> <input readonly type="text" size="20" name="ISBN" value='<%= libLista.getISBN() %>'/></td>
                    <td> <input readonly type="text" size="20" name="Titulo" value='<%= libLista.getTitulo() %>' /></td>
                    <td> <input readonly type="text" size="20" name="Editorial" value='<%= libLista.getEditorial() %>' /></td>
                    <td> <input readonly type="text" size="20" name="Stock" value='<%= libLista.getStock() %>'/></td>
                    <td colspan="2" >
                        <a href="ControlCliente?acc=SolicitarPrestamo&ISBN=<%= libLista.getISBN() %>&DNIusuario=${DNI}">Solicitar Prestamo</a>
                    </td>
                </tr>
                <% } %>
                <% }else{ %> 
                   <label id="mensaje" >NO hay Elementos</label>
                <% } %>
                
            </table>
    </body>
</html>
