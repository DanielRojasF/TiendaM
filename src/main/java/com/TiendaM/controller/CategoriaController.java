package com.TiendaM.controller;

import com.TiendaM.domain.Categoria;
import com.TiendaM.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Slf4j
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {   
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nueva")
    public String nuevoCategoria(Categoria categoria){
        return "/categoria/modifica";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
}
