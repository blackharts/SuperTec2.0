<%-- 
    Document   : local
    Created on : 07-12-2018, 11:31:45
    Author     : acer
--%>


<%@page import="java.util.List"%>
<%@page import="Model.Tecnico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
            <div class="container">
                <form action="local_save" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="Nombre">Nombre del Local</label>
                            <input type="text" class="form-control" name="nombre" id="Nombre" placeholder="Nombre del Local">
                        </div>
                        
                        <div class="form-group col-md-4">
                            <label for="Tecnico">Comuna</label>
                            <select name="comuna" id="Comuna" class="form-control">
                                <option selected>Puerto Montt</option>
                                <option>Ancud</option>
                            </select>
                        </div>
                        
                         <div class="form-group col-md-6">
                            <label for="direccionLocal">Ubicacion</label>
                            <input type="text" class="form-control" name="direccion"id="direccionLocal">
                        </div>
                                 
               </div>
                    <div class="row">
                            <div class="col-md-5 mb-3">
                                <label for="country">Tecnicos</label>
                                <%
                                    List<Tecnico> tec = (List<Tecnico>) request.getAttribute("tecnico");
                                %>

                                <select class="custom-select d-block w-100" id="country" name="tecnicos" required>
                                    <%
                                         for (Tecnico r : tec) {
                                    %>
                                    <option value="<%out.write(r.getId().toString());%>"><% out.write(r.getNombre());%></option>
                                    <%
                                         }
%>
                                </select>
                                <div class="invalid-feedback">
                                    Please select a valid Region
                                </div>
                            </div> 

                        </div>

                           <button type="submit" class="btn btn-primary">Guardar</button>
                </form>
            </div>
       
</html>
