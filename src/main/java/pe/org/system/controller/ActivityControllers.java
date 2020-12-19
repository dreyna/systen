package pe.org.system.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.org.system.model.Actividad;
import pe.org.system.model.Asistencia;
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
@RequestMapping("/activitis")
public class ActivityControllers {
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

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("activitis", activitdadService.readAll());
		modelAndView.addObject("mode", "MODE_LISTAR");
		datos(modelAndView);		
		modelAndView.setViewName("activity");
		return modelAndView;
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addUsers() {

		ModelAndView modelAndView = new ModelAndView();
		datos(modelAndView);
		modelAndView.addObject("mode", "MODE_CREATE");    	
		datos(modelAndView);	
		modelAndView.addObject("actividad", new Actividad());
		modelAndView.setViewName("activity");
		modelAndView.addObject("roles", roleService.readAll());
		modelAndView.addObject("distritos", distritoService.readAll());
		return modelAndView;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNewUser(@Valid Actividad activ, BindingResult bindingResult) {
		activitdadService.create(new Actividad(0, activ.getDescripcion(), activ.getFecha(), activ.getHora(), "1", dptoService.getIdDepto(activ.getIddistrito()),activ.getIddistrito()));
		return "redirect:/activitis/listar";			
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
		modelAndView.addObject("titulo", "ACTIVIDADES");
		
		modelAndView.setViewName("adper");
	}
}
