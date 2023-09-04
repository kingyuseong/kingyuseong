package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.SdsMemberVO;

public interface SdsMemberDAO {
		// 아이디 중복체크
		SdsMemberVO sdsIdCheck(SdsMemberVO vo);
		
		// 닉네임 중복체크
		SdsMemberVO sdsNickCheck(SdsMemberVO vo);
		
		// 상담사가입기능 구현
		public void sdsMemberInsert(SdsMemberVO vo);
		
		// 상담사탈퇴기능 구현
		public void sdsmemberDelete(SdsMemberVO vo);
		
		// 아이디 찾기
		public List<SdsMemberVO> sdsconid(SdsMemberVO vo);
		
		// 비밀번호 찾기
		public List<SdsMemberVO> sdsconpw(SdsMemberVO vo);
}
