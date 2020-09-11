package com.spring.plt.scrap.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.scrap.vo.ScrapVO;

@Repository("scrapDAO")
public class ScrapDAOImpl implements ScrapDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//scrap목록 출력
	@Override
	public List printExpertScrap() throws DataAccessException{
		List<ScrapVO> expertScrapList = sqlSession.selectList("mapper.expertScrap.printExpertScrap");
		return expertScrapList;
	}
	
	@Override
	public List printManuScrap() throws DataAccessException{
		List<ScrapVO> manuScrapList = sqlSession.selectList("mapper.manuScrap.printManuScrap");
		return manuScrapList;
	}
	
	
	//insert scrap
	@Override
	public void scrapExpert(ScrapVO scrapVO) throws DataAccessException{
		sqlSession.insert("mapper.expertScrap.scrapExpert", scrapVO);
		System.out.println("scrapDAO query 수행 완료!");
	}
	
	@Override
	public void scrapManu(ScrapVO scrapVO) throws DataAccessException{
		System.out.println("sqlDAO 진입");
		sqlSession.insert("mapper.manuScrap.scrapManu", scrapVO);
		System.out.println("scrapDAO query 수행 완료!");
	}
	
	
//	@Override
//	public int scrapExpert(Map scrapMap) throws Exception{
//		return sqlSession.insert("mapper.expertScrap.scrapExpert", scrapMap);
//	}
	
//	@Override
//	public int scrapExpert(ScrapVO scrapVO) throws DataAccessException{
//		int scrapNO = sqlSession.insert("mapper.expert.scrapExpert", scrapVO);
//		return scrapNO;
//	}
	
	
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
}
