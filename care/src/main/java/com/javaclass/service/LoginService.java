package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.LoginVO;

public interface LoginService{
		//로그인
		public LoginVO getLogin(LoginVO vo);
		//마이페이지
		public List<LoginVO> myList(LoginVO vo);
		//정보수정창
		public List<LoginVO> memUp(LoginVO vo);
		//정보수정update
		public void updatemember(LoginVO vo);
}
