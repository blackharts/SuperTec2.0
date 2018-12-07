/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.LocalJpaController;
import JpaController.TecnicoJpaController;
import Model.Comuna;
import Model.Local;
import Model.Tecnico;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 *
 *
 * @author acer
 */
@Controller
public class ControllerLocal {

    @RequestMapping(value = "/local", method = RequestMethod.GET)
    public String showCombo(Model model) {
        List<Tecnico> tecnico;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
        TecnicoJpaController cl = new TecnicoJpaController(emf);

        tecnico = cl.findTecnicoEntities();

        model.addAttribute("tecnico", tecnico);

        return "local";
    }

    @RequestMapping(value = "/local_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("comuna") Comuna comuna,
            @RequestParam("tecnicos") Tecnico tecnico,
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

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            LocalJpaController l = new LocalJpaController(emf);

            l.create(loc);

            model.addAttribute("local", l);
            return "admin";
        }

    }
}
