/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.TecnicoJpaController;
import JpaController.TipoTecnicoJpaController;
import Model.Tecnico;
import Model.TipoTecnico;
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
 * @author yo
 */
@Controller
public class ControllerTecnico {

    @RequestMapping(value = "/tecnico", method = RequestMethod.GET)
    public String showCombo(Model model) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
        List<TipoTecnico> tipotecnico;
        TipoTecnicoJpaController cl = new TipoTecnicoJpaController(emf);
        tipotecnico = cl.findTipoTecnicoEntities();
        model.addAttribute("tipotecnico", tipotecnico);

        return "tecnico";
    }

    @RequestMapping(value = "/tecnico_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("usuario") String usuario,
            @RequestParam("rut") String rut,
            @RequestParam("correo") String correo,
            @RequestParam("telefono") String telefono,
            @RequestParam("contrasenia") String contrasenia,
            @RequestParam("tipo") String tipo,
            @RequestParam("especialidad") TipoTecnico especialidad,
            // @RequestParam("fechaNacimiento") Date fechaNacimiento,
            Model model) throws Exception {

        if (nombre.trim().equals("")) {
            return "error500";
        } else {

            Tecnico tec = new Tecnico();
            tec.setRut(rut);
            tec.setCorreo(correo);
            tec.setNombre(nombre);
            tec.setUsuario(usuario);
            tec.setContrasenia(contrasenia);
            tec.setEspecialidad(especialidad);
            // tec.setFechaNacimiento(fechaNacimiento);
            tec.setTelefono(telefono);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            TecnicoJpaController cl = new TecnicoJpaController(emf);

            cl.create(tec);

            model.addAttribute("cliente", cl);
            return "index";
        }
    }
}
