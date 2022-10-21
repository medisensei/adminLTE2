package com.hendisantika.controller;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.hendisantika.entity.Seance;
import com.hendisantika.service.FilmService;
import com.hendisantika.service.SalleService;
import com.hendisantika.service.SeanceService;

@Controller
@RequestMapping("/seance")
public class SeanceController {
	
 SeanceService seanceService;	
 SalleService salleService;
 FilmService filmService;
 
 
 	public SeanceController(SeanceService seanceService, SalleService salleService, FilmService filmService) {
	
 		this.seanceService = seanceService;
 		this.salleService = salleService;
 		this.filmService = filmService;
}
	
 	@GetMapping
	public String index(@RequestParam(value = "filter", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date filter, Model model) {
 		
 		if (filter == null)
		model.addAttribute("seanceList", seanceService.getList());
 		else {
 			
 			model.addAttribute("filter", filter);
 			model.addAttribute("seanceList", seanceService.getFilteredList(filter));
 		}
		return "seance/index";
	}
 	
 	

 	
 	
 	@GetMapping(value = "/add")
	public String add(Model model) {
 		
 		model.addAttribute("seance",new Seance());
 		model.addAttribute("films",filmService.getList());
 		model.addAttribute("salles",salleService.getSalles());
 		
 		return "seance/form";
 		
 	}
 	
 	
	@PostMapping(value = "/save")
	public String save(Seance seance) {
		seanceService.save(seance);
		return "redirect:/seance";
	}

	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		seanceService.delete(id);
		return "redirect:/seance";
	}
	
	@GetMapping(value = "/update/{id}")
	public String add(@PathVariable Long id,Model model) {
		model.addAttribute("seance", seanceService.getOne(id));
		model.addAttribute("films",filmService.getList());
		model.addAttribute("salles",salleService.getSalles());
		
		return "seance/form";
	
	}
	

}
