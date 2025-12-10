/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package com.Tienda.controller;

import com.Tienda.Tienda.domain.Categoria;
import com.Tienda.Tienda.service.CategoriaService;
import com.Tienda.Tienda.service.ProductoService;
import com.Tienda.Tienda.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    
@Autowired
    private CategoriaService categoriaService;

@Autowired
private ProductoService productoService;


   @GetMapping("/listado")
public String listado(Model model) {
    var productos = productoService.getProductos(false);
    var categorias = categoriaService.getCategorias(false);
    model.addAttribute("productos", productos);
    model.addAttribute("categorias", categorias);
    model.addAttribute("precioInf", 0);
    model.addAttribute("precioSup", 0);
    model.addAttribute("existenciasInf", 0);
    model.addAttribute("existenciasSup", 0);
    return "/pruebas/listado";

    }

@GetMapping("/listado/{idCategoria}")
public String listado(Model model, @PathVariable Integer idCategoria) {
    Categoria categoria = new Categoria();
    categoria.setIdCategoria(idCategoria);

    var productos = categoriaService.getCategoria(categoria).getProductos();
    var categorias = categoriaService.getCategorias(false);

    model.addAttribute("productos", productos);
    model.addAttribute("categorias", categorias);
    model.addAttribute("precioInf", 0);
    model.addAttribute("precioSup", 0);
    model.addAttribute("existenciasInf", 0);
    model.addAttribute("existenciasSup", 0);
    return "/pruebas/listado";

}
@PostMapping("/query1")
public String consultaQuery1(@RequestParam(value = "precioInf") double precioInf,
        @RequestParam(value = "precioSup") double precioSup, Model model) {

    List<Producto> productos = productoService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    List<Categoria> categorias = categoriaService.getCategorias(false);

    model.addAttribute("productos", productos);
    model.addAttribute("categorias", categorias);
    model.addAttribute("precioInf", precioInf);
    model.addAttribute("precioSup", precioSup);
    model.addAttribute("existenciasInf", 0);
    model.addAttribute("existenciasSup", 0);

    return "/pruebas/listado";
}


    @PostMapping("/query2")
    public String consultaQuery2(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {
        var productos = productoService.metodoJPQL(precioInf, precioSup);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        model.addAttribute("existenciasInf", 0);
        model.addAttribute("existenciasSup", 0);
        return "/pruebas/listado";
    }

    @PostMapping("/query3")
    public String consultaQuery3(@RequestParam(value = "existenciasInf") int existenciasInf,
            @RequestParam(value = "existenciasSup") int existenciasSup, Model model) {
        var productos = productoService.consultaAmpliadaExistencias(existenciasInf, existenciasSup);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("precioInf", 0);
        model.addAttribute("precioSup", 0);
        model.addAttribute("existenciasInf", existenciasInf);
        model.addAttribute("existenciasSup", existenciasSup);
        return "/pruebas/listado";
    }
}