/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.ComunaJpaController;
import Model.Comuna;
import Model.Region;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControllerComuna {


    @RequestMapping("/comuna")
    public String showComuna(Model model, @ModelAttribute("result") String result) {
        Comuna comuna = new Comuna();
        model.addAttribute("comuna", comuna);
        model.addAttribute("result", result);
        return "comuna";
    }

    @RequestMapping(value = "/comuna/save", method = RequestMethod.POST)
    public String handleComuna(@ModelAttribute("cliente") Comuna comunaForm, Model model,
            RedirectAttributes red) {
        red.addFlashAttribute("result", "Se ha registrado Exitosamente!");

        return "redirect:/index";
    }

    @RequestMapping(value = "/comuna_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("codigo") String codigo,
            @RequestParam("region") Region region,
            Model model) throws Exception {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

            Comuna c = new Comuna();
            c.setCodigo(codigo);
            c.setNombre(nombre);
            c.setRegion(region);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.supertec_Supertec_war_1.0-SNAPSHOTPU");
            ComunaJpaController cl = new ComunaJpaController(emf);

            cl.create(c);

            model.addAttribute("comuna", cl);
            return "index";
        }
    }

    @RequestMapping(value = "/comuna/lista", method = RequestMethod.GET)
    public String showLista() {

        return "listaComuna";
    }
}
