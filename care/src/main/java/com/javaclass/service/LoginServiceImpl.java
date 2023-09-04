package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.LoginDAO;
import com.javaclass.dao.LoginDAOImpl;
import com.javaclass.domain.LoginVO;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO logindao;
	
	@Autowired
	private LoginDAOImpl logindaoimpl;
	//로그인
	public LoginVO getLogin(LoginVO vo) {
		return logindao.getLogin(vo);
	}
	//마이페이지 정보
	@Override
	public List<LoginVO> myList(LoginVO vo) {
		System.out.println("myList service에서 소환");
		return logindaoimpl.myList(vo);
	}
	
	//회원정보 수정페이지
	public List<LoginVO> memUp(LoginVO vo) {
		System.out.println("memUp service에서 소환");
		return logindaoimpl.memUp(vo);
	}
	
	
	//회원정보 수정할때 이용
	public void updatemember(LoginVO vo) {
		System.out.println("service에서 소환");
		logindao.updatemember(vo);
	}

	

	
	
}
