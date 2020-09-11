package com.spring.plt.scrap.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.scrap.vo.ScrapVO;

public interface ScrapDAO {

	public List printExpertScrap() throws DataAccessException;

	public List printManuScrap() throws DataAccessException;

//	public int scrapExpert(Map scrapMap) throws Exception;

	public void scrapExpert(ScrapVO scrapVO) throws DataAccessException;
	
	public void scrapManu(ScrapVO scrapVO) throws DataAccessException;

	public int deleteExpertScrap(int no) throws DataAccessException;
	
	public int deleteManuScrap(int no) throws DataAccessException;

}
