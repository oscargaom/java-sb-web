package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Formatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/params")
public class EjemploParamsController {

    private static final String RESULTADO = "resultado";
    private static final String VIEW_VER = "params/ver";
    private static final String VIEW_INDEX = "params/index";

    @GetMapping("/")
    public String index(Model model) {
        return VIEW_INDEX;
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "default") String texto,
            Model model) {

        model.addAttribute(RESULTADO, "El texto envíado es: ".concat(texto));
        return VIEW_VER;
    }

    @GetMapping("/mix-params")
    public String mixparams(@RequestParam String saludo, @RequestParam Integer numero, Model model) {

        StringBuilder sbuf = new StringBuilder();

        try (Formatter fmt = new Formatter(sbuf)) {
            fmt.format("El saludo envíado es '%s' y el número es: '%d'", saludo, numero);

        } catch (Exception e) {
            sbuf.append("");
        }

        model.addAttribute(RESULTADO, sbuf.toString());
        return VIEW_VER;
    }

    @GetMapping("/mix-params2")
    public String mixParams2(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        int numero = -1;

        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException ex) {
            numero = 0;
        }

        String texto = "El saludo envíado es '" + saludo + "' y el número es: '" + numero + "'";

        model.addAttribute(RESULTADO, texto);

        return VIEW_VER;
    }
}