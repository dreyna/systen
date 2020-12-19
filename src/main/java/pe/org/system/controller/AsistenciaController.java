package pe.org.system.controller;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import pe.org.system.model.Actividad;
import pe.org.system.model.Asistencia;
import pe.org.system.model.Persona;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.ActividadService;
import pe.org.system.service.AsistenciaService;
import pe.org.system.service.DepartamentoService;
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {
	@Autowired
	private UsuarioService userService;
	@Autowired
	private RolService roleService;
	@Autowired
	private PersonaSerice personaService;
	@Autowired
	private DepartamentoService dptoService;
	@Autowired
	private ActividadService activitdadService;
	@Autowired
	private AsistenciaService asistenciaService;
	@Autowired
	private Gson gson;

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("asistencias", asistenciaService.readAll());
		modelAndView.addObject("mode", "MODE_LISTAR");
		datos(modelAndView);		
		modelAndView.setViewName("asistencia");
		return modelAndView;
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addUsers() {

		ModelAndView modelAndView = new ModelAndView();
		datos(modelAndView);
		modelAndView.addObject("mode", "MODE_CREATE");    	
		datos(modelAndView);	
		modelAndView.addObject("standardDate", new Date());
		modelAndView.addObject("localDateTime", LocalDateTime.now());
		modelAndView.addObject("localDate", LocalDate.now());
		modelAndView.addObject("timestamp", Instant.now());
		modelAndView.addObject("asistencia", new Asistencia());		
		modelAndView.addObject("actividad", activitdadService.readAll2());
		modelAndView.addObject("dptos", dptoService.readAll());
		modelAndView.setViewName("asistencia");
		return modelAndView;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNewUser(@Valid Asistencia asist, BindingResult bindingResult) {
		int idp = personaService.getId(String.valueOf(asist.getIdusuario()));
		int idd = activitdadService.readDistrito(asist.getIdactividad()).getIddistrito();
		System.out.println(gson.toJson(asist));
		System.out.println(getUser().getIdusuario()+"/"+idp+"/"+idd);
		asistenciaService.create(new Asistencia(0, "", "", asist.getIdactividad(), getUser().getIdusuario(), idd, idp));
		return "redirect:/asistencias/listar";			
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
		modelAndView.addObject("titulo", "ASISTENCIAS");
		
		modelAndView.setViewName("adper");
	}
	private Usuario getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario user = userService.findUserByEmail(auth.getName());
		return user;
	}
}
