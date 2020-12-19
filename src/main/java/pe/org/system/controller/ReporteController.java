package pe.org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.org.system.model.Actividad;
import pe.org.system.model.Persona;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.ActividadService;
import pe.org.system.service.DepartamentoService;
import pe.org.system.service.DistritoService;
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	@Autowired
	private UsuarioService userService;
	@Autowired
	private RolService roleService;
	@Autowired
	private PersonaSerice personaService;
	@Autowired
	private DepartamentoService dptoService;
	@Autowired
	private DistritoService distritoService;
	@Autowired
	private ActividadService activitdadService;
	@RequestMapping(value="/actividades", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("datos", activitdadService.readAll3());
		modelAndView.addObject("mode", "MODE_LISTAR");
		datos(modelAndView);		
		modelAndView.setViewName("reportes");
		return modelAndView;
	}
	private void datos(ModelAndView modelAndView) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario loginUser = userService.findUserByEmail(auth.getName());
		Rol rol =roleService.read(loginUser.getIdrol());
		Persona per = personaService.read(loginUser.getIdpersona());
		Actividad actividad = new Actividad();
		modelAndView.addObject("actividad", actividad);
		modelAndView.addObject("control", rol.getNomrol());
		modelAndView.addObject("rol", rol);
		modelAndView.addObject("user", loginUser);
		modelAndView.addObject("persona", per);		
		modelAndView.addObject("titulo", "REPORTES / ACTIVIDADES");
		
		modelAndView.setViewName("adper");
	}
}
