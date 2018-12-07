/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.ClienteJpaController;
import JpaController.RegionJpaController;
import Model.Comuna;
import Model.Region;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author yo
 */
@Controller
public class ControllerRegion {

    @RequestMapping("/region")
    public String showRegion(Model model, @ModelAttribute("result") String result) {
        Region region = new Region();
        model.addAttribute("region", region);
        model.addAttribute("result", result);
        return "region";
    }

    @RequestMapping(value = "/region/save", method = RequestMethod.POST)
    public String regionRegion(@ModelAttribute("region") Region regionForm, Model model,
            RedirectAttributes red) {
        red.addFlashAttribute("result", "Se ha registrado Exitosamente!");

        return "redirect:/index";
    }

    @RequestMapping(value = "/region_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("codigo") String codigo,
            Model model) throws Exception {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

            Region cli = new Region();
            cli.setNombre(nombre);
            cli.setCodigo(codigo);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            RegionJpaController cl = new RegionJpaController(emf);

            cl.create(cli);
            model.addAttribute("region", cl);
            return "index";
        }

    }
    @RequestMapping
    public String defaultView(ModelMap model) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
        RegionJpaController mostrar = new RegionJpaController(emf);
        List<Region> listaPersonas = mostrar.findRegionEntities();
        model.addAttribute("listaPersonas", listaPersonas);
        return "listado_personas";
    }
}
