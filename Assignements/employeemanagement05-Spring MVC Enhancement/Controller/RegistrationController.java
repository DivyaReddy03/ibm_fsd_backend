package com.examples.spring.web.mvc.controller;


	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.SessionAttributes;
	import org.springframework.web.bind.support.SessionStatus;
	import org.springframework.web.servlet.ModelAndView;

	import com.examples.spring.web.mvc.exception.LoginException;
	import com.examples.spring.web.mvc.model.Login;
import com.examples.spring.web.mvc.model.User;

	/**
	 * Handles requests for the application login page.
	 */
	@Controller
	@SessionAttributes("userName, password")
	public class RegistrationController {		
		@RequestMapping(value = "/register", method = RequestMethod.GET)	
		public String register(Model model) {
           model.addAttribute("user",new User());
           
			return "register";
		}
		
		@RequestMapping(value="/register", method = RequestMethod.POST)
		public String authenticate(@ModelAttribute @Valid User user, BindingResult result,Model model, HttpSession session) {
			
			if(result.hasErrors())
			{
//				logger.info("Authentication success");
//				session.setAttribute("userName", login.getUserName());
				//model.addAttribute("userName", "admin");
				return "register";
			}
			else
			{
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("password", user.getPassword());
				return "registrationSuccess";
			}
			
		}
		
		
		
		
	}


