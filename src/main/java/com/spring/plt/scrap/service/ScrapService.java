package com.spring.plt.scrap.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.scrap.vo.PageVO;
import com.spring.plt.scrap.vo.ScrapVO;

public interface ScrapService {
	
	public List<ScrapVO> printExpertScrapAll(String compId) throws Exception;

	public List<ScrapVO> printExpertScrap(String compId) throws Exception;
	
	public List<ScrapVO> printManuScrapAll(String compId) throws Exception;
	
	public List<ScrapVO> printManuScrap(String compId) throws Exception;


//	public int scrapExpert(Map<String, Object> scrapMap) throws Exception;

	public void scrapExpert(ScrapVO scrap) throws DataAccessException;
	
	public void scrapManu(ScrapVO scrap) throws DataAccessException;

	public int deleteExpertScrap(int no) throws DataAccessException;
	
	public int deleteManuScrap(int no) throws DataAccessException;

	public Map<String, List<ScrapVO>> printScrap(String compId) throws Exception;

	public int listCount();

	public List<ScrapVO> selectAllScrap(PageVO pagevo);


}
