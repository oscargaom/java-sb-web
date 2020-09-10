package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bolsadeideas.springboot.web.app.models.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// import java.util.Map;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class IndexController {

	private static final String TITULO = "titulo";

	@Value("${texto.indexcontroller.index.titulo}")
	private String tituloIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String tituloPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String tituloListar;

	/*
	 * {"app"} -> Es la ruta de primer nivel del controlador. {"/", "/home",
	 * "/index"} -> Son las rutas de segundo nivel del método handler.
	 * 
	 * @RequestMapping(value= {"/", "/home", "/index"}, method = RequestMethod.GET)
	 * public String index() { return "index"; }
	 * 
	 * @GetMapping({"/", "/home", "/index"}) public String index(Map<String, Object>
	 * map) { map.put("titulo", "Hola Spring Map");
	 * 
	 * return "index"; }
	 * 
	 * @GetMapping({"/","/home","/index"}) public String index(ModelMap modelMap) {
	 * modelMap.addAttribute("titulo", "Hola Spring ModelMap"); return "index"; }
	 * 
	 * @GetMapping({"/","/home","/index"}) public ModelAndView index(ModelAndView
	 * modelAndView) { modelAndView.addObject("titulo", "Hola Spring ModelAndView");
	 * modelAndView.setViewName("index"); return modelAndView; }
	 */

	@GetMapping({ "", "/", "/home", "/index" })
	public String index(Model model) {
		model.addAttribute(TITULO, tituloIndex);
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();

		usuario.setNombre("Federico");
		usuario.setApellido("Aguilar");
		usuario.setEmail("federico@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute(TITULO, tituloPerfil);
		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {

		/*
		 * // Primera forma de envíar un modelo a la vista List<Usuario> usuarios = new
		 * ArrayList<>();
		 * 
		 * usuarios.add(new Usuario("Federico", "Aguilar", "federico@gmail.com"));
		 * usuarios.add(new Usuario("Adelaido", "Miguel", "adelaito@gmail.com"));
		 * usuarios.add(new Usuario("Pimitivo", "Galan", "primitivo@gmail.com"));
		 * 
		 * model.addAttribute("usuarios", usuarios);
		 */

		/*
		 * // Segundo ejemplo de como pasar un modelo a la vista List<Usuario> usuarios
		 * = Arrays.asList(new Usuario("Federico", "Aguilar", "federico@gmail.com"), new
		 * Usuario("Adelaido", "Miguel", "adelaito@gmail.com"), new Usuario("Pimitivo",
		 * "Galan", "primitivo@gmail.com"));
		 * 
		 * model.addAttribute("usuarios", usuarios);
		 */
		model.addAttribute(TITULO, tituloListar);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		return Arrays.asList(new Usuario("Federico", "Aguilar", "federico@gmail.com"),
				new Usuario("Adelaido", "Miguel", "adelaito@gmail.com"),
				new Usuario("Pimitivo", "Galan", "primitivo@gmail.com"));
	}
}
