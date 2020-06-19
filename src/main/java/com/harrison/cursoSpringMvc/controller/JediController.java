package com.harrison.cursoSpringMvc.controller;

import com.harrison.cursoSpringMvc.model.Jedi;
import com.harrison.cursoSpringMvc.model.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class JediController {

	@Autowired
	private JediRepository repository;

	@GetMapping("/")
	public String index(){ return "index"; }

	@GetMapping("/jedi")
	public ModelAndView jedi() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");
		modelAndView.addObject("jediList", repository.getAllJedi());
		return modelAndView;
	}

	@GetMapping("/new-jedi")
	public ModelAndView newJedi(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		modelAndView.addObject("jedi",new Jedi());
		return modelAndView;
	}

	@PostMapping("/new-jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes ){
		if(result.hasErrors()) {
			return "new-jedi";
		}
		repository.add(jedi);
		redirectAttributes.addFlashAttribute("message", "Objeto Cadastrado com sucesso!");
		return "redirect:jedi";
	}


}
