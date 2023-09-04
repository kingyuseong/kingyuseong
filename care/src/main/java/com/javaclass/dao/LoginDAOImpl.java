package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.LoginVO;

@Repository("LoginDAO")
public class LoginDAOImpl implements LoginDAO {
		@Autowired
		private SqlSessionTemplate mybatis;
		
		@Override
		public LoginVO getLogin(LoginVO vo) {
			System.out.println("=> Mybatis getLogin() 호출");
			return mybatis.selectOne("LoginDAO.getLogin", vo);
		}
		
		
		
		public void updatemember(LoginVO vo) {
			System.out.println("=> Mybatis updatemember() 호출");
			mybatis.update("LoginDAO.updatemember", vo);
		}

		@Override
		public List<LoginVO> myList(LoginVO vo) {
			System.out.println("=> Mybatis myList() 호출");
			List<LoginVO> list =mybatis.selectList("LoginDAO.myList", vo);
			return list;
		}
		
		public List<LoginVO> memUp(LoginVO vo) {
			System.out.println("=> Mybatis memUp() 호출");
			List<LoginVO> list =mybatis.selectList("LoginDAO.memUp", vo);
			return list;
		}
}
