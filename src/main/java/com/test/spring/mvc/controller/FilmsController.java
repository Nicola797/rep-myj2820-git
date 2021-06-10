package com.test.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.spring.mvc.model.Film;
import com.test.spring.mvc.service.FilmService;

@Controller
public class FilmsController {
	@Autowired
	private FilmService filmService;

	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public String showAllFilms(Model model) {
		model.addAttribute("films", filmService.getAllFilm());
		return "view-all-films";
	}

	@RequestMapping(value = "/films/remove-film/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFilm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("result-page");
		boolean resultService = filmService.removeFilmById(id);
		if (resultService == true) {
			mv.addObject("msg", "Film Deleted");
		} else {
			mv.addObject("msg", "Delete Failed");
		}
		return mv;
	}

	@RequestMapping(value = "/films/save-film/", method = RequestMethod.POST)
	public ModelAndView addFilm(@ModelAttribute("film") Film film, Model model) {
		ModelAndView mv = new ModelAndView("result-page");
		boolean resultService = filmService.addFilm(film);
		if (resultService == true) {
			mv.addObject("msg", "Film Saved");
		} else {
			mv.addObject("msg", "Save Failed");
		}
		return mv;
	}
}
