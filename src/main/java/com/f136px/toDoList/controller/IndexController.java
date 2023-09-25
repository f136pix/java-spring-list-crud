package com.f136px.toDoList.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f136px.toDoList.service.AuthenticationService;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("nome")
public class IndexController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private Logger logger= LoggerFactory.getLogger(getClass());

	// GET /login
	@GetMapping("/")
	public ModelAndView goToIndexPage(ModelMap model) {
		model.put("nome", authenticationService.getLoggedUsername());
		return new ModelAndView("redirect:/afazeres");
	}


}
