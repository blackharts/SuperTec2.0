/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.ClienteJpaController;
import Model.Cliente;
import Model.Comuna;
import Model.Local;
import Model.Tecnico;
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

public class ControllerLocal {

    @RequestMapping("/local")
    public String showCliente(Model model, @ModelAttribute("result") String result) {
        Local local = new Local();
        model.addAttribute("local", local);
        model.addAttribute("result", result);
        return "local";
    }

    @RequestMapping(value = "/local/save", method = RequestMethod.POST)
    public String handleCliente(@ModelAttribute("local") Local localForm, Model model,
            RedirectAttributes red) {
        red.addFlashAttribute("result", "Se ha registrado de forma correcta!");

        return "redirect:/index";
    }

    @RequestMapping(value = "/local_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("comuna") Comuna comuna,
            @RequestParam("tecnico") Tecnico tecnico,
            @RequestParam("ubicacion") String ubicacion,

            Model model) throws Exception {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

          
            Local loc = new Local();
            loc.setNombre(nombre);
            loc.setUbicacion(ubicacion);
            loc.setTecnico(tecnico);
            loc.setComuna(comuna);
   

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.supertec_Supertec_war_1.0-SNAPSHOTPU");
            ClienteJpaController cl = new ClienteJpaController(emf);

            //loc.create(loc);

            model.addAttribute("local", loc);
            return "index";
        }

    }
}

    
    

