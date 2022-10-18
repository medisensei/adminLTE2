package com.hendisantika.controller;

import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendisantika.entity.Film;
import com.hendisantika.enums.TypePersonne;
import com.hendisantika.service.FilmService;
import com.hendisantika.service.GenreService;
import com.hendisantika.service.NationaliteService;
import com.hendisantika.service.PersonneService;

@Controller
@RequestMapping("/film")
public class FilmController {
	FilmService filmService;
	GenreService genreService;
	NationaliteService nationaliteService;
	PersonneService personneService;

	public FilmController(FilmService filmService, 
			GenreService genreService, 
			NationaliteService nationaliteService,
			PersonneService personneService) {
		this.filmService = filmService;
		this.genreService=genreService;
		this.nationaliteService=nationaliteService;
		this.personneService=personneService;
	}

	@GetMapping
	public String index(Model model) {
		model.addAttribute("filmList", filmService.getList());
		return "film/index";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("genres",genreService.getList());
		model.addAttribute("nationalites",nationaliteService.getList());
		model.addAttribute("personnes",personneService.getList().stream()
				.filter(f->f.getTypePersonne()==TypePersonne.REALISATEUR)
				.collect(Collectors.toList()));
		return "film/form";
	}
	@GetMapping(value = "/update/{id}")
	public String add(@PathVariable Long id,Model model) {
		model.addAttribute("film", filmService.getOne(id));
		model.addAttribute("genres",genreService.getList());
		model.addAttribute("nationalites",nationaliteService.getList());
		model.addAttribute("personnes",personneService.getList().stream()
				.filter(f->f.getTypePersonne()==TypePersonne.REALISATEUR)
				.collect(Collectors.toList()));
		return "film/form";
	}
	@PostMapping(value = "/save")
	public String save(Film film) {
		filmService.save(film);
		return "redirect:/film";
	}
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		filmService.delete(id);
		return "redirect:/film";
	}

}
