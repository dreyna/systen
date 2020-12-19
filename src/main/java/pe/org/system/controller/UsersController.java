package pe.org.system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.org.system.model.Persona;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.AsistenciaService;
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;

@Controller
@RequestMapping("/users/tables")
public class UsersController {
	@Autowired
	private UsuarioService userService;
	@Autowired
	private RolService roleService;
	@Autowired
	private AsistenciaService asistenciaService;
	@Autowired
	private PersonaSerice personaService;
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allUsers(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(id);
		modelAndView.addObject("asistencias", asistenciaService.readAll(id));
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.addObject("rol", getRol(getUser().getIdrol()));
		modelAndView.addObject("persona", getPersona(getUser().getIdpersona()));
		modelAndView.addObject("usuario", userService.read(getUser().getIdusuario()));
		modelAndView.addObject("control", getRol(getUser().getIdrol()));
		modelAndView.setViewName("users");
		return modelAndView;
	}
	private Usuario getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario user = userService.findUserByEmail(auth.getName());
		return user;
	}
	private Rol getRol(int idrol){
		return roleService.read(idrol);
	}
	private Persona getPersona(int idper){
		return personaService.read(idper);
	}
}
