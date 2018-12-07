<%-- 
    Document   : solicitud
    Created on : 07-dic-2018, 14:07:53
    Author     : Martin Parra
--%>


<%@page import="Model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Model.Tecnico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h3>Solicitud </h3>
        <form action="solicitud_save" method="Post">
            <input type="text"  placeholder="caracteristicas" required="required"  name="caracteristicas"/>  <br><br/>
            <input type="text"  placeholder="estado" required="required" name="esatdo"/>  <br><br/>
            <div class="row">
                <div class="col-md-5 mb-3">
                   

                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="country">tecnico</label>
                            <%
                                List<Tecnico> tecnico = (List<Tecnico>) request.getAttribute("tecnico");
                            %>

                            <select class="custom-select d-block w-100" id="country" name="tecnico" required>
                                <%
                                    for (Tecnico t : tecnico) {
                                %>
                                <option value="<%out.write(t.getId().toString());%>"><% out.write(t.getNombre());%></option>
                                <%
                                    }
                                %>
                            </select>                      
                            <div class="row">
                                <div class="col-md-5 mb-3">
                                    <label for="country">cliente</label>
                                    <%
                                        List<Cliente> cliente = (List<Cliente>) request.getAttribute("cliente");
                                    %>

                                    <select class="custom-select d-block w-100" id="country" name="cliente" required>
                                        <%
                                            for (Cliente c : cliente) {
                                        %>
                                        <option value="<%out.write(c.getId().toString());%>"><% out.write(c.getNombre());%></option>
                                        <%
                                            }
                                        %>
                                    </select>                              
                                </div> 
                            </div>
                        </div> 
                    </div>   
                </div> 
            </div> 
            <button type="submit" >Guardar</button>
        </form>


    </body>
</html>