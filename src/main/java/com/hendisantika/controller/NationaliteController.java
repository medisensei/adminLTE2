package com.hendisantika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hendisantika.entity.Nationalite;
import com.hendisantika.service.NationaliteService;


@Controller @RequestMapping(value = "nationalite")
public class NationaliteController {
	NationaliteService nationaliteService;
	public NationaliteController(NationaliteService nationaliteService) {
		this.nationaliteService=nationaliteService;
	}
	
	@GetMapping
	public String index(@RequestParam(value = "filter", required = false) String filter,Model model) {
		if (filter == null)
		model.addAttribute("list",nationaliteService.getList());
		else {
			model.addAttribute("filter", filter);
			model.addAttribute("list", nationaliteService.getFilteredList(filter));
		}
		
		return "nationalite/index";
	}
	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("nationalite",new Nationalite());
		return "nationalite/form";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id,Model model) {
		model.addAttribute("nationalite",nationaliteService.getNationalite(id));
		return "nationalite/form";
	}
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		nationaliteService.delete(id);
		return "redirect:/nationalite";
	}
	@PostMapping(value = "save")
	public String save(Nationalite nationalite) {
		nationaliteService.save(nationalite);
		return "redirect:/nationalite";
	}

}
