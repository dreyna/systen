package pe.org.system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.org.system.model.Persona;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.ActividadService;
import pe.org.system.service.PersonaSerice;
import pe.org.system.service.RolService;
import pe.org.system.service.UsuarioService;

@Controller
@RequestMapping("/myprofile")
public class UserPageController {

	@Autowired
	private UsuarioService userService;
//UserService us  = new UserService();
	@Autowired
	private RolService roleService;
	
	@Autowired
	private PersonaSerice personaService;
	
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@RequestMapping(value = "/inf", method = RequestMethod.GET)
	public ModelAndView showProfile() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Usuario());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario user = userService.findUserByEmail(auth.getName());
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
		modelAndView.addObject("user", userService.read(user.getIdusuario()));
		modelAndView.addObject("mode", "MODE_INF");
		Usuario control = userService.findUserByEmail(auth.getName());
		Rol rol =roleService.read(control.getIdrol());
		Persona per = personaService.read(control.getIdpersona());
		modelAndView.addObject("persona", per);
		modelAndView.addObject("user", user);
		modelAndView.addObject("rol", rol);//Authentication for NavBar
		modelAndView.setViewName("user_profile");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProfile(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/myprofile/inf");
		user.setPassword(userService.read(user.getIdusuario()).getPassword());
		user.setIdrol(userService.read(user.getIdusuario()).getIdrol());
		user.setActive(userService.read(user.getIdusuario()).getActive());
		user.setCorreo(userService.read(user.getIdusuario()).getCorreo());
		user.setIdpersona(userService.read(user.getIdusuario()).getIdpersona());
		userService.create(user);
		modelAndView.addObject("user", getUser());
		Rol rol = roleService.read(getUser().getIdrol());
		modelAndView.addObject("rol", rol);
		modelAndView.addObject("persona", getPersona(getUser().getIdpersona()));
		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView updateProfile(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Usuario());
		modelAndView.addObject("user", userService.read(id));
		modelAndView.addObject("mode", "MODE_EDIT");
		modelAndView.addObject("persona", getPersona(userService.read(id).getIdpersona()));
		modelAndView.addObject("rol", getRol(userService.read(id).getIdrol()));
		modelAndView.setViewName("user_profile");
		return modelAndView;
	}


	@RequestMapping(value = "/mytasks", method = RequestMethod.GET)
	public ModelAndView showMyTask(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Usuario());
		modelAndView.addObject("user", userService.read(id));
		//modelAndView.addObject("usertasks", userTaskService.findByUser(userService.findUser(id)));
		modelAndView.addObject("mode", "MODE_TASKS");
		modelAndView.addObject("persona", getPersona(userService.read(id).getIdpersona()));
		modelAndView.addObject("rol", getRol(userService.read(id).getIdrol()));
		modelAndView.setViewName("user_profile");
		return modelAndView;
	}


	//--------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/savepass_change", method = RequestMethod.POST)
	public ModelAndView confirmPasswordChange(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();		
		String oldPassword = userService.read(user.getIdusuario()).getPassword();
		String postOldPassword =user.getPassword(); 
		System.out.println(oldPassword + " ---- " +postOldPassword+"  ----- "+ user.getPassword()) ;
		if(passwordEncoder.matches(postOldPassword, oldPassword)){
			user.setCorreo(userService.read(user.getIdusuario()).getCorreo());
			user.setActive(userService.read(user.getIdusuario()).getActive());
			user.setIdpersona(userService.read(user.getIdusuario()).getIdpersona());
			user.setIdrol(userService.read(user.getIdusuario()).getIdrol());
			user.setIdusuario(userService.read(user.getIdusuario()).getIdusuario());
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userService.create(user);
			modelAndView.addObject("user", userService.read(user.getIdusuario()));
			modelAndView.addObject("mode", "MODE_PASS");
			modelAndView.addObject("persona", getPersona(user.getIdpersona()));
			modelAndView.addObject("rol", getRol(user.getIdrol()));
			modelAndView.addObject("rule", new Usuario());
			modelAndView.addObject("process", "SUCCESS");
			modelAndView.addObject("pw_success", "Well done! You successfully change your password.");
			modelAndView.setViewName("user_profile");
		}
		else {
			
			modelAndView.addObject("user", userService.read(user.getIdusuario()));
			modelAndView.addObject("mode", "MODE_PASS");
			modelAndView.addObject("user", getUser());
			modelAndView.addObject("persona", getUser().getIdpersona());
			modelAndView.addObject("rol", getRol(user.getIdrol()));
			modelAndView.addObject("process", "ERROR");
			modelAndView.addObject("pw_error", "Error : Check your old password!");
			modelAndView.addObject("rule", new Usuario());
			modelAndView.setViewName("user_profile");
			
		}

		return modelAndView;
	}

	@RequestMapping(value = "/change_password", method = RequestMethod.GET)
	public ModelAndView changePassword(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Usuario());
		Usuario user = userService.read(id);
		modelAndView.addObject("user", user);
		modelAndView.addObject("mode", "MODE_PASS");
		modelAndView.addObject("rol", getRol(user.getIdrol()));
		modelAndView.addObject("persona", getPersona(user.getIdpersona()));
		modelAndView.setViewName("user_profile");
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