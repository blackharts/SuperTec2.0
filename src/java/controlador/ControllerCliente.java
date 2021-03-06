/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.ClienteJpaController;
import Model.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerCliente {

    @RequestMapping("/cliente")
    public String showCliente() {
       
        return "cliente";
    }

  

    @RequestMapping(value = "/cliente_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("usuario") String usuario,
            @RequestParam("rut") String rut,
            @RequestParam("correo") String correo,
            @RequestParam("telefono") String telefono,
            @RequestParam("contrasenia") String contrasenia,
            //@RequestParam("fechaNacimiento") Date fechaNacimiento,
            Model model) throws Exception {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

          
            Cliente cli = new Cliente();
            cli.setNombre(nombre);
            cli.setRut(rut);
            cli.setUsuario(usuario);
            cli.setCorreo(correo);
            cli.setContrasenia(contrasenia);
            //cli.setFechaNacimiento(fechaNacimiento);
            cli.setTelefono(telefono);

              EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            ClienteJpaController cl = new ClienteJpaController(emf);

            cl.create(cli);

            model.addAttribute("cliente", cl);
            return "admin";
        }

    }
}
