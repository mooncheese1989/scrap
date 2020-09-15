package com.spring.plt.scrap.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.scrap.vo.PageVO;
import com.spring.plt.scrap.vo.ScrapVO;

@Repository("scrapDAO")
public class ScrapDAOImpl implements ScrapDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//scrap
	//전문가 4개만 출력
	@Override
	public List<ScrapVO> printExpertScrap(String compId) throws DataAccessException{
		List<ScrapVO> expertScrapList = sqlSession.selectList("mapper.expertScrap.printExpertScrap", compId);
		System.out.println("ScrapDAO printExpertScrap(전문가 * 출력) 정상작동");
		return expertScrapList;
	}
	
	//전문가 * 출력
	@Override
	public List<ScrapVO> printExpertScrapAll(String compId) throws DataAccessException{
		List<ScrapVO> expertScrapAllList = sqlSession.selectList("mapper.expertScrap.printExpertScrapAll", compId);
		return expertScrapAllList;
	}
	
	//제조업체 4개만 출력
	@Override
	public List<ScrapVO> printManuScrap(String compId) throws DataAccessException{
		List<ScrapVO> manuScrapList = sqlSession.selectList("mapper.manuScrap.printManuScrap", compId);
		return manuScrapList;
	}
	
	//제조업체 * 출력
	@Override
	public List<ScrapVO> printManuScrapAll(String compId) throws DataAccessException{
		List<ScrapVO> manuScrapAllList = sqlSession.selectList("mapper.manuScrap.printManuScrapAll", compId);
		return manuScrapAllList;
		}
		
	//insert scrap
	@Override
	public void scrapExpert(ScrapVO scrapVO) throws DataAccessException{
		sqlSession.insert("mapper.expertScrap.scrapExpert", scrapVO);
		System.out.println("scrapDAO query ���� �Ϸ�!");
	}
	
	@Override
	public void scrapManu(ScrapVO scrapVO) throws DataAccessException{
		System.out.println("sqlDAO ����");
		sqlSession.insert("mapper.manuScrap.scrapManu", scrapVO);
		System.out.println("scrapDAO query ���� �Ϸ�!");
	}
	
	
	
	//delete scrap
	@Override
	public int deleteExpertScrap(int no) throws DataAccessException{
		int result = sqlSession.delete("mapper.expertScrap.deleteExpertScrap", no);
		return result;
	}
	
	@Override
	public int deleteManuScrap(int no) throws DataAccessException{
		int result = sqlSession.delete("mapper.manuScrap.deleteManuScrap", no);
		return result;
	}
	
	
	//paging
	@Override
	   public List<ScrapVO> selectAllScrap(PageVO pagevo) throws DataAccessException{
	      List<ScrapVO> ScrapList = null;
	      ScrapList = sqlSession.selectList("mapper.startup.selectAllstartup",pagevo);
	      return ScrapList;
	   }
	   
	   @Override
	   public int listCount() throws DataAccessException{
	      int listCount = sqlSession.selectOne("mapper.startup.listCount");
	      return listCount;
	   } 

	
	
	
}
