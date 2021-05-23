package net.slipp.web.users;

import java.util.List;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "users/form";
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		log.debug("User :{}" ,user);		
		if(bindingResult.hasErrors()) {
			log.debug("Binding result has error!" );
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				log.debug("error: {}",error.getDefaultMessage());
			}
			return "users/form";
		}
		return "redirect:/";
	}
	
	
	@RequestMapping("/login/form")
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "users/login";
	}
	
	@RequestMapping("/login")
	public String login(@Valid User user, BindingResult bindingResult, HttpSession session, Model model) {
		log.debug("User :{}" ,user);
		if(bindingResult.hasErrors()) {
			return "users/login"; 
		}
		String userId = user.getUserId();
		String userPw = user.getPassword();
		if(userId == null) {
			model.addAttribute("errorMessage", "존재하지 않는 사용자입니다.");
			// 에러 처리 - 존재하지 않는 사용자입니다.
			return "users/login";
			
		}if(!userPw.equals(user.getPassword())){
			// 에러 처리 - 비밀번호가 틀립니다.
			return "users/login";
		}		
		session.setAttribute("userId", user.getUserId());
		// 세션에 사용자 정보 저장.
		return "redirect:/";
	}
}
