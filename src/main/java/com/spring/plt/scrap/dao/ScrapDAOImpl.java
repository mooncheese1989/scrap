package com.spring.plt.scrap.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.scrap.vo.ScrapVO;

@Repository("scrapDAO")
public class ScrapDAOImpl implements ScrapDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//scrap
	//전문가 4개만 출력
	@Override
	public List<ScrapVO> printExpertScrap() throws DataAccessException{
		List<ScrapVO> expertScrapList = sqlSession.selectList("mapper.expertScrap.printExpertScrap");
		return expertScrapList;
	}
	
	//전문가 * 출력
	@Override
	public List<ScrapVO> printExpertScrapAll() throws DataAccessException{
		List<ScrapVO> expertScrapAllList = sqlSession.selectList("mapper.expertScrap.printExpertScrapAll");
		return expertScrapAllList;
	}
	
	//제조업체 4개만 출력
	@Override
	public List<ScrapVO> printManuScrap() throws DataAccessException{
		List<ScrapVO> manuScrapList = sqlSession.selectList("mapper.manuScrap.printManuScrap");
		return manuScrapList;
	}
	
	//제조업체 * 출력
	@Override
	public List<ScrapVO> printManuScrapAll() throws DataAccessException{
		List<ScrapVO> manuScrapAllList = sqlSession.selectList("mapper.manuScrap.printManuScrapAll");
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
	
	@Override
	public List<ExpertVO> allExpert(){
		List<ExpertVO> expertList = sqlSession.selectList("mapper.expert.allExpert");
		return expertList;
	}
	
}
