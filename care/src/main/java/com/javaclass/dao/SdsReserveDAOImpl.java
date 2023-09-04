package com.javaclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.ReserveVO;
import com.javaclass.domain.SdsReserveVO;

@Repository
public class SdsReserveDAOImpl implements SdsReserveDAO{
	private final SqlSession sqlSession;
	
	@Autowired
	public SdsReserveDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<SdsReserveVO> getSdsReserveList(SdsReserveVO vo){
		return sqlSession.selectList("SdsReserveDAO.getSdsReserveList", vo);
	}
	
	public void insertSdsReserve(SdsReserveVO vo) {
		System.out.println("===>  ReserveMapper insertSdsReserve() 호출");
		mybatis.insert("SdsReserveDAO.insertSdsReserve",vo);
	}
	
    //일정 수정부분
    public void updateSdsReserve(SdsReserveVO vo) {
    	System.out.println("===>  ReserveMapper updateSdsReserve() 호출");
    	mybatis.update("SdsReserveDAO.updateSdsReserve", vo);
    }

    //일정 삭제부분
    public void deleteSdsReserve(SdsReserveVO vo) {
    	System.out.println("===>  ReserveMapper dedeleteSdsReserveleteReserve() 호출");
    	mybatis.delete("SdsReserveDAO.deleteSdsReserve", vo);
    }
}
