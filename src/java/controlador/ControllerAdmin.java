/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kalbl
 */
@Controller
public class ControllerAdmin {
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String demo(ModelMap map) {
        map.addAttribute("helloAgain", "Hello (Again) Spring from Netbeans!!");
        return "admin";
    }
}
