package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.MemberVO;

public interface MemberDAO {
	
	// 아이디 중복체크
	MemberVO idCheck(MemberVO vo);
	
	// 닉네임 중복체크
	MemberVO nickCheck(MemberVO vo);
	
	// 회원가입기능 구현
	public void memberInsert(MemberVO vo);
	
	// 회원탈퇴기능 구현
	public void memberDelete(MemberVO vo); 
	
	// 아이디 찾기
	public List<MemberVO> conid(MemberVO vo);
	
	// 비밀번호 찾기
	public List<MemberVO> conpw(MemberVO vo);
	
	public MemberVO getMemberById(String id); 
}
