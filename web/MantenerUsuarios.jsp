<%@include file="Base.jsp" %>
<%@page import="presentacion.ModeloPrincipal"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mantener Usuario</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 35%;
  align-content: center;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>
</head>
<body><hr>

<label id="mensaje" >${msgMantenerUser}</label><br>
<!-- Trigger/Open The Modal -->
<button id="myBtn">Nuevo Registro</button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
        <form action="ControlBibliotecario">
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
                    <td> <label>CONTRASE�A</label></td>
                    <td> <input type="text" size="20" name="pass" value=""/></td>
                </tr>
                <tr>
                    <td><label>PERFIL</label></td><td>
                        <select name="perfil">
                            <option value="B">Bibliotecario</option>
                            <option value="c">Cliente</option>
                        </select>
                    </td>
                </tr>
                <tr >
                    <td colspan="2" >
                        <input type="submit" name="acc" value="Grabar"/>
                        <input type="submit" name="acc" value="Cancelar"/>
                    </td>
                </tr>
            </table>
        </form>
        
  </div>

</div>

<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>


</body>
</html>

