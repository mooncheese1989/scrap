package com.spring.plt.scrap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.scrap.dao.ScrapDAO;
import com.spring.plt.scrap.vo.ScrapVO;

@Service("scrapService")
@Transactional(propagation = Propagation.REQUIRED)
public class ScrapServiceImpl implements ScrapService{
	@Autowired
	ScrapDAO scrapDAO;
	
	//scrap
	//전문가 * 출력
	@Override
	public List<ScrapVO> printExpertScrapAll() throws Exception{
		List<ScrapVO> expertScrapAllList = scrapDAO.printExpertScrapAll();
		return expertScrapAllList;
	}
	
	//전문가 4개만 출력
	@Override
	public List<ScrapVO> printExpertScrap() throws Exception{
		List<ScrapVO> expertScrapList = scrapDAO.printExpertScrap();
		return expertScrapList;
	}
	
	//제조업체 * 출력
	@Override
	public List<ScrapVO> printManuScrapAll() throws Exception{
		List<ScrapVO> manuScrapAllList = scrapDAO.printManuScrapAll();
		return manuScrapAllList;
	}
	
	//제조업체 4개만 출력
		@Override
		public List<ScrapVO> printManuScrap() throws Exception{
			List<ScrapVO> manuScrapList = scrapDAO.printManuScrap();
			return manuScrapList;
		}
		
	@Override
	public Map<String, List<ScrapVO>> printScrap() throws Exception{
		Map<String, List<ScrapVO>> allScrapMap = new HashMap<String, List<ScrapVO>>();
		List<ScrapVO> expertScrapList = scrapDAO.printExpertScrap();
		List<ScrapVO> manuScrapList = scrapDAO.printManuScrap();
		allScrapMap.put("expertScrap", expertScrapList);
		allScrapMap.put("manuScrap", manuScrapList);
		System.out.println("allScrap 출력" + allScrapMap);
		return allScrapMap;
	}
	
	//insert scrap
	@Override
	public void scrapExpert(ScrapVO scrap) throws DataAccessException{
		scrapDAO.scrapExpert(scrap);
	}

	@Override
	public void scrapManu(ScrapVO scrap) throws DataAccessException{
		scrapDAO.scrapManu(scrap);
		System.out.println("scrapService �Ϸ�");
	}

	
	
	
//	@Override
//	public int scrapExpert(Map<String, Object> scrapMap) throws Exception{
//		System.out.println("scrapExpert() now loading..." + scrapMap);
//		return scrapDAO.scrapExpert(scrapMap);		
//	}
	
//	@Override
//	public int scrapExpert(ScrapVO scrap) throws Exception{
//		return scrapDAO.scrapExpert(scrap);
//	}
	
	//scrap delete
	@Override
	public int deleteExpertScrap(int no) throws DataAccessException{
		return scrapDAO.deleteExpertScrap(no);
	}
	
	@Override
	public int deleteManuScrap(int no) throws DataAccessException{
		return scrapDAO.deleteManuScrap(no);
	}
	
	@Override
	public List<ExpertVO> allExpert() {
		List<ExpertVO> expertList = scrapDAO.allExpert();
		return expertList;
	}
}
