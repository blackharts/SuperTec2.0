/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.ComunaJpaController;
import Model.Comuna;
import Model.Region;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerComuna {


    @RequestMapping("/comuna")
    public String showComuna() {
        
        return "comuna";
    }

    

    @RequestMapping(value = "/comuna_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("codigo") String codigo,
          //  @RequestParam("region") Region region,
            Model model) throws Exception {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

            Comuna c = new Comuna();
            c.setCodigo(codigo);
            c.setNombre(nombre);
           // c.setRegion(region);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            ComunaJpaController cl = new ComunaJpaController(emf);

            cl.create(c);

            model.addAttribute("comuna", cl);
            return "admin";
        }
    }

    @RequestMapping(value = "/comuna/lista", method = RequestMethod.GET)
    public String showLista() {

        return "listaComuna";
    }
}
