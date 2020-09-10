package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    static final String TITULO = "titulo";

    @GetMapping("/")
    public String index(Model model){
        
        model.addAttribute(TITULO, "Envíar parámetros de en la ruta (@PathVariable)");
        return "variables/index";
    }
    
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable(name = "texto") String variable, Model model){

        model.addAttribute(TITULO, "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: '".concat(variable).concat("'"));

        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){

        model.addAttribute(TITULO, "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado es: '".concat(texto).concat("' y el número enviado en la ruta es: '").concat(numero.toString()).concat("'"));

        return "variables/ver";
    }

}