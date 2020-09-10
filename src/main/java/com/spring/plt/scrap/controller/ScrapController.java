package com.spring.plt.scrap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface ScrapController {

	public ModelAndView printExpertScrap(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView printManuScrap(HttpServletRequest request, HttpServletResponse response) throws Exception;

//	public ModelAndView scrapExpert(@ModelAttribute("scrap") ScrapVO scrap,
//			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView deleteExpertScrap(@RequestParam("no") int no, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView deleteManuScrap(@RequestParam("no") int no, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

}
