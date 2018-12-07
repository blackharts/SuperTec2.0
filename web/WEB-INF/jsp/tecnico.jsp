<%@page import="Model.TipoTecnico"%>
<%@page import="java.util.List"%>
<html>
    <head>
    </head>
    <body>
        <h3>Registro de Tecnicos</h3>
        <form action="tecnico_save" method="Post">
            <input type="text"  placeholder="Rut" required="required"  name="Rut"/>  <br><br/>
            <input type="email"  placeholder="Correo Electronico" required="required" name="Correo"/>  <br><br/>
            <input type="text"  placeholder="nombre completo" required="required" name="nombre"/>  <br><br/>
            <input type="text"  placeholder="nombre de usuario" required="required" name="usuario"/>  <br><br/>
            <input type="password"  placeholder="contraseña" required="required" name="contrasenia"/>  <br><br/>
            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="country">Tipo Tecnico</label>
                    <%
                        List<TipoTecnico> tipotecnico = (List<TipoTecnico>) request.getAttribute("tipotecnico");
                    %>

                    <select class="custom-select d-block w-100" id="country" name="especialidad" required>
                        <%
                            for (TipoTecnico t : tipotecnico) {
                        %>
                        <option value="<%out.write(t.getId().toString());%>"><% out.write(t.getEspecialidad());%></option>
                        <%
                            }
                        %>
                    </select>
                    <div class="invalid-feedback">
                        Please select a valid Tipo
                    </div>
                </div> 

            </div>

            <!--<input type="text"  placeholder="Fecha Nacimiento" required="required" name="fecha"/>  <br><br/>-->
            <input type="text"  placeholder="Telefono" required="required" name="Telefeno"/>  <br><br/>
            <button type="submit" >Guardar</button>

        </form>
        <button type="submit" >Listar tecnicos</button>


    </body>
</html>