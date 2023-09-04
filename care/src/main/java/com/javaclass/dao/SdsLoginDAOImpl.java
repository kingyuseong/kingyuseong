package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.SdsLoginVO;

@Repository("SdsLoginDAO")
public class SdsLoginDAOImpl implements SdsLoginDAO {
		@Autowired
		private SqlSessionTemplate mybatis;
		
		@Override
		public SdsLoginVO sdsLogin(SdsLoginVO vo) {
			System.out.println("=> Mybatis sdsLogin() 호출");
			return mybatis.selectOne("SdsLoginDAO.sdsLogin", vo);
		}
		
		public void updatesdsmember(SdsLoginVO vo) {
			System.out.println("=> Mybatis updatesdsmember() 호출");
			mybatis.update("SdsLoginDAO.updatesdsmember", vo);
		}
		
		
		public List<SdsLoginVO> sdsList(SdsLoginVO vo) {
			System.out.println("=> Mybatis sdsList() 호출");
			List<SdsLoginVO> list =mybatis.selectList("SdsLoginDAO.sdsList", vo);
			return list;
		}
		
		public List<SdsLoginVO> sdsmemUp(SdsLoginVO vo) {
			System.out.println("=> Mybatis sdsmemUp() 호출");
			List<SdsLoginVO> list =mybatis.selectList("SdsLoginDAO.sdsmemUp", vo);
			return list;
		}
}
