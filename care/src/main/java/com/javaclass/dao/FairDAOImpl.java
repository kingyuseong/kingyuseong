package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.FairVO;



@Repository("fairDAO") 
public class FairDAOImpl implements FairDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<FairVO> fairList(FairVO vo) {
		System.out.println("===> Mybatis fairList() 호출");
		List<FairVO> list = mybatis.selectList("FairDAO.fairList", vo);
		return list;
	}

	public List<FairVO> fairReserve(FairVO vo){
		List<FairVO> list = mybatis.selectList("FairDAO.fairReserve",vo);
		return list;
	}

}
