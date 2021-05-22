package net.slipp.web.users;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.slipp.domain.users.User;

@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/users/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "users/form";
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		log.debug("User :{}" ,user);
		if(bindingResult.hasErrors()) {
			log.debug("Binding result has error!" );
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				log.debug("error: {}",error.getDefaultMessage());
			}
		}
		return "users/form";
	}
}
