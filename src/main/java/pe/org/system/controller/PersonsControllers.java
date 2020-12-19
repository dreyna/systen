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

import com.google.gson.Gson;

import pe.org.system.model.Datos;
import pe.org.system.model.Departamento;
import pe.org.system.model.Persona;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.DepartamentoService;
import pe.org.system.service.DistritoService;
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;

@Controller
@RequestMapping("/persons")
public class PersonsControllers {
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
	private Gson gson;

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mode", "MODE_LISTAR");
		datos(modelAndView);		
		return modelAndView;
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addUsers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mode", "MODE_CREATE");    	
		datos(modelAndView);	
		modelAndView.addObject("roles", roleService.readAll());
		modelAndView.addObject("dptos", dptoService.readAll());
		modelAndView.addObject("distritos", distritoService.readAll());
		return modelAndView;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNewUser(@Valid Datos user, BindingResult bindingResult) {
		int iddep = dptoService.getIdDepto(user.getIddistrito());
		Usuario userExists = userService.findUserByEmail(user.getCorreo());
		if (userExists != null) {
			bindingResult
					.rejectValue("correo", "error.user",
							"Email has already been taken"
							+ " Check your details!");
		}
		if (bindingResult.hasErrors()) {
			return "redirect:/persons/add";
		} else {
			int idp = personaService.create(new Persona(0, 
					user.getDni(), user.getNombres().toUpperCase(), user.getApellidos().toUpperCase(), user.getEdad(), 
					user.getSexo(), user.getTelefono(), user.getCestudios().toUpperCase(), user.getPeriodo1()+"-"+user.getPeriodo2(), 
					user.getCarrera().toUpperCase(), iddep,user.getIddistrito()));
			userService.create(new Usuario(0, user.getCorreo(), user.getPassword(), 1, idp, user.getIdrol()));	
			return "redirect:/persons/listar";			
		}
	}
	private void datos(ModelAndView modelAndView) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario loginUser = userService.findUserByEmail(auth.getName());
		Rol rol =roleService.read(loginUser.getIdrol());
		Persona per = personaService.read(loginUser.getIdpersona());
		Datos datitos = new Datos();
		modelAndView.addObject("datos", datitos);
		modelAndView.addObject("control", rol.getNomrol());
		modelAndView.addObject("rol", rol);
		modelAndView.addObject("user", loginUser);
		modelAndView.addObject("persona", per);		
		modelAndView.addObject("titulo", "Usuarios");
		modelAndView.addObject("users", userService.readAll());
		modelAndView.setViewName("adper");
	}
}
