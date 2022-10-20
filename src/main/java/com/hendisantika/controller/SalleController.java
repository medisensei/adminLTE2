package com.hendisantika.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hendisantika.entity.Salle;
import com.hendisantika.service.SalleService;

@Controller @RequestMapping("salle")
public class SalleController {
	SalleService salleService;
	public SalleController(SalleService salleService) {
		this.salleService=salleService;
	}
	
	
	@GetMapping
	public String index(@RequestParam(value = "filter", required = false) String filter, Model model) {
		
		if(filter == null)
		model.addAttribute("listSalles",salleService.getSalles());
		
		else {
			
			model.addAttribute("filter", filter);
			model.addAttribute("listSalles",salleService.getSalleByNum(Integer.parseInt(filter)));
			
			
		}
		
		return "salle/index";
	}
	@GetMapping(value= "/add")
	public String add(Model model) {
		model.addAttribute("salle",new Salle());
		return "salle/form";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id,Model model){
		model.addAttribute("salle",salleService.getSalle(id));
		return "salle/form";
	}
	@PostMapping(value = "/save")
	public String save(Salle salle) {
		salleService.setSalle(salle);
		return "redirect:/salle";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		salleService.deleteSalle(id);
		return "redirect:/salle";
	}
	
	@GetMapping(value = "/details/{id}")
	public String details(@PathVariable Long id,Model model) {
		Salle salle=salleService.getSalle(id);
		model.addAttribute("salle",salle);
		model.addAttribute("seances",salleService.getSeancesBySalle(salle.getID()));
		return "salle/details";
	}

}
