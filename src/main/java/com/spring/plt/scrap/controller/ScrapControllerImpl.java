package com.spring.plt.scrap.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.scrap.service.ScrapService;
import com.spring.plt.scrap.vo.ScrapVO;

@Controller("scrapController")
public class ScrapControllerImpl implements ScrapController{
	@Autowired
	private ScrapService scrapService;
	@Autowired
	private ScrapVO scrapVO;
	
	
	//scarp ��� ���
	@Override
	@RequestMapping(value="/scrap/printExpertScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printExpertScrap(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List expertScrapList = scrapService.printExpertScrap();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expertScrapList", expertScrapList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/scrap/printManuScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printManuScrap(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List manuScrapList = scrapService.printManuScrap();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("manuScrapList", manuScrapList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/scrap/printScrapAll.do",method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printScrapAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		Map allScrapMap = scrapService.printScrapAll();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allScrapMap", allScrapMap);
		return mav;
	}
	
	//insert scrap
	@Override
	@RequestMapping(value="/scrap/scrapExpert.do", method= {RequestMethod.GET, RequestMethod.POST})
	public void scrapExpert(@RequestParam("id") String expId,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		HttpSession session = request.getSession();
//		String compId = (String)session.getAttribute("compId"); �α��� ��� ���� �Ǹ� �Է� �ּ� ���� �Ұ�
		String compId = "compId";
		scrapVO.setCompid(compId);
		scrapVO.setExpid(expId);
		scrapService.scrapExpert(scrapVO);
	}
	
	@Override
	@RequestMapping(value="/scrap/scrapManu.do", method= {RequestMethod.GET, RequestMethod.POST})
	public void scrapManu(@RequestParam("id") String manuId,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		HttpSession session = request.getSession();
//		String compId = (String)session.getAttribute("compId"); �α��� ��� ���� �Ǹ� �Է� �ּ� ���� �Ұ�
		String compId = "compId";
		scrapVO.setCompid(compId);
		scrapVO.setManuid(manuId);
		scrapService.scrapManu(scrapVO);
		System.out.println("scrapController�Ϸ�!");
	}
	
	
//	@RequestMapping(value="/scrap/scrapExpert.do", method= {RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody
//	public ModelAndView scrapExpert(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		Map 
//	}
	
//	@Override
//	@RequestMapping(value="/scrap/scrapExpert.do", method={RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView scrapExpert(@ModelAttribute("scrap") ScrapVO scrap,
//								HttpServletRequest request, HttpServletResponse response) throws Exception{
//		String viewName = (String)request.getAttribute("veiwName");
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("html/text;charset=utf-8");
//		int scrapNO = 0;
//		scrapNO = scrapService.scrapExpert(scrap);
//		ModelAndView mav = new ModelAndView(viewName);
//		return mav;
//	}
	
	//delete scrap
	@Override
	@RequestMapping(value="/scrap/deleteExpertScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteExpertScrap(@RequestParam("no") int no, 
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		scrapService.deleteExpertScrap(no);
		ModelAndView mav = new ModelAndView("redirect:/scrap/printExpertScrap.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/scrap/deleteManuScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteManuScrap(@RequestParam("no") int no, 
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		scrapService.deleteManuScrap(no);
		ModelAndView mav = new ModelAndView("redirect:/scrap/printManuScrap.do");
		return mav;
	}
}
