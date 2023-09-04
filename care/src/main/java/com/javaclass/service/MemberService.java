package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.MemberVO;

public interface MemberService {
	public MemberVO idCheck_Login(MemberVO vo);

	public MemberVO nickCheck_Login(MemberVO vo);

	public List<MemberVO> conid(MemberVO vo);

	public List<MemberVO> conpw(MemberVO vo);

	public void memberInsert(MemberVO vo);

	public void memberDelete(MemberVO vo);
	
	public MemberVO getMemberById(String id);
}
