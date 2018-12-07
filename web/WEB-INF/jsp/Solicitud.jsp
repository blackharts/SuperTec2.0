<%-- 
    Document   : Solicitud
    Created on : 07-dic-2018, 12:34:24
    Author     : Martin Parra
--%>

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
                                <label for="country">tecnico</label>
                                

                                <select class="custom-select d-block w-100" id="country" required>
                                   
                                    <option value="<%// out.write(r.getId().toString());%>"><%// out.write(r.getNombre());%></option>
                                    <%
                                         // }
%>
                                </select>
                                
                            </div> 
                                
                                <div class="col-md-5 mb-3">
                                <label for="country">cliente</label>
                                

                                <select class="custom-select d-block w-100" id="country" required>
                                   
                                    <option value="<%// out.write(r.getId().toString());%>"><%// out.write(r.getNombre());%></option>
                                    <%
                                         // }
%>
                                </select>
                                
                            </div> 

                        </div> 
        <button type="submit" >Guardar</button>
    </form>
    

</body>
</html>