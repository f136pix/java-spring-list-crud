package com.f136px.toDoList.controller;

import java.time.LocalDate;
import java.util.List;

import com.f136px.toDoList.repository.AfazerRepository;
import com.f136px.toDoList.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f136px.toDoList.model.Afazer;

@Controller
@SessionAttributes("nome")
public class AfazerController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AfazerRepository afazerRepository;


	@GetMapping("/afazeres")
	public String listarAfazeres(ModelMap model) {
		String username = authenticationService.getLoggedUsername();
		List<Afazer> afazeres = afazerRepository.findByUsername(username);
		model.put("afazeres", afazeres);   // inserindo os afazeres salvos no view
		
		return "afazeres";
	}
	
	@GetMapping("/adicionar-afazer")
	public String novoAfazerPage(ModelMap model) {
		String username = authenticationService.getLoggedUsername();

		// criando o bean que sera editado no form
		Afazer afazer = new Afazer(0, username,"", LocalDate.now().plusYears(1), false);

		model.put("afazer", afazer);
		return "adicionar-afazer";
	}

	@PostMapping("/adicionar-afazer")	//    @Valid bean deve seguir as restricoes em Afazer.java
	public String adicionarAfazer(ModelMap model, @Valid Afazer afazer, BindingResult result) {

		if(result.hasErrors())  { // if validation errors
			return "adicionar-afazer";
		}
		String username = authenticationService.getLoggedUsername();
		afazer.setUsername(username);

		afazerRepository.save(afazer);
		
		return "redirect:afazeres"; // GET /afazeres
	}

	@GetMapping("/delete-afazer")
	public String deletarAfazer(@RequestParam int id) {

		afazerRepository.deleteById(id);

		return "redirect:afazeres";
	}

	@GetMapping("update-afazer")
	public String updatePage(@RequestParam int id, ModelMap model) {
		Afazer afazer = afazerRepository.findById(id).get();
		model.addAttribute("afazer", afazer); // bean que ira a adicionar-afazer.jsp

		return "adicionar-afazer";
	}

	@PostMapping("/update-afazer")
	public String atualizarAfazer(ModelMap model, @Valid Afazer afazer, BindingResult result) { // bean de adicionar-afazer.jsp é o afazer sendo parametizado

		if(result.hasErrors())  { // if validation errors
			return "adicionar-afazer";
		}

		String username = authenticationService.getLoggedUsername();
		afazer.setUsername(username);

		afazerRepository.save(afazer);

		return "redirect:afazeres"; // GET /afazeres
	}


}

