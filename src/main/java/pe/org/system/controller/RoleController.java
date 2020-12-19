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

import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;


@Controller
@RequestMapping("/admin/roles")
public class RoleController {
	@Autowired
	private UsuarioService userService;
//UserService us  = new UserService();
	@Autowired
	private RolService roleService;

	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView newRole(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("role", new Rol());
		modelAndView.addObject("roles", roleService.readAll());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getRol().getNomrol());
		modelAndView.addObject("mode", "MODE_NEW");
		modelAndView.setViewName("role");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRole(@Valid Rol role, BindingResult bindingResult) {
		roleService.create(role);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/roles/all");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getRol().getNomrol());
		return modelAndView;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allRoles() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Rol());
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
		modelAndView.addObject("roles", roleService.readAll());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getRol().getNomrol());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("role");
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateRole(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("personel_type", new Rol());
		modelAndView.addObject("role", roleService.read(id));
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getRol().getNomrol());
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("role");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteRole(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/roles/all");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getRol().getNomrol());
		roleService.delete(id);
		return modelAndView;
	}

	private Usuario getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario user = userService.findUserByEmail(auth.getName());
		return user;
	}
	private Rol getRol(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Rol rol = roleService.obtenerRole(auth.getName());
		return rol;
	}
}
