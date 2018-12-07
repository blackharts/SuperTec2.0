<%@page import="Model.TipoTecnico"%>
<%@page import="java.util.List"%>
<html>
    <head>
    </head>
    <body>
        <h3>Registro de Tecnicos</h3>
        <form action="tecnico_save" method="Post">
            <input type="text"  placeholder="Rut" required="required"  name="Rut"/>  <br><br/>
            <input type="text"  placeholder="Correo Electronico" required="required" name="Correo"/>  <br><br/>
            <input type="text"  placeholder="nombre completo" required="required" name="nombre"/>  <br><br/>
            <input type="text"  placeholder="nombre de usuario" required="required" name="usuario"/>  <br><br/>
            <input type="text"  placeholder="contraseña" required="required" name="Contrasenia"/>  <br><br/>
            <%--
                List<TipoTecnico> lista = (List<TipoTecnico>) request.getAttribute("tipo");
            <select id="tecnico" name="tipo">
                <%
                    for (TipoTecnico buscar : lista) {
                %>
                <option value="<% out.write(buscar.getId().toString());%>"><% out.write(buscar.getEspecialidad());%></option>
                <%
                    }
                %>
            </select> 
            --%>
            <input type="text"  placeholder="Fecha Nacimiento" required="required" name="fecha"/>  <br><br/>
            <input type="text"  placeholder="Telefono" required="required" name="Telefeno"/>  <br><br/>
            <button type="submit" >Guardar</button>

        </form>
        <button type="submit" >Listar tecnicos</button>


    </body>
</html>