package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.SupportVO;

@Repository("supportDAO")
public class SupportDAOImpl implements SupportDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<SupportVO> getSupportList() {
		System.out.println("===> Mybatis getSupportList() 호출");
		return mybatis.selectList("SupportDAO.getSupportList");

	}

}
