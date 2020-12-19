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
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;



@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UsuarioService userService;
	@Autowired
	private RolService roleService;
	@Autowired
	private PersonaSerice personaService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		ModelAndView modelAndView = new ModelAndView();
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
		modelAndView.addObject("users", userService.readAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.addObject("rol", getRol(getUser().getIdrol()));
		modelAndView.addObject("persona", getPersona(getUser().getIdpersona()));
		modelAndView.addObject("usuario", userService.read(getUser().getIdusuario()));
		modelAndView.addObject("control", getRol(getUser().getIdrol()));
		modelAndView.setViewName("user");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/all");
		user.setPassword(userService.read(user.getIdusuario()).getPassword());
		user.setActive(userService.read(user.getIdusuario()).getActive());
		modelAndView.addObject("usuario", userService.read(getUser().getIdusuario()));
		modelAndView.addObject("control", getRol(getUser().getIdrol()));
		modelAndView.addObject("rol", getRol(getUser().getIdrol()));
		modelAndView.addObject("persona", getPersona(getUser().getIdpersona()));
		userService.create(user);
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Usuario());
		modelAndView.addObject("roles", roleService.readAll());
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.addObject("usuario", userService.read(id));
		modelAndView.addObject("rol", getRol(getUser().getIdrol()));
		modelAndView.addObject("persona", getPersona(getUser().getIdpersona()));
		modelAndView.addObject("control", getRol(id).getNomrol());
		modelAndView.setViewName("user");
		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/all");
		modelAndView.addObject("rule", new Usuario());
		modelAndView.addObject("rol", getRol(getUser().getIdrol()));
		modelAndView.addObject("usuario", userService.read(id));
		modelAndView.addObject("persona", getPersona(getUser().getIdpersona()));
		modelAndView.addObject("control", getRol(id).getNomrol());
		userService.delete(id);
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







