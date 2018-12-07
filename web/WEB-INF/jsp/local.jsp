<%-- 
    Document   : local
    Created on : 07-12-2018, 11:31:45
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <section id="contact">
            <div class="container">
                <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="Nombre">Nombre del Local</label>
                            <input type="text" class="form-control" name="nombre" id="Nombre" placeholder="Nombre del Local">
                        </div>
                        
                        <div class="form-group col-md-4">
                            <label for="Comuna">Comuna</label>
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
                        <div class="form-group col-md-6">
                            <label for="Especialidad">Especialidad del Tecnico</label>
                            <select name="select" id="inputState" class="form-control">
                                <option selected>Informatico</option>
                                <option>Electronico</option>
                            </select>
                        </div>

                           <button type="submit" class="btn btn-primary">Guardar</button>
                </form>
            </div>
        </section>
</html>
