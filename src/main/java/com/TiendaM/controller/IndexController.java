package com.TiendaM.controller;

import com.TiendaM.dao.ClienteDao;
import com.TiendaM.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import javax.management.AttributeValueExp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
//        log.info("Ahora desde MVC");
//        model.addAttribute("Mensaje","Hola desde el controlador");
//        
//        Cliente cliente = new Cliente("Daniel", "Rojas Fuentes", "danielrf98@gmail.com", "86741454");
//        model.addAttribute("objetoCliente", cliente);
//        
//        Cliente cliente2 = new Cliente("Juan", "Rojas Fuentes", "danielrf98@gmail.com", "86741454");
//        Cliente cliente3 = new Cliente("Pedro", "Rojas Fuentes", "danielrf98@gmail.com", "86741454");
//        
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);

        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
                
        return "index";
    }
}
