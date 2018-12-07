
<%@page import="Model.TipoTecnico"%>
<%@page import="java.util.List"%>
<html>
    <head>
    </head>
    <body>
        <h3>Registro de Region</h3>
        <form action="region_save" method="Post">
            <input type="text"  placeholder="Nombre" required="required"  name="nombre"/>  <br><br/>
            <input type="text"  placeholder="codigo" required="required" name="codigo"/>  <br><br/>
        </select> 
        <button type="submit" >Guardar</button>
    </form>
    <form action="Listar_Regiones" method="Post">
        <button type="submit" >Listar Regiones</button>
    </form>

</body>
</html>