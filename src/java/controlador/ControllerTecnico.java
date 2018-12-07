/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import JpaController.ClienteJpaController;
import JpaController.TecnicoJpaController;
import JpaController.TipoTecnicoJpaController;
import Model.Cliente;
import Model.Tecnico;
import Model.TipoTecnico;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class ControllerTecnico {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping("/tecnico")
    public String showCliente(Model model, @ModelAttribute("result") String result) {
        Tecnico tecnico = new Tecnico();
        model.addAttribute("tecnico", tecnico);
        model.addAttribute("result", result);
        return "tecnico";
    }

    @RequestMapping(value = "/tecnico/save", method = RequestMethod.POST)
    public String handleCliente(@ModelAttribute("tecnico") Cliente clienteForm, Model model,
            RedirectAttributes red) {
        red.addFlashAttribute("result", "Se ha registrado Exitosamente!");

        return "redirect:/index";
    }

    @RequestMapping(value = "/ver_tipotecnico", method = RequestMethod.GET)
    public String mostrar(Model model) {
        List<TipoTecnico> tipo = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
        TipoTecnicoJpaController cl = new TipoTecnicoJpaController(emf);

        tipo = cl.findTipoTecnicoEntities();

        model.addAttribute("tipo", tipo);

        return "tecnico";
    }

    /*  @RequestMapping(value = "/tecnico_save", method = RequestMethod.POST)
    public String handleSave(
            @RequestParam("nombre") String nombre,
            @RequestParam("usuario") String usuario,
            @RequestParam("rut") String rut,
            @RequestParam("correo") String correo,
            @RequestParam("telefono") String telefono,
            @RequestParam("contrasenia") String contrasenia,
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
            tec.setEspecialidad(usuario);
            tec.setFechaNacimiento(fechaNacimiento);
            tec.setTelefono(telefono);
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            TecnicoJpaController cl = new TecnicoJpaController(emf);

            cl.create(tec);

            model.addAttribute("cliente", cl);
            return "index";
        }
     */
}
