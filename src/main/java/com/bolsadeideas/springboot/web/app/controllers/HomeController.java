package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        /*
         * Con redirect: se pierden los datos del request y normalemte se utiliza cuando
         * se redirecciona a otra página externa como podría ser google.
         */
        // return "redirect:https://www.google.com";
        // return "redirect:/app/index";
        /*
         * Con forward NO se pierden los datos del request y es utilizada cuando se
         * redirecciona a nuestros controllers, de tal forma que no podríamos usarla 
         * para hacer la solicitud a la página de google.
         */
        return "forward:/app/index";
    }
}