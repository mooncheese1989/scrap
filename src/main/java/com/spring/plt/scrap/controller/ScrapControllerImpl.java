package com.spring.plt.scrap.controller;

import java.util.ArrayList;
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

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.scrap.service.ScrapService;
import com.spring.plt.scrap.vo.ScrapVO;

@Controller("scrapController")
public class ScrapControllerImpl implements ScrapController{
	@Autowired
	private ScrapService scrapService;
	@Autowired
	private ScrapVO scrapVO;
	
	
	//scarp ��� ���
	//전문가 * 출력
	@Override
	@RequestMapping(value="/scrap/printExpertScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printExpertScrapAll(@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List expertScrapAllList = scrapService.printExpertScrapAll(compId);
		System.out.println("scrapVO" + scrapVO);
		System.out.println("expertScrapAllList" + expertScrapAllList);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expertScrapAllList", expertScrapAllList);
		System.out.println("ScrapController printExpertScrapAll(전문가 * 출력) 정상작동");
		return mav;
	}
	
	//제조업체 * 출력
	@Override
	@RequestMapping(value="/scrap/printManuScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printManuScrapAll(@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List manuScrapAllList = scrapService.printManuScrapAll(compId);
		System.out.println("manuScrapAllList" + manuScrapAllList);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("manuScrapAllList", manuScrapAllList);
		return mav;
	}
	
	//제조업체/전문가 4개씩 출력
	@Override
	@RequestMapping(value="/scrap/printScrapAll.do",method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printScrapAll(@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		Map allScrapMap = scrapService.printScrap(compId);
		List expertScrapList = scrapService.printExpertScrap(compId);
		List manuScrapList = scrapService.printManuScrap(compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expertScrapList", expertScrapList);
		mav.addObject("manuScrapList", manuScrapList);
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
		HttpSession session = request.getSession();
//		String compId = (String)session.getAttribute("compId"); �α��� ��� ���� �Ǹ� �Է� �ּ� ���� �Ұ�
		String compId = "compId";
		String viewName = (String)request.getAttribute("viewName");
		scrapService.deleteExpertScrap(no);
		ModelAndView mav = new ModelAndView("redirect:/scrap/printExpertScrap.do?compId=" + compId);
		return mav;
		
		
	}
	
	@Override
	@RequestMapping(value="/scrap/deleteManuScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteManuScrap(@RequestParam("no") int no, 
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		scrapService.deleteManuScrap(no);
		HttpSession session = request.getSession();
//		String compId = (String)session.getAttribute("compId"); �α��� ��� ���� �Ǹ� �Է� �ּ� ���� �Ұ�
		String compId = "compId";
		ModelAndView mav = new ModelAndView("redirect:/scrap/printManuScrap.do?compId=" + compId);
		return mav;
	}
}
