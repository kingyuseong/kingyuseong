package com.javaclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaclass.domain.LoginVO;

@Mapper
public interface LoginDAO {
		public LoginVO getLogin(LoginVO vo);
		
		public List<LoginVO> myList(LoginVO vo);
		
		public List<LoginVO> memUp(LoginVO vo);
		
		public void updatemember(LoginVO vo);
}
