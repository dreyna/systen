package pe.org.system.controller;

import javax.validation.Valid;

import pe.org.system.model.Rol;
import pe.org.system.model.Persona;
import pe.org.system.model.Usuario;
import pe.org.system.service.ActividadService;
import pe.org.system.service.AsistenciaService;
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService userService;
//UserService us  = new UserService();
	@Autowired
	private RolService roleService;
	
	@Autowired
	private PersonaSerice personaService;

	@Autowired
	private ActividadService actividadService;

	@Autowired
	private AsistenciaService asistenciaService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value={"/index"}, method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Usuario user = new Usuario();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario userExists = userService.findUserByEmail(user.getCorreo());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"Email has already been taken"
							+ " Check your details!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.create(user);
			modelAndView.addObject("successMessage", "Registration Successful.");
			modelAndView.addObject("user", new Usuario());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}


	@RequestMapping(value="/access-denied", method = RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("403");
		return modelAndView;
	}


	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Rol role = new Rol();
		Rol role2 = new Rol();
		role = roleService.findRole("ADMIN");
		role2 = roleService.findRole("USER");
		List<Map<String,Object>> users = new ArrayList<>();
		List<Map<String,Object>> users2 = new ArrayList<>();
		users = userService.findUserbyRole(role);//findUserbyRole
		users2 = userService.findUserbyRole(role2);
		List<Map<String, Object>> actividades = new ArrayList<>();
		actividades = actividadService.readAll();
		int taskCount = actividades.size();
		int adminCount = users.size();
		int userCount = users2.size();
		modelAndView.addObject("adminCount", adminCount);//Authentication for NavBar
		modelAndView.addObject("userCount", userCount);//Authentication for NavBar
		modelAndView.addObject("taskCount", taskCount);//Authentication for NavBar
		//-----------------------------------------
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario loginUser = userService.findUserByEmail(auth.getName());
		Rol rol =roleService.read(loginUser.getIdrol());
		Persona per = personaService.read(loginUser.getIdpersona());
		modelAndView.addObject("control", rol.getNomrol());//Authentication for NavBar
		modelAndView.addObject("rol", rol);
		modelAndView.addObject("user", loginUser);
		modelAndView.addObject("persona", per);
		List<Map<String,Object>> userTasks = new ArrayList<>();
		userTasks = asistenciaService.readAll();
		modelAndView.addObject("userTaskSize", userTasks.size());
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
