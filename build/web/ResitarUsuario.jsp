<%-- 
    Document   : ResitarUsuario
    Created on : 20/10/2023, 11:07:21 AM
    Author     : denilson
--%>

<%@page import="presentacion.ModeloPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cuenta</title>
    </head>
    <body>
        <h1>Crear Cuenta</h1>
        <% ModeloPrincipal mp=(ModeloPrincipal)session.getAttribute("modPri"); %>
        <form action="ControlCliente">
            <table>
                <tr>
                    <td> <label>DOC IDENT</label></td>
                    <td> <input type="text" size="20" name="docident" value=""/></td>
                </tr>
                <tr>
                    <td> <label>NOMBRE</label></td>
                    <td> <input type="text" size="20" name="nombre" value=""/></td>
                </tr>
                <tr>
                    <td> <label>DIRECCION</label></td>
                    <td> <input type="text" size="20" name="direc" value=""/></td>
                </tr>
                
                <tr>
                    <td> <label>CONTRASEÑA</label></td>
                    <td> <input type="text" size="20" name="pass" value=""/></td>
                </tr>
                <tr >
                    <td colspan="2" >
                        <input type="submit" name="acc" value="Grabar"/>
                        <input type="submit" name="acc" value="Cancelar"/>
                    </td>
                </tr>
            </table>
        </form>
        <label id="mensaje" ><%= mp.getMsg() %></label>
    </body>
</html>
