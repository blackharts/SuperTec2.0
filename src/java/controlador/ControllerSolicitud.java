/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.SolicitudJpaController;
import Model.Cliente;
import Model.Solicitud;
import Model.Tecnico;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Martin Parra
 */
public class ControllerSolicitud {
    @RequestMapping("/cliente")
    public String showCliente(Model model, @ModelAttribute("result") String result) {
        Solicitud solicitud = new Solicitud();
        model.addAttribute("solicitud", solicitud);
        model.addAttribute("result", result);
        return "solicitud";
    }

    @RequestMapping(value = "/solicitud/save", method = RequestMethod.POST)
    public String handleCliente(@ModelAttribute("solicitud") Solicitud clienteForm, Model model,
            RedirectAttributes red) {
        red.addFlashAttribute("result", "!");

        return "redirect:/index";
    }

    @RequestMapping(value = "/solicitud_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("caracteristicas") String caracteristicas,
            @RequestParam("estado") String estado,
            @RequestParam("cliente") Cliente cliente,
            @RequestParam("tecnico") Tecnico tecnico,
            
            Model model) throws Exception {

        if (caracteristicas.trim().equals("")) {
            return "error500";
        } else {

          
            Solicitud sol = new Solicitud();
            
            sol.setCaracteristicas(caracteristicas);
            sol.setEstado(estado);
            sol.setCliente(cliente);
            sol.setTecnico(tecnico);
            
            

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.supertec_Supertec_war_1.0-SNAPSHOTPU");
            SolicitudJpaController so = new SolicitudJpaController(emf);

            so.create(sol);

            model.addAttribute("solicitud", so);
            return "index";
        }

    }
}





