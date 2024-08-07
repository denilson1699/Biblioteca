<%-- 
    Document   : index
    Created on : 04/11/2023, 04:26:21 PM
    Author     : denilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="libro.ico" />
        <title>Login</title>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Binvenido Login</h1>
        <form action="ControlUsuario">
            <table>
                <tr>
                    <td> <label>USUARIO</label></td>
                    <td> <input type="text" size="20" name="docIdent" value=""/></td>
                </tr>
                <tr>
                    <td> <label>CONTRASEÑA</label></td>
                    <td> <input type="password" size="20" name="pass" value=""/></td>
                </tr>
                <tr >
        <label id="mensaje" >${msg}</label>
                    <td colspan="2" >
                        <input type="submit" name="acc" value="Registrar"/>
                        <input type="submit" name="acc" value="Ingresar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
