package controlador;
import JpaController.ClienteJpaController;
import JpaController.SolicitudJpaController;
import JpaController.TecnicoJpaController;
import Model.Cliente;
import Model.Comuna;
import Model.Region;
import Model.Solicitud;
import static Model.Solicitud_.cliente;
import static Model.Solicitud_.tecnico;
import Model.Tecnico;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerSolicitud {
 
@RequestMapping(value = "/solicitud", method = RequestMethod.GET)
    public String showCombo(Model model) {
        List<Tecnico> te ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
        TecnicoJpaController cl = new TecnicoJpaController(emf);
        te = cl.findTecnicoEntities();
        model.addAttribute("tecnico", te);
        
        
        List<Cliente> clie ;
        ClienteJpaController clien = new ClienteJpaController(emf);
        clie = clien.findClienteEntities();
        model.addAttribute("cliente", clie);
        return "solicitud";
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
            
            

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperTec2.0PU");
            SolicitudJpaController so = new SolicitudJpaController(emf);

            so.create(sol);

            model.addAttribute("solicitud", so);
            return "index";
        }

    }
}